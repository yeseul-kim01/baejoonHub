import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;
public class Main {
    //첫째 줄에 자연수 N, K가 공백을 기준으로 구분(1 ≤ N ≤ 200, 1 ≤ K ≤ 1,000)

    //N개의 줄에 걸쳐서 시험관의 정보
    //각 행은 N개의 원소로 구성되며,
    //해당 위치에 존재하는 바이러스의 번호가 공백을 기준으로 구분되어 주어짐

    //S, X, Y가 공백을 기준으로 구분되어 주어진다. (0 ≤ S ≤ 10,000, 1 ≤ X, Y ≤ N)
    //S초 뒤에 (X,Y)에 존재하는 바이러스의 종류를 출력
    //바이러스가 존재하지 않는다면, 0을 출력
    // BFS 로 진행 -> time 만큼 돌리기 
    // 시작 시 모든 바이러스 위치를 바이러스 번호 오름 차순으로 정렬하고, 그순서로 큐에 넣음.

    // 배열 저장할 board 
    static int N,K,S,X,Y;
    static int[][] board;
    static Queue<int[]> queue  = new ArrayDeque<>();
    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        board = new int[N][N];
        ArrayList<int[]>[] firstBoard = new ArrayList[K+1];
        for (int v = 1; v<=K;v++) firstBoard[v] = new ArrayList<>();
        for (int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for ( int j=0; j<N;j++){
                int addB = Integer.parseInt(st.nextToken());
                if (addB!=0){
                    firstBoard[addB].add(new int[]{i,j});
                }
                board[i][j] = addB;
            }
        }
        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());
        // System.out.println(Arrays.deepToString(board));

        //초기값 큐에 저장 
        // 큐에 1→K 순으로 초기 삽입 (time=0 포함)
        for (int v = 1; v <= K; v++) {
            for (int[] pos : firstBoard[v]) {
                queue.add(new int[]{v, pos[0], pos[1], 0}); // {virus, x, y, time}
            }
        }
        System.out.println(bfs());
    }

    static int bfs(){
        int cur_num,cur_x,cur_y,cur_time;
        int[] cur_vir;
        int next_vir;
        while(!queue.isEmpty()){
            cur_vir = queue.poll();
            // System.out.println(Arrays.toString(cur_vir));
            // System.out.println(board[X-1][Y-1]);
            cur_num = cur_vir[0];
            cur_x = cur_vir[1];
            cur_y = cur_vir[2];
            cur_time = cur_vir[3];
            if(cur_time +1 == S && board[X-1][Y-1] !=0) {
                return board[X-1][Y-1];
            }
            if(cur_time == S){
                continue;
            }
            if (cur_x > 0){
                next_vir = board[cur_x-1][cur_y];
                if (next_vir==0){
                    board[cur_x-1][cur_y] = cur_num;
                    queue.add(new int[]{cur_num,cur_x-1,cur_y,cur_time+1});
                }
            }
            if (cur_x <N-1){
                next_vir = board[cur_x+1][cur_y];
                if (next_vir==0){
                    board[cur_x+1][cur_y] = cur_num;
                    queue.add(new int[]{cur_num,cur_x+1,cur_y,cur_time+1});
                }
            }
            if (cur_y <N-1){
                next_vir = board[cur_x][cur_y+1];
                if (next_vir==0){
                    board[cur_x][cur_y+1] = cur_num;
                    queue.add(new int[]{cur_num,cur_x,cur_y+1,cur_time+1});
                }
            }
            if (cur_y >0){
                next_vir = board[cur_x][cur_y-1];
                if (next_vir==0){
                    board[cur_x][cur_y-1] = cur_num;
                    queue.add(new int[]{cur_num,cur_x,cur_y-1,cur_time+1});
                }
            }
            // for (int[] elem : queue) {
            //     System.out.println("queue");
            //     System.out.println(Arrays.toString(elem));
            // }
            

            // 종료는 time 이 S일 때 종료 return X,Y에 있는 바이러스번호
            // 추가 종료 X,Y 에 값이 채워지면 return X,Y에 있는 바이러스번호
        }
                return board[X-1][Y-1];
        
    }
    
}
