import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        // x + y 가능한 모든 합 저장
        int[] twoSum = new int[N * N];
        int idx = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                twoSum[idx++] = arr[i] + arr[j];
            }
        }

        Arrays.sort(twoSum);

        // 가장 큰 k부터 검사
        for (int k = N - 1; k >= 0; k--) {
            for (int z = 0; z <= k; z++) {
                int target = arr[k] - arr[z];

                if (Arrays.binarySearch(twoSum, target) >= 0) {
                    System.out.println(arr[k]);
                    return;
                }
            }
        }
    }
}