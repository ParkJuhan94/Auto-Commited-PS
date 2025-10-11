class Solution {
    public int[] solution(long[] numbers) {
        int[] result = new int[numbers.length];
        
        for (int i = 0; i < numbers.length; i++) {
            String binary = Long.toBinaryString(numbers[i]);
            
            // 포화 이진트리 길이로 패딩 (2^h - 1 형태)
            int treeSize = getFullBinaryTreeSize(binary.length());
            String paddedBinary = String.format("%" + treeSize + "s", binary).replace(' ', '0');
            
            // 유효성 검사
            result[i] = isValidTree(paddedBinary, 0, paddedBinary.length() - 1, true) ? 1 : 0;
        }
        
        return result;
    }
    
    /**
     * 주어진 길이를 포함할 수 있는 최소 포화 이진트리 크기 계산
     * @param length 현재 이진 문자열 길이
     * @return 2^h - 1 형태의 최소 크기
     */
    private int getFullBinaryTreeSize(int length) {
        int h = 1;
        while ((1 << h) - 1 < length) {  // 2^h - 1 < length
            h++;
        }
        return (1 << h) - 1;
    }
    
    /**
     * 이진 트리 유효성 검사 (재귀)
     * @param binary 이진 문자열
     * @param start 현재 서브트리 시작 인덱스
     * @param end 현재 서브트리 끝 인덱스
     * @param parentIsNode 부모가 실제 노드(1)인지 여부
     * @return 유효하면 true
     */
    private boolean isValidTree(String binary, int start, int end, boolean parentIsNode) {
        if (start > end) {
            return true;  // 빈 구간
        }
        
        int mid = (start + end) / 2;  // 현재 서브트리의 루트
        char root = binary.charAt(mid);
        
        // 핵심 검증: 부모가 더미(0)인데 현재 노드가 1이면 불가능
        if (!parentIsNode && root == '1') {
            return false;
        }
        
        boolean isNode = (root == '1');
        
        // 좌우 서브트리 재귀 검증
        return isValidTree(binary, start, mid - 1, isNode) 
            && isValidTree(binary, mid + 1, end, isNode);
    }
}