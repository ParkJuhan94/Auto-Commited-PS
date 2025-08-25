class Solution {
    static String[] possibles = {"aya", "ye", "woo", "ma"};
    
    public int solution(String[] babbling) {
        int answer = 0;        
        
        for(int i = 0; i < babbling.length; i++) {
            if(isPossible(babbling[i])) {
                answer++;
                System.out.println(babbling[i] + "\n");
            }
        }
        
        return answer;
    }
    
    public boolean isPossible(String str) {
        int prev = -1;  // 이 전 루프에서, 마지막으로 제거한 발음의 인덱스
        
        while(true) {
            boolean flag = false;        
            
            for(int i = 0; i < possibles.length; i++) {
                if(str.startsWith(possibles[i])) {
                    System.out.println(prev + ", " + i);
                    if(prev == i) {
                        return false;
                    }
                    
                    str = str.replaceFirst(possibles[i], "");
                    prev = i;
                    flag = true;   
                }                
            }    
            
            if(!flag) {
                break;
            }
        }
        
        return str.equals("") ? true : false;
    }
}