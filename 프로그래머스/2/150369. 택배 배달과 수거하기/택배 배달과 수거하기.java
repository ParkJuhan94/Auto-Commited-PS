class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        
        // 배달/수거 남은 용량 (뒤에서부터 누적)
        int deliverRemain = 0;
        int pickupRemain = 0;
        
        // 가장 먼 집부터 처리 (뒤에서부터)
        for(int i = n - 1; i >= 0; i--) {
            deliverRemain += deliveries[i];
            pickupRemain += pickups[i];
            
            // 이번 위치에서 여러 번 왕복이 필요한 경우
            while(deliverRemain > 0 || pickupRemain > 0) {
                // 이번 여행의 왕복 거리 = (i+1) * 2
                // i는 0-indexed이므로 실제 거리는 i+1
                answer += (i + 1) * 2;
                
                // 배달/수거 각각 cap만큼 처리
                deliverRemain -= cap;
                pickupRemain -= cap;
            }
        }
        
        return answer;
    }
}