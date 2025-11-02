
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    //인오더 가 주어지고 포스트 오더가 주어졌을 때 프리오더를 구해라.
    // 중위식과 후위식이 있을 때 전위식을 구해야됨.
    static int n;
    static int[] in,post,pos;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            n = Integer.parseInt(br.readLine());
            in = new int[n];
            post = new int[n];
            pos = new int[n+1];
            StringTokenizer st; 
            st = new StringTokenizer(br.readLine().trim());
            for ( int i = 0; i < n; i ++) {
                in[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine().trim());
            for ( int j = 0; j < n; j ++) {
                post[j] = Integer.parseInt(st.nextToken());
            }
            // ✅ 인오더에서 "값 -> 인덱스" 역매핑 미리 만들어두기 (O(N))
            for (int i = 0; i < n; i++) pos[in[i]] = i;
            solve(0,n-1,0,n-1);
            System.out.print(sb);

    }
    // inorder[inL..inR], postorder[postL..postR] 구간을 이용
    static void solve(int inL,int inR, int postL,int postR) {
        if (inL> inR || postL > postR) {
            return; // 끝내기
        }
        int root = post[postR];
        int mid = pos[root]; // root 가 in에서 어디에 위치해있는지 찾기 
        int leftSize = mid - inL; // 왼쪽 서브트리 크기
        sb.append(root).append(' ');
        // 왼쪽 서브 트리 재귀 
        solve (inL, mid-1, postL, postL + leftSize -1);
        solve (mid +1, inR, postL + leftSize, postR -1);
    }
}
