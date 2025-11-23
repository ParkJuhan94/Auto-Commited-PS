import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int len = str.length();
        
        PriorityQueue<String> pq = new PriorityQueue<>();
        
        for(int i = 1; i < len - 1; i++) {
            for(int j = i + 1; j < len; j++) {
                // 세 단어로 나누기 : ar / rest / ed
                String[] strArr = new String[3];
                
                // 각각 뒤집기 : ra / tser / de
                strArr[0] = new StringBuilder(str.substring(0, i)).reverse().toString();
                strArr[1] = new StringBuilder(str.substring(i, j)).reverse().toString();
                strArr[2] = new StringBuilder(str.substring(j)).reverse().toString();
                
                // 합치기 : ratserde 
                pq.add(strArr[0] + strArr[1] + strArr[2]);
            }
        }
        
        System.out.println(pq.poll());
    }        
    
}