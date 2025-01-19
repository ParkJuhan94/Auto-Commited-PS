//package BOJ.Section11.P10882;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;

    public static void main(String[] args) throws IOException {
     //   System.setIn(new FileInputStream("src/BOJ/Section11/P10882/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        String input = st.nextToken();
        int h = Integer.parseInt(input.substring(0, 2));
        int m = Integer.parseInt(input.substring(3, 5));

        input = st.nextToken();
        double plus;
        if (input.substring(3, 4).equals("+")) {
            plus = Double.parseDouble(input.substring(4));
        } else {
            plus = -1 * Double.parseDouble(input.substring(4));
        }

        for (int i = 0; i < N; i++) {
            input = br.readLine();
            int targetH = 0;
            int targetM = 0;

            for (int j = 0; j < input.length(); j++) {
                boolean isPlus;
                if (input.charAt(j) == '-' || input.charAt(j) == '+') {
                    isPlus = (input.charAt(j) == '+') ? true : false;
                    String time = input.substring(j + 1);
                    // split 할 때 '\\.'을 사용해야 정규표현식에서 '.'을 리터럴로 처리할 수 있음.
                    String[] times = time.split("\\.");

                    if (times.length == 1) {
                        targetH = (isPlus) ? Integer.parseInt(time) : -1 * Integer.parseInt(time);
                    } else {
                        targetH = (isPlus) ? Integer.parseInt(times[0]) : -1 * Integer.parseInt(times[0]);
                        targetM = (isPlus) ? 30 : -30;
                    }
                    break;
                }
            }

            // plus 값 처리: 소수점까지 고려한 시간 계산
            int additionalH = (int) plus;
            int additionalM = (int) ((plus - additionalH) * 60); // 소수점 이하를 분으로 변환

            // 기존 시간과 더하기
            int h_ = h + targetH - additionalH;
            int m_ = m + targetM - additionalM;

            if (m_ >= 60) {
                h_ += m_ / 60;
                m_ %= 60;
            } else if (m_ < 0) {
                h_ -= 1 + (-m_) / 60;
                m_ = (m_ + 60) % 60;
            }

            h_ = (h_ + 24) % 24;

            // 출력 포맷 맞추기!!!
            System.out.printf("%02d:%02d\n", h_, m_);
        }
    }
}
