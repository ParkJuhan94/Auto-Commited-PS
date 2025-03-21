import java.util.*;

class Solution {
    // 일반 BFS로 문제 풀이
    public int solution(String begin, String target, String[] words) {
        // target이 words에 없으면 변환이 불가능하므로 0을 반환합니다.
        boolean exists = false;
        for (String word : words) {
            if (word.equals(target)) {
                exists = true;
                break;
            }
        }
        if (!exists) return 0;
        
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(begin, 0));
        boolean[] visited = new boolean[words.length];
        
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            if (current.word.equals(target)) {
                return current.level;
            }
            
            // words 배열 내에서 한 글자만 다른 단어를 찾아 이동합니다.
            for (int i = 0; i < words.length; i++) {
                if (!visited[i] && isOneLetterDiff(current.word, words[i])) {
                    visited[i] = true;
                    queue.add(new Node(words[i], current.level + 1));
                }
            }
        }
        return 0;
    }
    
    // 두 단어가 한 글자만 다른지 확인하는 메서드
    private boolean isOneLetterDiff(String word1, String word2) {
        int diffCount = 0;
        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) != word2.charAt(i)) {
                diffCount++;
            }
        }
        return diffCount == 1;
    }
    
    // BFS 노드 정보를 담기 위한 내부 클래스
    class Node {
        String word;
        int level;
        Node(String word, int level) {
            this.word = word;
            this.level = level;
        }
    }
}
