import java.util.*;

class Solution {
    public int solution(int[] nums) {
        // 최대 합: 1000 + 1000 + 1000 = 3000
        boolean[] isPrime = sieve(3000);

        int n = nums.length;
        int count = 0;
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    int sum = nums[i] + nums[j] + nums[k];
                    if (isPrime[sum]) count++;
                }
            }
        }
        return count;
    }

    private boolean[] sieve(int max) {
        boolean[] prime = new boolean[max + 1];
        Arrays.fill(prime, true);
        prime[0] = prime[1] = false;
        for (int p = 2; p * p <= max; p++) {
            if (!prime[p]) continue;
            for (int m = p * p; m <= max; m += p) {
                prime[m] = false;
            }
        }
        return prime;
    }
}
