import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        
        StringBuilder result = new StringBuilder();
        int i = 0;
        
        while(i < input.length()) {
            if(input.charAt(i) == '.') {
                result.append('.');
                i++;
            } else {
                // X 연속 구간 길이 카운트
                int xCount = 0;
                int start = i;
                
                while(i < input.length() && input.charAt(i) == 'X') {
                    xCount++;
                    i++;
                }
                
                // 홀수면 불가능
                if(xCount % 2 == 1) {
                    System.out.print(-1);
                    return;
                }
                
                // 사전순 최소 = AAAA 최대 배치
                int aCount = xCount / 4;  // AAAA 개수
                int bCount = (xCount % 4) / 2;  // BB 개수
                
                for(int j = 0; j < aCount; j++) {
                    result.append("AAAA");
                }
                for(int j = 0; j < bCount; j++) {
                    result.append("BB");
                }
            }
        }
        
        System.out.print(result);
    }
}