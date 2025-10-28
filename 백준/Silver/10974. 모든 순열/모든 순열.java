import java.io.*;

public class Main {
    static int N;
    static int[] arr;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        arr = new int[N];
        visited = new boolean[N + 1]; // 1~N 사용
        
        backtrack(0);
        System.out.print(sb);
    }
    
    static void backtrack(int depth) {
        // 종료 조건: N개를 모두 선택
        if (depth == N) {
            for (int i = 0; i < N; i++) {
                sb.append(arr[i]).append(' ');
            }
            sb.append('\n');
            return;
        }
        
        // 1부터 N까지 시도 (사전순 보장)
        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                visited[i] = true;  // 사용 체크
                arr[depth] = i;     // 현재 깊이에 i 배치
                backtrack(depth + 1); // 다음 깊이로
                visited[i] = false; // 복구 (백트래킹)
            }
        }
    }
}