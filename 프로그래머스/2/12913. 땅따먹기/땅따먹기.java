class Solution {
    int solution(int[][] land) {
        int N = land.length;
        int[][] maxArr = new int[N][4];
        for(int i = 0; i < 4; i++) {
            maxArr[0][i] = land[0][i];
        }
        for(int i = 1; i < N; i++) {
            for(int j = 0; j < 4; j++) {
                if(j == 0) {
                    maxArr[i][j] = Math.max(Math.max(maxArr[i - 1][1], maxArr[i - 1][2]), maxArr[i - 1][3]) + land[i][j];
                } else if(j == 1) {
                    maxArr[i][j] = Math.max(Math.max(maxArr[i - 1][0], maxArr[i - 1][2]), maxArr[i - 1][3]) + land[i][j];
                } else if(j == 2) {
                    maxArr[i][j] = Math.max(Math.max(maxArr[i - 1][0], maxArr[i - 1][1]), maxArr[i - 1][3]) + land[i][j];
                } else {
                    maxArr[i][j] = Math.max(Math.max(maxArr[i - 1][0], maxArr[i - 1][1]), maxArr[i - 1][2]) + land[i][j];
                }
            }
        }
        
        int answer = 0;
        for(int i = 0; i < 4; i++) {
            answer = Math.max(answer, maxArr[N - 1][i]);
        }
        return answer;
    }
}