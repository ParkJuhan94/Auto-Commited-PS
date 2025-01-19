//package BOJ.Section11.P10882;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
//        System.setIn(new FileInputStream("src/BOJ/Section11/P10882/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        String input = st.nextToken();

        int currentHour = Integer.parseInt(input.substring(0, 2));
        int currentMinute = Integer.parseInt(input.substring(3, 5));

        // 시간 차이를 나타내는 값을 읽기 (예: +8.5 또는 -7)
        input = st.nextToken();
        double offsetTime;
        // 시간 차이의 부호를 구분하여 읽기
        if (input.substring(3, 4).equals("+")) {
            offsetTime = Double.parseDouble(input.substring(4));
        } else {
            offsetTime = -1 * Double.parseDouble(input.substring(4));
        }

        for (int i = 0; i < N; i++) {
            input = br.readLine();
            int adjustmentHour = 0; // 시간 조정 변수
            int adjustmentMinute = 0; // 분 조정 변수

            // 입력에서 부호와 시간을 파싱하여 조정값 계산
            for (int j = 0; j < input.length(); j++) {
                boolean isPositive;
                if (input.charAt(j) == '-' || input.charAt(j) == '+') {
                    isPositive = (input.charAt(j) == '+');
                    String time = input.substring(j + 1);
                    String[] timeParts = time.split("\\.");

                    // 시간만 있는 경우와 분이 포함된 경우를 구분
                    if (timeParts.length == 1) {
                        adjustmentHour = isPositive ? Integer.parseInt(time) : -Integer.parseInt(time);
                    } else {
                        adjustmentHour = isPositive ? Integer.parseInt(timeParts[0]) : -Integer.parseInt(timeParts[0]);
                        adjustmentMinute = isPositive ? 30 : -30; // 분 단위 조정
                    }
                    break;
                }
            }

            // 시간 차이를 고려하여 추가적인 시간 및 분 계산
            int offsetHour = (int) offsetTime; // 시간 차이의 시 부분
            int offsetMinute = (int) ((offsetTime - offsetHour) * 60); // 시간 차이의 분 부분

            // 현재 시간에 조정값과 시간 차이를 반영하여 새로운 시간 계산
            int newHour = currentHour + adjustmentHour - offsetHour;
            int newMinute = currentMinute + adjustmentMinute - offsetMinute;

            // 분이 60 이상이면 시간에 반영하고, 0 미만이면 올바르게 처리
            if (newMinute >= 60) {
                newHour += newMinute / 60;
                newMinute %= 60;
            } else if (newMinute < 0) {
                newHour -= 1 + (-newMinute) / 60;
                newMinute = (newMinute + 60) % 60;
            }

            // 시간 값을 24시간 형식으로 조정
            newHour = (newHour + 24) % 24;

            // 결과 출력: 2자리로 포맷팅하여 시:분 형태로 출력
            System.out.printf("%02d:%02d\n", newHour, newMinute);
        }
    }
}
