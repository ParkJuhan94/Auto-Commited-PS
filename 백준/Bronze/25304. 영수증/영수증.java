//package BOJ.Section12.P25304;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
첫째 줄에는 영수증에 적힌 총 금액
$X$가 주어진다.
둘째 줄에는 영수증에 적힌 구매한 물건의 종류의 수
$N$이 주어진다.
이후
$N$개의 줄에는 각 물건의 가격
$a$와 개수 , $b$가 공백을 사이에 두고 주어진다.

[예제 입력 1]
260000
4
20000 5
30000 2
10000 6
5000 8

[예제 출력 1]
Yes

 */
public class Main {

    public static void main(String[] args) throws IOException {
     //   System.setIn(new FileInputStream("src/BOJ/Section12/P25304/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 변수 선언 및 입력 처리
        int X = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(br.readLine());
        ArrayList<PurchasedItem> purchasedItems = new ArrayList<>();

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int count = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            purchasedItems.add(new PurchasedItem(count, cost));
        }

        // 출력을 위한 로직
        int sumCost = 0;

        for(PurchasedItem purchasedItem : purchasedItems) {
            sumCost += purchasedItem.count * purchasedItem.cost;
        }

        String answer;
        answer = (sumCost == X) ? "Yes" : "No";

        System.out.println(answer);
    }

}

class PurchasedItem {
    int count;  // 수량
    int cost;   // 금액

    public PurchasedItem(int count, int cost) {
        this.count = count;
        this.cost = cost;
    }
}