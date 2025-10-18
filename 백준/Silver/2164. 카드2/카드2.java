import java.util.*;
import java.io.*;

public class Main {
    static int N;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        
        Queue<Integer> q = new LinkedList<>();
        for(int i = 1; i <= N; i++) {
            q.add(i);
        }
        
        while(true) {    
            if(q.size() == 1) {
                break;
            }

            q.poll();
            int cur = q.poll();
            q.add(cur);            
        }
        
        System.out.println(q.poll());
    }

}