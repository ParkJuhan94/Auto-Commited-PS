class Solution {
    public int solution(int n) {
        boolean[] isPrime = new boolean[n + 1];
        
        // 2~n까지 전부 소수(true)로 초기화
        for (int i = 2; i <= n; i++) {
            isPrime[i] = true;
        }
        
        // 에라토스테네스의 체
        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        
        // 소수 개수 세기
        int count = 0;
        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) count++;
        }
        
        return count;
    }
}