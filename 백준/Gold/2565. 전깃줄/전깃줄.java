import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        int[][] wires = new int[N][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            wires[i][0] = Integer.parseInt(st.nextToken()); // A
            wires[i][1] = Integer.parseInt(st.nextToken()); // B
        }
        
        // A 기준 오름차순 정렬
        Arrays.sort(wires, (a, b) -> a[0] - b[0]);
        
        // B의 값들로 LIS 찾기
        int[] B = new int[N];
        for (int i = 0; i < N; i++) {
            B[i] = wires[i][1];
        }
        
        int lisLength = getLIS(B);
        
        // 제거할 전깃줄 = 전체 - LIS 길이
        System.out.println(N - lisLength);
    }
    
    // LIS 길이 구하기 (O(N log N))
    static int getLIS(int[] arr) {
        List<Integer> lis = new ArrayList<>();
        
        for (int num : arr) {
            // 이진 탐색으로 삽입 위치 찾기
            int pos = Collections.binarySearch(lis, num);
            
            if (pos < 0) {
                pos = -(pos + 1); // 삽입 위치
            }
            
            if (pos == lis.size()) {
                lis.add(num); // 끝에 추가
            } else {
                lis.set(pos, num); // 교체
            }
        }
        
        return lis.size();
    }
}