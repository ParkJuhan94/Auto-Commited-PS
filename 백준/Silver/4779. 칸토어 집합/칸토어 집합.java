import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder output = new StringBuilder();
        String line;
        
        while ((line = br.readLine()) != null) {
            int n = Integer.parseInt(line.trim());
            output.append(cantor(n)).append('\n');
        }
        
        System.out.print(output);
    }
    
    static String cantor(int n) {
        if (n == 0) return "-";
        
        String prev = cantor(n - 1);
        StringBuilder sb = new StringBuilder();
        sb.append(prev);
        sb.append(" ".repeat(prev.length()));
        sb.append(prev);
        
        return sb.toString();
    }
}