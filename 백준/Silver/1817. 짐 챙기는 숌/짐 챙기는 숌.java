import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        // N=0 예외 처리
        if (N == 0) {
            System.out.println(0);
            return;
        }
        
        int[] books = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            books[i] = Integer.parseInt(st.nextToken());
        }
        
        int boxes = 1;  // 최소 1개 박스
        int currentWeight = 0;  // 현재 박스 무게
        
        for (int i = 0; i < N; i++) {
            if (currentWeight + books[i] <= M) {
                // 현재 박스에 넣을 수 있음
                currentWeight += books[i];
            } else {
                // 새 박스 시작
                boxes++;
                currentWeight = books[i];
            }
        }
        
        System.out.println(boxes);
    }
}