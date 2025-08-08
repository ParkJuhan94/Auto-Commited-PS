import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        ArrayList<Integer> answerList = new ArrayList<>();
        int[] array1 = {1, 2, 3, 4, 5};
        int[] array2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] array3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        int score1 = 0;
        int score2 = 0;
        int score3 = 0;
        
        for(int i = 0; i < answers.length; i++) {
            // 1
            if(answers[i] == array1[i % 5]) {
                score1++;
            }
            // 2
            if(answers[i] == array2[i % 8]) {
                score2++;
            }
            // 3
            if(answers[i] == array3[i % 10]) {
                score3++;
            }
        }
        
        int maxScore = 0;
        maxScore = Math.max(maxScore, score1);
        maxScore = Math.max(maxScore, score2);
        maxScore = Math.max(maxScore, score3);
        
        if(score1 == maxScore) {
            answerList.add(1);
        }
        if(score2 == maxScore) {
            answerList.add(2);
        }
        if(score3 == maxScore) {
            answerList.add(3);
        }
        
        int[] answer = new int[answerList.size()];
        for(int i = 0; i < answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }
        
        return answer;
    }
}