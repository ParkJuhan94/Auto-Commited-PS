import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        
        int[] dir = new int[6];   // 방향
        int[] len = new int[6];   // 길이
        
        for(int i = 0; i < 6; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            dir[i] = Integer.parseInt(st.nextToken());
            len[i] = Integer.parseInt(st.nextToken());
        }
        
        // 1. 최대 가로/세로 찾기
        int maxWidth = 0, maxHeight = 0;
        int maxWidthIdx = 0, maxHeightIdx = 0;
        
        for(int i = 0; i < 6; i++) {
            if(dir[i] == 1 || dir[i] == 2) {  // 동서 = 가로
                if(len[i] > maxWidth) {
                    maxWidth = len[i];
                    maxWidthIdx = i;
                }
            } else {  // 남북 = 세로
                if(len[i] > maxHeight) {
                    maxHeight = len[i];
                    maxHeightIdx = i;
                }
            }
        }
        
        // 2. 작은 사각형 변 찾기 (최대 변의 반대편)
        // 작은 가로 = 최대 가로 ±3칸 떨어진 위치
        int smallWidth = len[(maxWidthIdx + 3) % 6];
        int smallHeight = len[(maxHeightIdx + 3) % 6];
        
        // 3. 넓이 계산
        int area = maxWidth * maxHeight - smallWidth * smallHeight;
        
        System.out.print(K * area);
    }
}