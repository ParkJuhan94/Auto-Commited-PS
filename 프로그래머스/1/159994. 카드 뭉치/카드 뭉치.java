class Solution {
    public String solution(
        String[] cards1, String[] cards2, String[] goal) {        
        int idx1 = -1;
        int idx2 = -1;
        
        for(int i = 0; i < goal.length; i++) {
            for(int j = 0; j < cards1.length; j++) {
                if(goal[i].equals(cards1[j])) {
                    if(j == idx1 + 1) {
                        idx1++;
                        break;
                    } else {
                        return "No";
                    }
                }
            }
            
            for(int j = 0; j < cards2.length; j++) {
                if(goal[i].equals(cards2[j])) {
                    if(j == idx2 + 1) {
                        idx2++;    
                        break;
                    } else {
                        return "No";
                    }
                }
            }
        }
        
        
        return "Yes";
    }
}