import java.util.*;

public class Main {
    static int[][] board = new int[9][9];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        solve(0, 0);
    }

    // 재귀적으로 좌표를 진행
    static void solve(int row, int col) {
        if (col == 9) {
            solve(row + 1, 0);
            return;
        }

        if (row == 9) {
            printBoard();
            System.exit(0); // 정답 찾았으면 종료
        }

        if (board[row][col] == 0) {
            for (int num = 1; num <= 9; num++) {
                if (isValid(row, col, num)) {
                    board[row][col] = num;
                    solve(row, col + 1);
                    board[row][col] = 0; // 백트래킹
                }
            }
        } else {
            solve(row, col + 1);
        }
    }

    // 유효성 검사
    static boolean isValid(int row, int col, int num) {
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == num || board[i][col] == num)
                return false;
        }

        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;

        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (board[i][j] == num)
                    return false;
            }
        }

        return true;
    }

    // 결과 출력
    static void printBoard() {
        for (int[] row : board) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
