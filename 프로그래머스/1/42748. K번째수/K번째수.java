import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int n = commands.length;
        int[] answer = new int[n];
        
        for(int i = 0; i < n; i++) {
            int[] command = commands[i];
            int start = command[0] - 1;
            int end = command[1] - 1;
            int target = command[2] - 1;
            
            ArrayList<Integer> nums = new ArrayList<>();
            for(int j = start; j <= end; j++) {
                nums.add(array[j]);
            }
            Collections.sort(nums);
            
            answer[i] = nums.get(target);
        }
        
        return answer;
    }
}