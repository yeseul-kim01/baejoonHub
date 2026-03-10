
import java.io.IOException;
import java.util.Scanner;

public class Main{
    static int N; //퀸의 개수 
    static boolean[] colVisited; // 여부 - 행에 둘 수 있는지 없는지 (가로선)
    static boolean[] D1Visited; // 대각선 방향 중 한개 \ 이 방향인걸로
    static boolean[] D2Visited; // 대각선 방향 중 한개 / 이 방향인걸로
    static int[][] chess; //체스판 - 전체 체스판 크기 - 둘 위치 
    static int result; // 결과값 개수 
    
    public static void dfs(int row){

        //판별 기준
        if (row == N){
            // 됐다면 
            result +=1; // 총 개수만 출력하는 것 이므로 
            return;
        }
        // 맨 끝자리 열 부터 시작 선택한 열을 기준으로 각 col에다가 배치하자. 
        for (int col = 0; col<N;col++){
            // 앞에 visited 변경해주고
            if (!colVisited[col] && !D1Visited[row+col] && !D2Visited[row-col+N-1]) {
                modifyVisited(true, col, row);
                dfs(row+1);
                // 여기서 풀어줘야 한다. 
                modifyVisited(false, col, row);

            }
        }

    }
    public static void modifyVisited(boolean n,int col,int row){
        colVisited[col] = n;// 선택한 col 은 더이상 방문이 불가하다 
        D1Visited[row+col] = n;
        D2Visited[row-col+N-1] = n; 
    }


    public static void main(String[] args) throws IOException{
    
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        colVisited = new boolean[N];
        D1Visited = new boolean[2 * N - 1];
        D2Visited = new boolean[2 * N - 1];

        dfs(0); // 열을 선택하는 걸로 가야 함. 
        System.out.println(result);

    }
}