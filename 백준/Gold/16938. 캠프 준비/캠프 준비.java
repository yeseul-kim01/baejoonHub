import java.io.*;
import java.util.*;

public class Main {
    static int N, L, R, X;
    static int[] levels;
    static int result = 0;

    // idx: 현재 문제 위치
    // count: 선택한 문제 수
    // sum: 선택한 문제 난이도 합
    // min: 선택한 문제 중 최소 난이도
    // max: 선택한 문제 중 최대 난이도
    public static void dfs(int idx, int count, int sum, int min, int max) {
        if (idx == N) {
            if (count >= 2 && sum >= L && sum <= R && (max - min) >= X) {
                result+=1;
            }
            return;
        }

        // 1) 현재 문제 선택
        int newMin = (count == 0) ? levels[idx] : Math.min(min, levels[idx]);
        int newMax = (count == 0) ? levels[idx] : Math.max(max, levels[idx]);
        // System.out.println(newMax+" "+newMin+" "+idx+ " "+count);
        dfs(idx + 1, count + 1, sum + levels[idx], newMin, newMax);

        // 2) 현재 문제 선택하지 않음
        dfs(idx + 1, count, sum, min, max);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        levels = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            levels[i] = Integer.parseInt(st.nextToken());
        }

        // DFS 시작, min/max는 초기값으로 0 사용하고 첫 선택에서 처리
        dfs(0, 0, 0, 0, 0);

        System.out.println(result);
    }
}