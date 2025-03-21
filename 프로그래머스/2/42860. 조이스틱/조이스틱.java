class Solution {
    public int solution(String name) {
        int n = name.length();
        int answer = 0;
        
        // 1. 상하 조작: 각 문자별로 변경 횟수를 누적
        for (int i = 0; i < n; i++) {
            char ch = name.charAt(i);
            // 'A'에서 ch로 가기 위한 위/아래 이동 횟수 중 최소값
            answer += Math.min(ch - 'A', 'Z' - ch + 1);
        }
        
        // 2. 좌우 조작: 기본적으로 오른쪽으로만 이동하는 경우 n-1번
        int move = n - 1;
        
        // 각 위치 i에서 이후 연속된 'A' 구간을 확인하며 최소 좌우 이동 계산
        for (int i = 0; i < n; i++) {
            int next = i + 1;
            // 다음 문자가 'A'인 동안 next 증가
            while (next < n && name.charAt(next) == 'A') {
                next++;
            }
            // i: 오른쪽으로 이동한 횟수, n-next: 오른쪽에서 건너뛴 횟수
            move = Math.min(move, i + n - next + Math.min(i, n - next));
        }
        
        answer += move;
        return answer;
    }
}