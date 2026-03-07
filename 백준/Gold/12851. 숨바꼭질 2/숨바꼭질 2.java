import java.io.*;
import java.util.*;

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
            int[] nexts = {cur + 1, cur - 1, cur * 2}; // TODO: 확인하기 
            for (int i : nexts){
                if ( i <0 || i>100000) {
                    continue; // 벗어나면 그다음꺼로 넘어감 
                }
                // System.out.println("현재 확인 중인 값:"+ i);
                if (visited[i] == -1) {
                    visited[i] = visited[cur] +1; // 시간 업데이트 
                    count[i] = count[cur]; // 같은 경로니 카운트 유지시키기
                    queue.add(i);
                }
                else if (visited[i] == visited[cur]+1) {
                    // 서로 같다면 카운트를 증가시키기 
                    // 시간은 같은데 
                    count[i] += count[cur]; // 길이 하나 더 있는 거니까... 
                }
                // System.out.println("확인 마침:"+ i + "count:"+count[i]);
            }
        }
        System.out.println(visited[M]);
        System.out.println(count[M]);



    }
}