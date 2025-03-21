import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        // List로 변환
        List<Integer> lostList = new ArrayList<>();
        for (int l : lost) {
            lostList.add(l);
        }
        List<Integer> reserveList = new ArrayList<>();
        for (int r : reserve) {
            reserveList.add(r);
        }
        
        // lost와 reserve에 동시에 있는 학생은 제거 (자기 체육복만 가진다고 처리)
        List<Integer> intersection = new ArrayList<>(lostList);
        intersection.retainAll(reserveList);
        lostList.removeAll(intersection);
        reserveList.removeAll(intersection);
        
        // 정렬
        Collections.sort(lostList);
        Collections.sort(reserveList);
        
        // 체육 수업 참여 가능 학생 수 (초기에는 전체 학생수에서 lost 리스트에 남은 학생 수를 뺀 값)
        int answer = n - lostList.size();
        
        // 그리디 방식으로 빌려주기
        for (int lostStudent : lostList) {
            // 앞번호 학생부터 확인 (더 작은 번호부터 처리하는 것이 그리디 방식)
            if (reserveList.contains(lostStudent - 1)) {
                answer++;
                reserveList.remove(Integer.valueOf(lostStudent - 1));
            } else if (reserveList.contains(lostStudent + 1)) {
                answer++;
                reserveList.remove(Integer.valueOf(lostStudent + 1));
            }
        }
        
        return answer;
    }
}
