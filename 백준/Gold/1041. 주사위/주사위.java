import java.io.*;
import java.util.*;

public class Main {
    static boolean isOpp(int i, int j) {
        return (i==0&&j==5)||(i==5&&j==0) ||
               (i==1&&j==4)||(i==4&&j==1) ||
               (i==2&&j==3)||(i==3&&j==2);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());

        long[] dice = new long[6];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 6; i++) dice[i] = Long.parseLong(st.nextToken());

        // N == 1 예외
        if (N == 1) {
            long sum = 0, max = 0;
            for (long v : dice) {
                sum += v;
                max = Math.max(max, v);
            }
            System.out.println(sum - max);
            return;
        }

        // 1면 최소
        long min1 = dice[0];
        for (int i = 1; i < 6; i++) min1 = Math.min(min1, dice[i]);

        // 2면 최소 (인접만)
        long min2 = Long.MAX_VALUE;
        for (int i = 0; i < 6; i++) {
            for (int j = i+1; j < 6; j++) {
                if (isOpp(i, j)) continue;
                min2 = Math.min(min2, dice[i] + dice[j]);
            }
        }

        // 3면 최소 (코너 8개)
        int[][] corners = {
            {0,1,2},{0,1,3},{0,4,2},{0,4,3},
            {5,1,2},{5,1,3},{5,4,2},{5,4,3}
        };
        long min3 = Long.MAX_VALUE;
        for (int[] c : corners) {
            min3 = Math.min(min3, dice[c[0]] + dice[c[1]] + dice[c[2]]);
        }

        long count3 = 4;
        long count2 = 8 * N - 12;
        long count1 = (N - 2) * (N - 2) + 4 * (N - 2) * (N - 1);

        long ans = count3 * min3 + count2 * min2 + count1 * min1;
        System.out.println(ans);
    }
}