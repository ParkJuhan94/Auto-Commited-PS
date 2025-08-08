import java.util.*;

class Solution {
    static int answer = 0;
    
    public int solution(int[] numbers, int target) {                
                
        dfs(0, 0, 0, numbers, target);
        
        return answer;
    }
    
    public void dfs(int depth, int cur, int sum, int[] numbers, int target) {
        if(depth == numbers.length) {
            if(sum == target) {
                answer++;
            }
            return;                        
        }
        
        dfs(depth + 1, cur + 1, sum + numbers[cur], numbers, target);
        dfs(depth + 1, cur + 1, sum - numbers[cur], numbers, target);
    }

}