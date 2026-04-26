class Solution {
    public int solution(int n, int w, int num) {
        // 그리드 생성
        int rows = (n + w - 1) / w;
        int[][] grid = new int[rows][w];
        
        int box = 1;
        for (int r = 0; r < rows; r++) {
            if (r % 2 == 0) { // 왼→오
                for (int c = 0; c < w && box <= n; c++)
                    grid[r][c] = box++;
            } else { // 오→왼
                for (int c = w - 1; c >= 0 && box <= n; c--)
                    grid[r][c] = box++;
            }
        }
        
        // num의 위치 찾기
        int targetRow = -1, targetCol = -1;
        outer:
        for (int r = 0; r < rows; r++)
            for (int c = 0; c < w; c++)
                if (grid[r][c] == num) {
                    targetRow = r;
                    targetCol = c;
                    break outer;
                }
        
        // 같은 열에서 targetRow 이상인 상자 개수
        int count = 0;
        for (int r = targetRow; r < rows; r++)
            if (grid[r][targetCol] != 0) count++;
        
        return count;
    }
}