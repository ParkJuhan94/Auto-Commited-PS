import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String line;
        
        while ((line = br.readLine()) != null) {
            int n = Integer.parseInt(line.trim());
            sb.append(findLength(n)).append('\n');
        }
        
        System.out.print(sb);
    }
    
    static int findLength(int n) {
        int remainder = 0;
        int length = 0;
        
        while (true) {
            remainder = (remainder * 10 + 1) % n;
            length++;
            
            if (remainder == 0) {
                return length;
            }
        }
    }
}