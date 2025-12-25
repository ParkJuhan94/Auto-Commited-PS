import java.io.*;
import java.util.*;

public class Main {
    static int answer = -1;
    static int count = 0;
    static int N, K;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        merge_sort(arr, 0, N - 1);
        
        System.out.print(answer);
    }
    
    static void merge_sort(int[] arr, int p, int r) {
        if(p < r) {
            int q = (p + r) / 2;
            
            merge_sort(arr, p, q);
            merge_sort(arr, q + 1, r);
            merge(arr, p, q, r);
        }
    }
    
    static void merge(int[] arr, int p, int q, int r) {
        int i = p;
        int j = q + 1;
        int t = 0;
        int[] tmp = new int[r - p + 1];
        
        while(i <= q && j <= r) {
            if(arr[i] <= arr[j]) {
                tmp[t++] = arr[i++];
            } else {
                tmp[t++] = arr[j++];
            }
        }
        
        while(i <= q) {
            tmp[t++] = arr[i++];
        }
        
        while(j <= r) {
            tmp[t++] = arr[j++];
        } 
        
        i = p; 
        t = 0;
        
        while(i <= r) {
            arr[i++] = tmp[t++];
            
            count++;
            if(count == K) {
                answer = tmp[t - 1];
                return;
            }
        }
    }
}