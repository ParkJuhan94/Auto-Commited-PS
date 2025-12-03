import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static double[] arr;
    static double answer = 0;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new double[N];
        for(int i = 0; i < N; i++) {
            arr[i] = Double.parseDouble(br.readLine());
        }
        
        for(int i = 0; i < N; i++) {
            double multi = 1;
            
            for(int j = i; j < N; j++) {
                multi *= arr[j];
                answer = Math.max(answer, multi);
            }
        }
        
        System.out.printf("%.3f\n", answer);
    }
}
