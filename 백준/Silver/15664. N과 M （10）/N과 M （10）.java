import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] nLists;
    static int[] selects;
    static int M;//선택 수
    static int N;//수열크기

    public static void dfs(int idx,int count){
        if (count == M){
            //조건 만족 시 백트래킹 되어야 한다. 
            prints();
            return;
        }
        int prev = 0; // 같은 깊이에서 이전 값을 체크한다. - 같은 깊이 안이니까 dfs 안에서 0 초기화 해주고 하면 된다.
        for (int i=idx; i<N;i++){
            if (prev != nLists[i]) {
                // 서로 다르다. 
                prev = nLists[i]; // 업데이트 시켜준다
                selects[count] = nLists[i]; // 선택값을 넣어준다. - 출력을 위해서 
                dfs(i+1,count+1); // 다음거 업데이트 idx 업데이트  
            }
        }


    }

    public static void prints(){
        for(int i=0; i<M; i++){
            System.out.print(selects[i] + " ");
        }
        System.out.println();
    }


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        StringTokenizer st1 = new StringTokenizer(bf.readLine());
        nLists = new int[N];
        for (int i=0; i<N; i++){
            nLists[i]= Integer.parseInt(st1.nextToken());
        } 
        selects = new int[M];
        Arrays.sort(nLists); // 사전 순으로 증가하는 순서 출력을 위한 sort 
        dfs(0,0);
    }
    
}
