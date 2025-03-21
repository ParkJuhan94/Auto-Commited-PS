import java.util.*;

class Solution {
    int answer = 0;
    
    public int solution(int[] numbers, int target) {                
                
        dfs(numbers, target, 0, 0, 0);
        
        return answer;
    }
    
    void dfs(int[] numbers, int target, int depth, int start, int sum) {
        if(depth == numbers.length) {
            if(sum == target) {
                answer++;
            }
            return;
        }
        
        for(int i = start; i < numbers.length; i++) {
            dfs(numbers, target, depth + 1, i + 1, sum + numbers[start]);
            dfs(numbers, target, depth + 1, i + 1, sum - numbers[start]);
        }
    }
}