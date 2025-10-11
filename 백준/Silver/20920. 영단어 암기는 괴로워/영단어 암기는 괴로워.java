import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        PriorityQueue<Word> pq = new PriorityQueue<>();
        HashMap<String, Integer> map = new HashMap<>();
        
        for(int i = 0; i < N; i++) {
            String word = br.readLine();
            if(word.length() < M) continue;
            
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        
        for(String word : map.keySet()) {
            pq.add(new Word(word, map.get(word)));   
        }                
        
        StringBuilder sb = new StringBuilder();        
       
        while(!pq.isEmpty()) {
            Word cur = pq.poll();
            sb.append(cur.word + "\n");
        }
        
        System.out.println(sb.toString());
    }
    
    static class Word implements Comparable<Word>{
        String word;
        int count;
        int len;
        
        public Word(String word, int count) {
            this.word = word;
            this.len = word.length();
            this.count = count;
        }
        
        @Override
        public int compareTo(Word o) {
            if(this.count == o.count) {
                if(this.len == o.len) {
                    return this.word.compareTo(o.word);
                } else {
                    return o.len - this.len;
                }
            } else {
                return o.count - this.count;
            }
        }
    }
}

    