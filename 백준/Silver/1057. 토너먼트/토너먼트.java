import java.io.*;
import java.util.*;

public class Main {
    static int N;
 
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        Queue<Integer> q = new LinkedList<>();
        for(int i = 1; i <= N; i++) {
            q.add(i);
        }
        
        int answer = 1;
        
        while(true) {
            int size = q.size();
            
            for(int i = 0; i < size; i+=2) {
                // 두명 중 한명씩 넣고, 마지막 혼자 남으면 넣기
                if(i % 2 == 0) {
                    int cur = q.poll();                    
                    
                    if(i != size - 1) {
                        int next = q.poll();
                        
                        if(cur == a && next == b) {
                            System.out.print(answer);
                            return;
                        } else if(cur == b && next == a) {
                            System.out.print(answer);
                            return;
                        }
                        
                        if(cur == a || cur == b) {
                            q.add(cur);
                        } else if (next == a || next == b) {
                            q.add(next);
                        } else {
                            q.add(cur);
                        }
                        
                    } else {
                        q.add(cur);   
                    }                                       
                }
            }        
            
            answer++;
        }       
        
    }
    
}