import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int n = Integer.parseInt(br.readLine());
        Deque<Integer> queue = new LinkedList<>();  // ⭐ Deque 쓰는 이유: back() 때문
        
        for (int i = 0; i < n; i++) {
            String[] cmd = br.readLine().split(" ");
            
            switch (cmd[0]) {
                case "push":
                    queue.offer(Integer.parseInt(cmd[1]));
                    break;
                    
                case "pop":
                    sb.append(queue.isEmpty() ? -1 : queue.poll()).append('\n');
                    break;
                    
                case "size":
                    sb.append(queue.size()).append('\n');
                    break;
                    
                case "empty":
                    sb.append(queue.isEmpty() ? 1 : 0).append('\n');
                    break;
                    
                case "front":
                    sb.append(queue.isEmpty() ? -1 : queue.peek()).append('\n');
                    break;
                    
                case "back":
                    sb.append(queue.isEmpty() ? -1 : ((LinkedList<Integer>)queue).peekLast()).append('\n');
                    break;
            }
        }
        
        System.out.print(sb);
    }
}