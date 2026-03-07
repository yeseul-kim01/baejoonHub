import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 수빈 - N, 동생 - K
        int N = Integer.parseInt(st.nextToken()); // 수빈 
        int K = Integer.parseInt(st.nextToken()); // 동생
        Deque<Integer> queue = new LinkedList<>(); // util 패키지의 Deque 이다! 

        queue.offer(N); // 시작점 수빈의 위치값을 큐에 저장
        int cur_x = 0; // 현재 위치값
        int[] visited = new int[100001]; // 방문한 위치값에 대한 시간 저장 배열
        int next_x = 0; // 다음 위치값



        // visited 초기화 -1 로 초기화 하기
        Arrays.fill(visited, 0);

        // 큐가 빌 때 까지 하기 
        while (!queue.isEmpty()) {
            cur_x = queue.poll(); // 큐에서 하나 꺼내기
            if (cur_x == K) { // 수빈이의 위치가 동생의 위치와 같아지면 반복문 탈출하기
                break;
            }

            for (int i = 0; i < 3; i++) {
                next_x = 0;
                if (i==0) {
                    next_x = cur_x + 1; // 다음 위치값은 현재 위치값 + 1
                } else if (i==1) {
                    next_x = cur_x - 1;
                } else {
                    next_x = cur_x * 2;
                }
                if (next_x < 0 || next_x > 100000) { // 다음 위치값이 범위를 벗어나면 넘어가기
                    continue;
                }
                if (visited[next_x] == 0) { // 다음 위치값이 방문한 적이 없는 위치값이면 
                    queue.offer(next_x); // 큐에 다음 위치값 저장
                    visited[next_x] = visited[cur_x] + 1; // 다음 위치값에 대한 시간 저장
                }
            }
        }
        // 수빈이의 위치가 동생의 위치와 같아지는 시간 출력하기
        System.out.println(visited[K]); // 수빈이의 위치가 동생의 위치와 같아지는 시간 출력하기, visited 배열은 1부터 시작하므로 -1 해주기
        // 시작점은 수빈에서 시작해서 그 다음 위치값을 큐에 저장, visited 에는 방문한 위치값에 대한 시간 저장  
        // 총 거리는 N이 100,000 이므로 전체 배열로 만들면 메모리가 좀 낭비 될 거같은데,, HashMap 으로 저장하면? 우선 visited 배열로 만들기. 

    }

    // 1초 후 이동 가능한 위치 x-1,x+1, 2*x 중 하나 
    // X = X+1, X = X-1, X = 2*X
    // 가장 빠른거 즉 최소 구하는 문제이르모 bfs 로 풀어야됨. bfs 는 큐 자료구조이고 너비 우선 탐색 
}