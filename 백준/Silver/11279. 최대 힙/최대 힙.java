import java.util.*;
import java.io.*;

public class Main {
    static int N;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i < N; i++) {
            int input = Integer.parseInt(br.readLine());
            
            if(input == 0) {
                if(pq.isEmpty()) {
                    System.out.println(0);
                } else {
                    System.out.println(pq.poll());                    
                }
            } else {
                pq.add(input);                
            }

        }                     
        
    }

}