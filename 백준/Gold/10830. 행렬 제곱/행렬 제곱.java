import java.io.*;

public class Main {


    // 행렬 곱셈 정의하기 - 행렬 두개의 곱셈만 정의한다. 
    static long[][] mul (long[][] A, long[][] B) {
        int n = A.length; // A의 행렬 크기 , 행렬 크기의 최댓값은 5 이므로 int 사용
        long [][] C = new long[n][n]; // 결과 행렬 C 초기화

        for (int i=0; i < n; i++) {
            for (int j=0; j < n; j++) {
                C[i][j] = 0; // C[i][j] 초기화
                for (int k=0; k < n; k++) {
                    C[i][j] += A[i][k] * B[k][j]; // 행렬 곱셈 계산
                    C[i][j] %= 1000; // 결과를 1000으로 나눈 나머지로 저장
                }
            }
        }
        return C; // 결과 행렬 C 반환
    }

    // 단위 행렬 만들기 - 필요한 이유는 행렬의 0 제곱이 단위 행렬이기 때문입니다.
    static long[][] identity (int n) {
        long [][] I = new long[n][n]; // 단위 행렬 초기화
        for (int i=0; i < n; i++) {
            I[i][i] = 1; // 대각선 원소를 1로 설정
        }
        return I; // 단위 행렬 반환
    }

    // 행렬곱 함수 만들기 - 분할정복을 이용해서 행렬의 B 제곱을 계산하는 함수
    static long[][] pow (long[][] A , long b) {
        // b는 지수
        int n = A.length; // 행렬 A의 크기
        long[][] result = identity(n); // 결과 행렬을 단위 행렬로 초기화
        long[][] base = A; // base 함수는 A로 초기화
        while (b>0) {
            // 지수가 0일 때 까지
            if ((b & 1L) == 1L) {// 지수가 홀수일 때
                result = mul(result, base); } // 결과 행렬에 base 행렬 곱하기
            base = mul(base, base); // base 행렬을 제곱하기
            b >>= 1; // 지수를 오른쪽으로 한 비트 이동 (b를 2로 나누기)
        }
        return result; // 최종 결과 행렬 반환

        // 분할정복을 써야 된다. 지수가 짝수면 A^(B/2) * A^(B/2)
        // 지수가 홀수면 A^(B-1) * A

        // 행렬곱의 원래 식은 C[i][j] = A[i][0] * B[0][j] + A[i][1] * B[1][j] + ... + A[i][N-1] * B[N-1][j]
        // 남은 지수를 B 라고 하고, B 가 1
    }
    public static void main(String[] a ) throws IOException {
        // 입력 한줄 씩 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 첫번째 줄 읽기
        String [] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        long B = Long.parseLong(input[1]);
        // 행렬 A 입력 받기
        long [][] A = new long[N][N];
        for ( int i = 0 ; i < N ; i ++) {
            String [] line = br.readLine().split(" ");
            for ( int j = 0 ; j < N ; j ++) {
                A[i][j] = Long.parseLong(line[j])%1000; // 입력받은 원소를 1000으로 나눈 나머지로 저장
            }
        }
        long [][] answer = pow(A, B); // A의 B 제곱 계산
        // 결과 출력하기
        StringBuilder sb = new StringBuilder();
        for ( int i = 0 ; i < N ; i ++) {
            for ( int j = 0 ; j < N ; j ++) {
                sb.append(answer[i][j]).append(" "); // 결과 행렬의 원소를 문자열에 추가
            }
            sb.append("\n"); // 각 행마다 줄바꿈 추가
        }
        System.out.print(sb.toString()); // 최종 결과 출력
        // 입력받은 행렬 출력 해보기
        // System.out.println("입력받은 행렬 A : ");
        // for ( int i = 0 ; i < N ; i ++) {
        //     for ( int j = 0 ; j < N ; j ++) {
        //         System.out.print(A[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        // // 간단한 방법으로 입력받은 행렬 출력
        // System.out.println("입력받은 행렬 A : ");
        // System.out.println(java.util.Arrays.deepToString(A)); 
        // deepToString 함수는 2차원 배열을 문자열로 변환해주는 함수입니다. 
        //1차원 배열은 Arrays.toString() 함수를 사용하면 됩니다.


    }
    
}
// 크기가 N*N 인 행렬 A , 이떄 A의 B 제곱을 구하는 프로그램 , A^B 의 각 원소를 1000으로 나눈 나머지로 출력
// B는 100,000,000,000 보다 작거나 같은 수
// N 은 행렬의 킉 2보다 크거나 같고 5보다 작거나 같은 수
// 첫째줄에 행렬의 크기 N 과 B
// 둘째줄 부터 N 개의 줄에 행렬의 각 원소가 주어짐. 원소는 1000보다 작거나 같은 자연수