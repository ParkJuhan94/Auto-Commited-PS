import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        // 1) 숫자를 문자열로 변환
        String[] arr = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            arr[i] = String.valueOf(numbers[i]);
        }

        // 2) (b+a) vs (a+b) 기준으로 내림차순 정렬
        Arrays.sort(arr, (a, b) -> (b + a).compareTo(a + b));

        // 3) 가장 큰 수가 "0"이면 전체가 0인 케이스 → "0" 반환
        if (arr[0].equals("0")) return "0";

        // 4) 이어붙이기
        StringBuilder sb = new StringBuilder();
        for (String s : arr) sb.append(s);
        return sb.toString();
    }
}