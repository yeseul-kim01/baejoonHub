import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][M]; 

        for (int i=0; i< N;i++){
            char[] a = bf.readLine().toCharArray();
            for (int j=0; j<M;j++){
                arr[i][j] = a[j] - '0'; //TODO: 확인하기!!! 
            }
        }
        
        int[][] visited = new int[N][M]; // 방문 여부 저장
        // Arrays.fill(visited, -1); // TODO: arrays fill 은 1차원에서만 가능하다.
        for (int i =0; i<N;i++){
            Arrays.fill(visited[i],-1);
        }
        visited[0][0]=1; // 처음 값 - 0,0 기준으로 해야됨. 
        Deque<int[]> deque = new ArrayDeque<>(); // TODO: 데큐는 tuple 저장이 안된다..ㅜ
        deque.add(new int[]{0,0}); // TODO: 데큐에서 리스트를 저장할 때는 앞에 선언 뒤에 {} 형식! 
        int[] cur = new int[2];
        int x;
        int y;
        while(!deque.isEmpty()) {

            cur = deque.poll();
            x = cur[0];
            y = cur[1];
            // System.out.println(x+" " + y);
            if (x==N-1 && y==M-1) {
                // 목적지일시
                break;
            }
            int[][] direct = new int[][]{{x,y+1},{x,y-1},{x+1,y},{x-1,y}}; // 이동할 수 있는 경로 
            for (int[] d : direct){
                int a = d[0];
                int b = d[1];
                if (  0 <= a && a < N && 0 <= b && b < M && visited[a][b]==-1 && arr[a][b] == 1)  { //TODO: if 조건문 달 때 << 연속 안되는거 확인하기.....샤갈..이딴것도안되냐!
                    /**
                     * 0 < a의 결과는 boolean입니다.
                     * boolean < N은 타입이 맞지 않아 오류가 발생합니다.
                     **/
                    deque.add(new int[]{a,b});
                    visited[a][b] = visited[x][y] + 1 ;// 방문 여부만 체크하는게 아니라 값도 저장! 이동한 칸 수 1, 그전까지의 칸 수 업데이트 
                }
            }
        }
        // for (int i = 0; i < visited.length; i++) {
        //     for (int j = 0; j < visited[i].length; j++) {
        //         System.out.print(visited[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        System.out.println(visited[N-1][M-1]);
     }
}

//DP 문제
//미로에서 1 은 이동할 수 있는 칸, 0은 없음.
// (1,1) -> (N,M) 위치로 이동할 때 지나야 하는 최소의 칸 수를 구하는 프로그램
// 서로 인접한 것들만 이동할 수 있음
// 칸의 수를 구하는 문제임.
// N과M 은 100 이하이기 때문에 이차원 배열로 접근해도, 10000 번이라 이중 for 문이 가능하다. 
// 각 배열별로 갈수있는 값들의 최소만을 저장하는 visited table 을 작성하고
// 이중 for 문으로 배열의 위치가 지정 됐을 때 거기서 갈수있는 모든 좌표들을 다시 deque 에 집어넣는다.
// 만약 간 적이 있는 곳이라면 deque 에 집어넣는 거 pass 