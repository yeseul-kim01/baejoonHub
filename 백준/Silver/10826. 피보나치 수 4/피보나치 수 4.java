import java.io.*;
import java.math.BigInteger;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        // 피보나치 수는 0과 1로 시작
        // n 이 주어졌을 때 n 번째 피보나치 수를 구하는 프로그램 작성 
        // DP 로 풀어야 됨. 왜냐면 n 이 최대 90 까지 주어질 수 있기 때문.
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        if (n == 0) {
            System.out.println(0);
            return ;
        }
        BigInteger p2 = BigInteger.ZERO; // F(0)
        BigInteger p1 = BigInteger.ONE; // F(1)

        for ( int i = 2 ; i <= n ; i ++) {
            BigInteger temp = p1.add(p2);
            p2 = p1;
            p1 = temp;
        }
        System.out.println(p1);

    }
}