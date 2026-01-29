import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        int k = Integer.parseInt(br.readLine());
        int chunkSize = N / k;  // 각 사람이 담당하는 구간 크기
        
        // 각 구간을 정렬
        for (int i = 0; i < N; i += chunkSize) {
            Arrays.sort(arr, i, i + chunkSize);
        }
        
        // 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(arr[i]);
            if (i < N - 1) sb.append(' ');
        }
        System.out.println(sb);
    }
}