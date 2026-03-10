
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N; // 전체 개수 
    static int[][]S; //능력치는 모든 함수에서 접근해야 함.
    static boolean[] visited; // 방문도 모든 함수 접근
    static int minDiff = Integer.MAX_VALUE; // 업데이트할 애임. 

    static void dfs(int idx,int count){
        if (count== N/2){
            //절반이 되면 능력치 계산하기 
            calc();
            return;
        }

        for (int i=idx; i<N;i++){
            if (!visited[i]){
                visited[i] = true; // 탐색 불가하게 막기 
                dfs(i+1,count+1);// 다음 선수 선택 
                visited[i] = false; // 나오면 탐색 가능하게 바꿔줘야 함.
            }
        }
    }

    static void calc() {
        int start = 0, link=0; // 처음 값임. 
        for (int i=0; i<N; i++){
            for (int j=i+1; j<N;j++){
                if (visited[i] &&visited[j]) {
                    // start 팀의 조건 
                    start+=S[i][j]+S[j][i]; 
                }
                else if (!visited[i]&&!visited[j]){
                    //둘다 false 인 거 
                    link += S[i][j]+S[j][i];
                }
            }
        }
        // 전체 for 문이 끝나면 갱신해주기 
        minDiff = Math.min(minDiff, Math.abs(start-link)); //차이의 최솟값을 구해야 한다. 
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        S = new int[N][N];
        visited = new boolean[N];
        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for (int j=0; j<N;j++){
                S[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0,0);
        System.out.println(minDiff);
    }
    // 축구 모인사람 N , N은 짝수로 주어진다. 
    // 팀의 능력치는 최소가 되게끔 해야함. 
    // 팀은 두개로 나누어짐. 
    // 모든 조합을 고려해야되기 때문에 백트래킹이 최적 
    // DFS 재귀로 하는 것 
    // 중간 return 조건은 선택한 조합의 능력치 합이 정해놓은 최소 보다 크면 더 탐색 안하게끔 진행 
    // N/2 에서 한명씩 이제 선택할 건데, 

}
