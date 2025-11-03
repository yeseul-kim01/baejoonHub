import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;
public class Main {
    //첫째 줄에 보드의 크기 N 이 주어짐. 2<=N<=100 다음 줄에 사과의 개수 K (0<=K<=100)
    // 다음 K 개의 줄에 사과의 위치 (행,열) 가 주어짐.
    // 맨 위 맨 좌측에는 사과가 없음. 
    // 다음 줄에 뱀의 방향 변환 횟수 L 
    // 다음 L 개의 줄에 뱀의 방향 정보가 주어짐. 정수 X와 문자 C 로 이루어져있으며
    // 게임 시작 시간으로부터 X초가 끝난 뒤에 왼쪽 L 또는 오른쪽 D로 방향을 회전시킨다는 뜻임.
    // X는 10000 이하의 양의 정수이며, 방향 전환 정보는 X가 증가하는 순으로 주어짐.
    // 첫째줄에 게임이 몇초에 끝나는지 출력
    // 뱀의 머리가 벽에 부디치거나 자기자신의 몸과 부딪히면 게임이 끝난다.
    // 뱀의 앞쪽에 추가되고, 뒷쪽에서 삭제되므로 삭제와 삽입이 빈번하게 늘어남.
    // 양쪽 끝에서의 삽입과 삭제가 빈번하므로 연결리스트로 구현할 거임. 

    private static int[][] board; // 보드 정보 
    private static LinkedList<int[]> snake;
    private static int[] dx = {0,1,0,-1};
    private static int[] dy = {1,0,-1,0};
    // 오른쪽으로 90도 회전할 때는 +1, 왼쪽으로 90도 회전할 때는 -1
    // 0: 오른쪽, 1: 아래, 2: 왼쪽, 3: 위
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine().trim());
        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine().trim());
        int K = Integer.parseInt(st.nextToken());
        // 인접 리스트로 구현
        board = new int[N+1][N+1];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int row = Integer.parseInt(st.nextToken());
            int col = Integer.parseInt(st.nextToken());
            board[row][col] = 1; // 사과 위치 표시
        }
        st = new StringTokenizer(br.readLine().trim());
        int L = Integer.parseInt(st.nextToken());
        int [][] dir = new int[L][2];
        for ( int i = 0;i<L;i++){
            st = new StringTokenizer(br.readLine());
            dir[i][0] = Integer.parseInt(st.nextToken());
            char C = st.nextToken().charAt(0);
            if (C =='L'){
                // 왼쪽으로 90도 회전일 때는 -1, 아니면 1 을 넣을 거임.
                dir[i][1] = -1;
            }
            else {
                dir[i][1] = 1;
            }

        }
        // System.out.println(Arrays.deepToString(dir));
        // System.out.println(Arrays.deepToString(board));
        // 뱀을 LinkedList 로 구현함.
        // dir 에 뱀의 정보가 들어있음.
        // dir 의 값을 하나씩 확인하면서 뱀을 이동시킴.
        // 뱀의 초기 위치는 (1,1) 임.
        snake = new LinkedList<>();
        snake.add(new int[]{1,1}); // 뱀의 초기 위치 추가
        int time=0;
        int turn =0;
        int curX =1;
        int curY = 1;
        int nextY;
        int nextX;
        int curDir = 0;
        while (true) { 
            time ++;
            nextX = curX + dx[curDir];
            nextY = curY + dy[curDir]; // 다음 위치를 계산해야 함. 
            // 만약 다음 위치가 벽에 부딪히거나 자기 자신의 몸과 부딪히면 게임이 끝난ㄴ다.
            if (isFinish(nextX,nextY)) break;

            if (board[nextX][nextY] ==1) {
                // 사과가 있는 경우
                board[nextX][nextY] =0; // 사과 먹음
                snake.addFirst(new int[]{nextX,nextY}); // 뱀의 머리 추가
            } else {
                // 사과가 없는 경우
                snake.addFirst(new int[]{nextX,nextY}); // 뱀의 머리 추가
                snake.removeLast(); // 뱀의 꼬리 제거
            }

            curX = nextX;
            curY = nextY;

            if (turn < L) {
                if (time == dir[turn][0]) {
                    curDir = (curDir + dir[turn][1] + 4) % 4; // 방향 전환
                    turn++;
                }
            }
        }
        System.out.println(time);
    }

    // 충돌 체크 함수 
    private static boolean isFinish(int x, int y) {

        // 벽이랑 부딪혔는지 확인
        if (x <= 0 || x >= board.length || y <= 0 || y >= board.length) {
            return true;
        }
        // 자기 자신의 몸과 부딪혔는지 확인
        for (int i = 0 ; i < snake.size(); i++) {
            int[] part = snake.get(i);
            if (part[0] == x && part[1] == y) {
                return true;
            }
        }
        return false;
    }
}
