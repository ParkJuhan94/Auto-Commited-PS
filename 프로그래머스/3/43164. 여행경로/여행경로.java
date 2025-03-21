import java.util.*;

class Solution {
    // 티켓 사용 여부 체크 배열
    boolean[] used;
    // 정답 경로 (문제가 요구하는 경로는 하나만 출력하면 되므로, 조건 만족 시 바로 반환)
    List<String> answer;
    // 이미 정답을 찾았는지 확인 (백트래킹 시 불필요한 탐색 중단)
    boolean found = false;
    
    public String[] solution(String[][] tickets) {
        int n = tickets.length;
        used = new boolean[n];
        // 알파벳 순서를 맞추기 위해 티켓을 정렬
        Arrays.sort(tickets, (a, b) -> {            
            if(a[0].equals(b[0])) {
                return a[1].compareTo(b[1]);
            }
            return a[0].compareTo(b[0]);
        });
        
        List<String> route = new ArrayList<>();
        route.add("ICN"); // 시작은 항상 "ICN"
        dfs("ICN", tickets, route, 0);
        
        return answer.toArray(new String[0]);
    }
    
    private void dfs(String current, String[][] tickets, List<String> route, int count) {
        // 모든 티켓을 사용한 경우, 정답 경로를 저장 후 종료
        if(count == tickets.length) {
            answer = new ArrayList<>(route);
            found = true;
            return;
        }
        
        // 티켓 배열 전체를 순회하며 사용 가능한 티켓(아직 사용하지 않았고, 출발지가 현재 공항인 티켓)을 찾습니다.
        for(int i = 0; i < tickets.length; i++) {
            if(!used[i] && tickets[i][0].equals(current)) {
                used[i] = true;
                route.add(tickets[i][1]);
                dfs(tickets[i][1], tickets, route, count + 1);
                
                // 정답을 찾은 경우 더 이상 탐색할 필요가 없음
                if(found) return;
                
                // 백트래킹: 사용 상태 복구 및 마지막 경로 제거
                used[i] = false;
                route.remove(route.size() - 1);
            }
        }
    }
}
