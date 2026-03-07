import java.io.*;
import java.util.*;
//TODO: STREAM 으로 풀어보기 ** 꼭 확인해보기!!!!
public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader ( new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] visited = new int[100001]; // 시간 저장
        int[] count = new int[100001]; //개수
        Arrays.fill(visited,-1); // -1 은 방문 안한거
        visited[N] = 0 ; //처음 시작 값
        Arrays.fill(count,0); // 카운트 개수
        count[N] = 1; // 처음 시작 경로값
        Deque<Integer> queue = new ArrayDeque<>(); 
        queue.add(N); // 처음 시작 값 넣기 
        int cur;
        while(!queue.isEmpty()){
            cur = queue.poll(); // 하나씩 제거하기 
            if (cur == M){
                //목표값 이라면
                break;
            }
            // System.out.println("현재 cur 값:"+cur);
            int current = cur;
            Arrays.stream(new int[]{current + 1, current - 1, current * 2})
                .filter(i -> i >= 0 && i <= 100000)
                .forEach(i -> {
                    if (visited[i] == -1) {
                        visited[i] = visited[current] + 1;
                        count[i] = count[current];
                        queue.add(i);
                    } else if (visited[i] == visited[current] + 1) {
                        count[i] += count[current];
                    }
                });
            }
        System.out.println(visited[M]);
        System.out.println(count[M]);



    }
}