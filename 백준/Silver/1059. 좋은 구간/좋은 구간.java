import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int L = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < L; i++) {
            set.add(Integer.parseInt(st.nextToken()));
        }
        
        int n = Integer.parseInt(br.readLine());
        
        // n이 S에 포함되어 있으면 불가능
        if (set.contains(n)) {
            System.out.println(0);
            return;
        }
        
        // S를 정렬된 배열로 변환
        int[] S = set.stream().mapToInt(Integer::intValue).toArray();
        Arrays.sort(S);
        
        // left: n보다 작은 수 중 최대값 (없으면 0)
        int left = 0;
        for (int x : S) {
            if (x < n) {
                left = x;
            } else {
                break;
            }
        }
        
        // right: n보다 큰 수 중 최소값 (없으면 1001)
        int right = 1001;
        for (int x : S) {
            if (x > n) {
                right = x;
                break;
            }
        }
        
        long answer = (long)(n - left) * (right - n) - 1;
        
        System.out.println(answer);
    }
}