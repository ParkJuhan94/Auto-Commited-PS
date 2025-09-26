import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        HashMap<Character, Integer> map;
        
        int index = 0;
        int len = s.length();
        
        for(int i = 0; i < len; i++) {        
            char c = s.charAt(i);
            map = new HashMap<>();
            map.put(c, map.getOrDefault(c, 0) + 1);
            int countEqual = 1;
            int countDiff = 0;
         
            while(true) {
                i++;
                if(i == len) {
                    if(!map.isEmpty()) {
                        answer++;
                    }
                    break;
                }
            
                if(s.charAt(i) == c) {
                    countEqual++;
                } else {
                    countDiff++;
                }
                
                if(countEqual == countDiff) {
                    answer++; 
                    break;
                }                       
            }                                    
        }
        
        
        return answer;
    }
}