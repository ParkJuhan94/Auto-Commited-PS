//package BOJ.Section11.P2929;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;

    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("src/BOJ/Section11/P2929/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int ans = 0;
        int currentPos = 0; // 현재 메모리 위치

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);

            if (Character.isUpperCase(c)) { // 명령어라면
                // 현재 위치가 4의 배수가 아니면 NOP 추가
                if (currentPos % 4 != 0) {
                    ans += 4 - (currentPos % 4); // 부족한 만큼 NOP 추가
                    currentPos += 4 - (currentPos % 4); // 위치 갱신
                }
            }

            // 명령어 또는 파라미터를 처리했으므로 메모리 사용량 증가!!
            currentPos++;
        }

        System.out.println(ans);
    }
}
