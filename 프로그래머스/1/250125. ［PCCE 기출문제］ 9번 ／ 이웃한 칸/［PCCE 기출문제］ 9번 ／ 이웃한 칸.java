

class Solution {
    int[] dr = {-1, 0, 1, 0};
    int[] dc = {0, 1, 0, -1};
    
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        int R = board.length;
        int C = board[0].length;
        
        for(int i = 0; i < 4; i++) {
            int nr = h + dr[i];
            int nc = w + dc[i];
            
            if(0 <= nr && nr < R && 0 <= nc && nc < C 
               && board[h][w].equals(board[nr][nc])) {
               answer++;   
            }
        }                
        
        return answer;
    }
}