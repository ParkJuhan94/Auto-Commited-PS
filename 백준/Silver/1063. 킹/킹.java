import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String kPos = sc.next();
        String sPos = sc.next();
        int N = sc.nextInt();
        
        // 열: A=1~H=8, 행: 1~8
        int kc = kPos.charAt(0) - 'A' + 1;
        int kr = kPos.charAt(1) - '0';
        int sc2 = sPos.charAt(0) - 'A' + 1;
        int sr = sPos.charAt(1) - '0';
        
        for (int i = 0; i < N; i++) {
            String move = sc.next();
            int dc = 0, dr = 0;
            if (move.contains("R")) dc = 1;
            if (move.contains("L")) dc = -1;
            if (move.contains("T")) dr = 1;
            if (move.contains("B")) dr = -1;
            
            int nkc = kc + dc;
            int nkr = kr + dr;
            
            // 킹이 체스판 밖이면 스킵
            if (nkc < 1 || nkc > 8 || nkr < 1 || nkr > 8) continue;
            
            // 킹이 돌 위치로 이동하는 경우
            if (nkc == sc2 && nkr == sr) {
                int nsc = sc2 + dc;
                int nsr = sr + dr;
                // 돌이 체스판 밖이면 스킵
                if (nsc < 1 || nsc > 8 || nsr < 1 || nsr > 8) continue;
                sc2 = nsc;
                sr = nsr;
            }
            
            kc = nkc;
            kr = nkr;
        }
        
        System.out.println((char)('A' + kc - 1) + "" + kr);
        System.out.println((char)('A' + sc2 - 1) + "" + sr);
    }
}