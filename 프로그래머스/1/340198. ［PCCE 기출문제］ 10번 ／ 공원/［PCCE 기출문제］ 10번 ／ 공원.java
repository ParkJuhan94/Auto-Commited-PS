import java.util.Arrays;

class Solution {
    public int solution(int[] mats, String[][] park) {
        int rows = park.length;
        int cols = park[0].length;
        
        Arrays.sort(mats);
        
        // 큰 것부터 확인
        for (int i = mats.length - 1; i >= 0; i--) {
            int size = mats[i];
            
            // 모든 시작점에서 size x size 가능한지 확인
            for (int r = 0; r <= rows - size; r++) {
                for (int c = 0; c <= cols - size; c++) {
                    if (canPlace(park, r, c, size)) {
                        return size;
                    }
                }
            }
        }
        
        return -1;
    }
    
    boolean canPlace(String[][] park, int r, int c, int size) {
        for (int i = r; i < r + size; i++)
            for (int j = c; j < c + size; j++)
                if (!park[i][j].equals("-1")) return false;
        return true;
    }
}