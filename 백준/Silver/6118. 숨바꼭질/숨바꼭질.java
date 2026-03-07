import java.io.*;
import java.util.*;
public class Main{
    public static void main(String[] args) throws IOException {
        // 헛간의 개수 2<= , <= 20000 개임. int ,배열 저장 가능! 1부터 샌다. 
        // 모든 헛간은 M 5000개 보다 적은 양방향!! 길로 이어져있음. 양방향인게 중요한듯! 다이제스트라?? 양 끝을 Ai Bi 로 표현 
        BufferedReader br = new BufferedReader( new InputStreamReader ( System.in));

        Map<Integer,List<Integer>> graph = new HashMap<>(); // MAP 은 python 의 defaultdict 과 동일
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        for (int i = 0; i < M; i ++) {
            StringTokenizer sn = new StringTokenizer(br.readLine());
            Integer Ai = Integer.parseInt(sn.nextToken());
            Integer Bi = Integer.parseInt(sn.nextToken());
            graph.computeIfAbsent(Ai, k -> new ArrayList<>()).add(Bi); // TODO: 다시 한번 확인해보기 
            graph.computeIfAbsent(Bi, k-> new ArrayList<>()).add(Ai);
        }
        
        // node의 개수 - graph size 로! 전체 개수에 1을 더해서 저장해야 한다.
        int[] visited = new int[N+1]; // Assuming maximum barns are 20000
        Arrays.fill(visited,-1); // 방문 안 한 곳은 거리를 0으로 저장한다. 
        visited[1] = 0; // 처음 값은 0으로 초기화! 스타트 부분 
        Deque <Integer> deque = new ArrayDeque<>(); // 왜 선언시 Deque 가 아니라 ArrayDeque 야? 
        deque.add(1); // 처음 시작 값 저장
        int cur ;
        while (!deque.isEmpty()){
            cur = deque.poll(); // 첫번째 값 꺼내기 현재값으로 사용

            // list 로 저장됐기 때문에 for 문이 가능하다.
            for (int i : graph.get(cur)){
                // 한개씩 움직여봤을 때 다음 값의 위치가 방문하지 않았다면 visited 업데이트 하고 deque에 집어넣자 
                if(visited[i]== -1) {
                    deque.add(i);
                    visited[i]=visited[cur]+1; // 현재의 위치에서의 거리값에 더한 값을 저장하자 
                }
            }
        }
        int max = 0; //
        int max_idx =0;
        int cur_len = 0;
        int equ_idx = 0;
        // 1부터 시작한다.
        // System.out.println(Arrays.toString(visited));
        for (int i = 1; i < N+1; i++ ) {
            cur_len = visited[i];
            if ( max < cur_len) {
                max = cur_len;
                max_idx = i;
            }
        }
        for (int i = max_idx; i < N+1; i ++) {
            if (max == visited[i]) {
                equ_idx += 1; 
            }
        }
        System.out.println(max_idx + " " +max + " " +equ_idx );

    }
}