class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;        
        
        while(true) {
            int quo = n / a * b;
            int rem = n % a;
            
            n = quo + rem;
            answer += quo;
            
            if(n < a) {
               break; 
            }
        }
        
        return answer;
    }
}