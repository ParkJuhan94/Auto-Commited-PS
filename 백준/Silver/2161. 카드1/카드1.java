import java.io.*;
import java.util.*;

public class Main {
    static int N;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        Queue<Integer> q = new LinkedList<>();
        for(int i = 1; i <= N; i++) {
            q.add(i);
        }
        
        while(q.size() != 1) {
            int first = q.poll();
            System.out.print(first + " ");
            
            int second = q.poll();
            q.add(second);
        }
        
        System.out.print(q.poll());        
    }
}