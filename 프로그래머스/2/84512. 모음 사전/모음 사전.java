import java.util.*;

public class Solution {
    static List<String> dict = new ArrayList<>();
    static String[] vowels = {"A", "E", "I", "O", "U"};

    public int solution(String word) {
        dfs("", 0);
        return dict.indexOf(word) + 1;
    }

    public void dfs(String current, int depth) {
        if (depth == 5) {
            dict.add(current);  // 5글자는 여기서 저장
            return;
        }

        if(!current.isEmpty()) {
            dict.add(current); // depth < 5일 때도 저장   
        }

        for (String v : vowels) {
            dfs(current + v, depth + 1);
        }
    }
}
