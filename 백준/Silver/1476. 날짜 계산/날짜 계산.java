import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int E = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        int year = 1;
        
        while (true) {
            int e = (year - 1) % 15 + 1;
            int s = (year - 1) % 28 + 1;
            int m = (year - 1) % 19 + 1;
            
            if (e == E && s == S && m == M) {
                System.out.println(year);
                break;
            }
            year++;
        }
    }
}