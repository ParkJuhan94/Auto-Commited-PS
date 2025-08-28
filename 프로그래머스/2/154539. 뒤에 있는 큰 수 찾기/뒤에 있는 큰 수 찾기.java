import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {        
        // 아직 뒷 큰수를 못 찾은 인덱스를 스택에 저장. 스택엔 값이 내림차순이 되게 유지        
        int[] answer = new int[numbers.length];
        Arrays.fill(answer, -1);
        Stack<Integer> stack = new Stack<>();
        
        for(int i = 0; i < numbers.length; i++) {
            int num = numbers[i];
            
            if(stack.isEmpty()) {
                stack.push(i);
            } else {
                while(!stack.isEmpty() && numbers[stack.peek()] < num) {
                    int pop = stack.pop();
                    answer[pop] = num;    
                }
                
                stack.push(i);               
            }                    
        }
        
        return answer;
    }
}