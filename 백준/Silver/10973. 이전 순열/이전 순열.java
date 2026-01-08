import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        // 이전 순열 찾기
        if (prevPermutation(arr)) {
            StringBuilder sb = new StringBuilder();
            for (int num : arr) {
                sb.append(num).append(' ');
            }
            System.out.println(sb);
        } else {
            System.out.println(-1);
        }
    }
    
    static boolean prevPermutation(int[] arr) {
        int N = arr.length;
        
        // 1. 뒤에서부터 arr[i] > arr[i+1]인 i 찾기
        int i = N - 2;
        while (i >= 0 && arr[i] <= arr[i + 1]) {
            i--;
        }
        
        // 가장 작은 순열(오름차순)이면 -1
        if (i < 0) {
            return false;
        }
        
        // 2. i 오른쪽에서 arr[i]보다 작으면서 가장 큰 값 찾기
        int j = N - 1;
        while (arr[j] >= arr[i]) {
            j--;
        }
        
        // 3. swap
        swap(arr, i, j);
        
        // 4. i+1부터 끝까지 오름차순 정렬 (내림차순 → 오름차순)
        reverse(arr, i + 1, N - 1);
        
        return true;
    }
    
    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            swap(arr, start, end);
            start++;
            end--;
        }
    }
}