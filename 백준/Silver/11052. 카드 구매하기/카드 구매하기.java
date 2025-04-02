import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // 카드 개수
        int[] prices = new int[n]; // 카드팩 가격 배열

        for (int i = 0; i < n; i++) {
            prices[i] = sc.nextInt();
        }

        int[] dp = new int[n + 1]; // dp[i] = 카드 i개를 구매할 때 최대 금액

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] = Math.max(dp[i], prices[j - 1] + dp[i - j]);
            }
        }

        System.out.println(dp[n]);
    }
}
