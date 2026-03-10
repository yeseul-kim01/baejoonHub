
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int[][] lists = new int[N][2];
        for (int i=0; i<N;i++){
            StringTokenizer st = new StringTokenizer(bf.readLine());
            lists[i][0]= Integer.parseInt(st.nextToken());
            lists[i][1]= Integer.parseInt(st.nextToken());
        }
        Arrays.sort(lists,(a,b)-> a[0]-b[0]);

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i=0;i<N;i++){
            pq.add(lists[i][1]); // 점수 우선 집어넣기 
            int dl = lists[i][0]; // 정해진 데드라인
            if(pq.size()>dl) {
                pq.poll(); // 빼주기 데드라인보다 더 커지면 
            }
        }
        int total =0;
        while(!pq.isEmpty()) {
            total += pq.poll();
        }
        System.out.println(total);

    }
    
}
// 하루에 한개만 가능
// 정수는 다 int 로 해도 됨. 
// 가장 적은 점수를 주는애들을 빼는 방향으로 가야 된다
// 정렬은 남은 일수 기준으로 적게 남은 애들먼저 빼야 되며
// 데드라인 사이즈로 비교하면 된다. 