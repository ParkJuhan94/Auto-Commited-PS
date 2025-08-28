import java.util.*;

class Solution {
    // 무방향 간선 정규화 키
    static String edgeKey(int r1, int c1, int r2, int c2) {
        if (r1 > r2 || (r1 == r2 && c1 > c2)) {
            int tr = r1, tc = c1; r1 = r2; c1 = c2; r2 = tr; c2 = tc;
        }
        return r1 + "," + c1 + ":" + r2 + "," + c2;
    }

    public int solution(String dirs) {
        int r = 0, c = 0, answer = 0;
        Set<String> edges = new HashSet<>();

        for (char m : dirs.toCharArray()) {
            int nr = r, nc = c;

            if(m == 'U') nr = r - 1;            
            if(m == 'R') nc = c + 1;            
            if(m == 'D') nr = r + 1;            
            if(m == 'L') nc = c - 1;            

            if (nr < -5 || nr > 5 || nc < -5 || nc > 5) continue;

            String key = edgeKey(r, c, nr, nc);
            if (edges.add(key)) answer++;

            r = nr; c = nc;
        }
        
        return answer;
    }
}
