import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book); // 사전순 정렬

        for (int i = 0; i < phone_book.length - 1; i++) {
            String prev = phone_book[i];
            String cur = phone_book[i + 1];

            if (cur.startsWith(prev)) {  // 접두사 확인
                return false;
            }
        }

        return true;
    }
}
