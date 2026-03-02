
import java.io.BufferedReader;
import java.math.BigInteger;

class Main {
   
    // 하노이탑 총 이동 경로
    //static BigInteger count = new BigInteger("0");
    // 하노이 탑 출력 버퍼 
    static StringBuilder sb = new StringBuilder();
    static boolean isPrint = true;
   
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in)); // 입력 버퍼 
        int n = Integer.parseInt(br.readLine()); // 원판의 개수 
        BigInteger count = BigInteger.valueOf(2).pow(n).subtract(BigInteger.ONE); // 이동 횟수 계산
        System.out.println(count); // 총 이동 횟수 출력 
        if (n<=20) {
            // 버퍼를 계속 print 하는 것보다 버퍼를 쌓아서 한번에 출력하는게 좋다.
            hanoi(n,1,3,2); // 하노이 탑 이동 
            System.out.println(sb.toString()); // 이동 경로 출력 

        }

    }
    static void hanoi(int n, int from , int to, int vai) {
        // n 은 원판의 개수, from 은 출발지, to 는 목적지 , vai 는 경유지 
        if (n == 1) {
            // 원판이 하나일 때는 그냥 옮긴다. 
            // count = count.add(BigInteger.ONE); // 이동 횟수 증가
            if(isPrint) {
                sb.append(from).append(" ").append(to).append("\n");
                return ;
            }
            return ;
        }
        // n-1 개의 원판을 from 에서 vai 로 옮긴다.
        hanoi(n-1 , from,vai,to);
        hanoi(1, from, to , vai);
        // n-1 개의 원판을 vai 에서 to 로 옮긴다.
        hanoi(n-1,vai,to,from);
    }
}

// 장대는 총 세개
// 첫번째 장대에 서로다른 n 개의 원판이 쌓여있음. 각 원판은 반경이 큰 순서대로 쌓여있음. 
// 한번에 한개의 원판만을 달느 탑으로 옮길 수 있음
// 쌓은 원판은 항상 위의 것이 아래 것 보다 작아야 한다
// 이동 횟수가 최소 여야 한다
// 첫번째에서 세번째로 이동해야 한다. 
// 분할 정복인 이유 
//