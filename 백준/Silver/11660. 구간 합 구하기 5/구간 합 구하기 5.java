import java.io.*;
/**
 * BOJ - 2차원 구간 합 (프로그래머스 스타일 드라이버)
 * 입력: N, M / N x N 보드 / M개의 (x1,y1,x2,y2)
 * 출력: M줄의 구간합
 *
 * 사용 방법:
 * 1) 아래 Solution 클래스의 solution 메서드만 구현하세요.
 * 2) 반환값은 각 질의의 답을 담은 int[M] 입니다.
 * 3) 좌표는 문제처럼 1-based로 들어옵니다.
 */
public class Main {
    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);
        StringBuilder sb = new StringBuilder();

        int N = fs.nextInt();
        int M = fs.nextInt();

        int[][] board = new int[N + 1][N + 1]; // 1-based
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                board[i][j] = fs.nextInt();
            }
        }

        int[][] queries = new int[M][4]; // [x1,y1,x2,y2]
        for (int i = 0; i < M; i++) {
            queries[i][0] = fs.nextInt();
            queries[i][1] = fs.nextInt();
            queries[i][2] = fs.nextInt();
            queries[i][3] = fs.nextInt();
        }

        Solution sol = new Solution();
        int[] ans = sol.solution(N, board, queries); // <= 여기를 네가 구현

        for (int i = 0; i < ans.length; i++) {
            sb.append(ans[i]).append('\n');
        }
        System.out.print(sb);
    }

    /** 빠른 입력 */
    static final class FastScanner {
        private final InputStream in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;
        FastScanner(InputStream is) { in = is; }

        private int read() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0) return -1;
            }
            return buffer[ptr++];
        }

        int nextInt() throws IOException {
            int c, s = 1, x = 0;
            do { c = read(); } while (c <= ' '); // skip spaces
            if (c == '-') { s = -1; c = read(); }
            while (c > ' ') { x = x * 10 + (c - '0'); c = read(); }
            return x * s;
        }
    }
}

/**
 * 이 부분만 구현하세요.
 * - N: 표 크기 (1..1024)
 * - board: 1-based N x N 값 (board[1][1]..board[N][N])
 * - queries: M x 4, 각 행은 {x1,y1,x2,y2} (모두 1-based, x1<=x2, y1<=y2)
 * 반환: 각 질의 구간합을 담은 길이 M의 배열
 *
 * 권장 로직(예시, 자유):
 * 1) 2차원 누적합 ps를 만들어 O(1)로 질의 처리
 *    ps[i][j] = board[1..i][1..j] 합
 *    sum(x1,y1,x2,y2) = ps[x2][y2] - ps[x1-1][y2] - ps[x2][y1-1] + ps[x1-1][y1-1]
 */class Solution {
    public int[] solution(int N, int[][] board, int[][] queries) {
        // 1) 2차원 누적합 만들기 (1-based 그대로 사용)
        int[][] ps = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            int rowSum = 0;
            for (int j = 1; j <= N; j++) {
                rowSum += board[i][j];
                ps[i][j] = ps[i - 1][j] + rowSum;
            }
        }

        // 2) 쿼리 O(1)로 처리
        int m = queries.length;
        int[] res = new int[m];
        for (int k = 0; k < m; k++) {
            int x1 = queries[k][0], y1 = queries[k][1];
            int x2 = queries[k][2], y2 = queries[k][3];
            res[k] = ps[x2][y2] - ps[x1 - 1][y2] - ps[x2][y1 - 1] + ps[x1 - 1][y1 - 1];
        }
        return res;
    }
}
