class Solution {
    public int solution(int number, int limit, int power) {
        int[] divisorCounts = divisorCountsUpTo(number);
        
        int answer = 0;        
        for(int i = 1; i <= number; i++) {
            if(divisorCounts[i] > limit) {
                answer += power;
            } else {
                answer += divisorCounts[i];
            }
        }        
        
        return answer;
    }
    
    // 1..n 각 수의 약수 개수를 채워서 반환 (cnt[i] = i의 약수 개수)
static int[] divisorCountsUpTo(int n) {
    int[] cnt = new int[n + 1];
    for (int d = 1; d <= n; d++) {
        for (int m = d; m <= n; m += d) {
            cnt[m]++; // d는 m의 약수
        }
    }
    return cnt;
}   
}