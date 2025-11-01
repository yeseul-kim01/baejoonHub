import java.util.Arrays;
import java.util.Scanner;

public class Main {
    
    //정수로 이루어진 크기가 같은 배열 네개 
    // 배열 에서 합이 0인 a,b,c,d 쌍의 개수를 구해야 함. 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] A = new int[n];
        int [] B = new int[n];
        int [] C = new int[n];
        int [] D = new int[n];

        for ( int i=0; i<n; i++) {
            A[i] = sc.nextInt();
            B[i] = sc.nextInt();
            C[i] = sc.nextInt();
            D[i] = sc.nextInt();
        }
        int[] AB = new int[n*n];
        int[] CD = new int[n*n];

        int index = 0;
        for ( int a : A) {
            for ( int b : B) {
                AB[index++] = a + b;
            }
        }
        index = 0;
        for ( int c : C) {
            for ( int d : D) {
                CD[index++] = c + d;
            }
        }

        Arrays.sort(AB);
        Arrays.sort(CD);
        // System.out.println(Arrays.toString(AB));
        // System.out.println(Arrays.toString(CD));

        long count = 0;
        int A_start = 0;
        int C_start = n*n -1;
        while (A_start < n*n && C_start >=0) {
            int sum = AB[A_start] + CD[C_start];
            if (sum == 0 ){
                long left_count = 1;
                long right_count = 1;
                while (A_start+1 < n*n && AB[A_start] == AB[A_start +1]) {
                    left_count ++;
                    A_start ++;
                }
                while (C_start -1 >=0 && CD[C_start] == CD[C_start -1]) {
                    right_count ++;                
                    C_start --;
                }
                count += left_count * right_count;
                A_start ++;
            }
            else if ( sum < 0) {
                A_start ++;
            }
            else {
                C_start --;
            }
        }
        System.out.println(count);
    }
}
