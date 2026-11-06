import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {        
        Map<String, Integer> inouts = new HashMap<>();
        Map<String, Integer> total = new HashMap<>();
        
        for(int i = 0; i < records.length; i++) {
            // 파싱    
            String[] record = records[i].split(" ");
            String[] times = record[0].split(":");
            int time = Integer.parseInt(times[0]) * 60 + Integer.parseInt(times[1]);
            String car = record[1];
            String inout = record[2];
            
            // 입출차 계산            
            if(inout.equals("IN")) {
                inouts.put(car, time);
            } else {
                // 출차는 map갱신 + 사용 시간 저장
                int useTime = (time - inouts.remove(car));
                total.put(car, total.getOrDefault(car, 0) + useTime);                              
            }
        }                            
        
        // 출차 안한 것 처리
        for(String key : inouts.keySet()) {
            total.put(key, total.getOrDefault(key, 0) + (23 * 60 + 59) - inouts.get(key));                              
        }
        
        int[] answer = new int[total.size()];
        ArrayList<String> answers = new ArrayList<>();
        for(String key : total.keySet()) {
            answers.add((key));            
        }
        Collections.sort(answers);
        // for(int i = 0; i < answers.size(); i++){
        //     System.out.println(answers.get(i));
        // }
        
        for(int i = 0; i < answers.size(); i++) {
            int totalTime = total.getOrDefault(answers.get(i), 0);
            // System.out.println(totalTime);
            
            if(totalTime <= fees[0]) {
                answer[i] = fees[1];
            } else {
                answer[i] = fees[1] + (totalTime - fees[0] + fees[2] - 1) / fees[2] * fees[3];
            }            
        }
        
        return answer;
    }
    
    
}