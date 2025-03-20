import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        List<Integer> answer = new ArrayList<>();
        int N = commands.length;
        
        for(int i = 0; i < N; i++) {
            int[] slicedArray = Arrays.copyOfRange(array, commands[i][0] - 1, commands[i][1]);
            // System.out.println(Arrays.toString(slicedArray));
            Arrays.sort(slicedArray);
            answer.add(slicedArray[commands[i][2] - 1]);
        }
        
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}