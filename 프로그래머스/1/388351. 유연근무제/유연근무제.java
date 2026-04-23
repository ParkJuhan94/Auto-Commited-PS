class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        int n = schedules.length;
        
        for (int i = 0; i < n; i++) {
            int deadline = addTenMinutes(schedules[i]);
            boolean pass = true;
            
            for (int j = 0; j < 7; j++) {
                // 요일 계산: startday(1=월)부터 j일 후
                int dayOfWeek = (startday - 1 + j) % 7 + 1;
                
                // 토(6), 일(7)은 스킵
                if (dayOfWeek == 6 || dayOfWeek == 7) continue;
                
                if (timelogs[i][j] > deadline) {
                    pass = false;
                    break;
                }
            }
            
            if (pass) answer++;
        }
        
        return answer;
    }
    
    // 시간 형식(hhmm)에 10분 추가
    int addTenMinutes(int time) {
        int h = time / 100;
        int m = time % 100;
        m += 10;
        if (m >= 60) {
            h++;
            m -= 60;
        }
        return h * 100 + m;
    }
}