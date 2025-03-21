import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        int N = records.length;        
        int defTime = fees[0];
        int defCost = fees[1];
        int perTime = fees[2];
        int perCost = fees[3];
        
        // <차량번호, {현재시간, 입/출차}>
        // 입차는 0, 출차는 1
        Map<String, int[]> parkingInOuts = new HashMap<>();    
        // <차량번호, 누적시간>
        Map<String, Integer> parkingTimes = new HashMap<>();      
        
        for(int i = 0; i < N; i++) {
            String[] record = records[i].split(" ");
            String[] times = record[0].split(":");
            int time = Integer.parseInt(times[0]) * 60 + Integer.parseInt(times[1]);
                    
            if(parkingInOuts.containsKey(record[1])) {  // 기록이 있을 때
                if(record[2].equals("IN")) {  // 입차일 때
                    // 출차기록 넣기만
                    parkingInOuts.put(record[1], new int[]{time, 0});
                } else {    // 출차일 때
                    // 누적시간 넣고, 출차기록 넣고
                    parkingTimes.put(
                        record[1],
                        parkingTimes.getOrDefault(record[1], 0) + 
                        (time - parkingInOuts.get(record[1])[0])
                    );
                    
                    parkingInOuts.put(record[1], new int[]{time, 1});
                }                                
            } else {    // 기록이 없을 때
                int inOrOut = 1;
                if(record[2].equals("IN")) {
                    inOrOut = 0;
                }
                
                parkingInOuts.put(record[1], new int[]{time, inOrOut});                
            }                                
        }
        
        // 입차 이후 출차된 내역 없을 때
        for(String key : parkingInOuts.keySet()) {
            if(parkingInOuts.get(key)[1] == 0) {
                parkingTimes.put(key, 
                    parkingTimes.getOrDefault(key, 0) + (1439 - parkingInOuts.get(key)[0])
                );
            }
        }
        
        // 차량번호 정렬
        List<String> carNums = new ArrayList<>();
        for(String key : parkingTimes.keySet()) {
            carNums.add(key);
        }
        Collections.sort(carNums);
        
        // 요금 계산    
        int[] answer = new int[parkingTimes.size()];
        int idx = 0;
        
        for(String carNum : carNums) {
            if(parkingTimes.get(carNum) > defTime) {
                answer[idx++] = defCost + (int)Math.ceil((double)(parkingTimes.get(carNum) - defTime) / perTime) * perCost;
            } else {
                answer[idx++] = defCost;
            }
            
            // System.out.println(parkingTimes.get(carNum));
        }
                                
        return answer;
    }
}