
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int[][] lists = new int[N][2];
        for (int i=0; i<N;i++){
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int deadLine = Integer.parseInt(st.nextToken());
            int ramen = Integer.parseInt(st.nextToken());
            lists[i][0]=deadLine;
            lists[i][1]=ramen;
        }
        Arrays.sort(lists,(a,b)->a[0]-b[0]);// 정렬하기 
        PriorityQueue<Integer> pq = new PriorityQueue<>(); // 라면 넣을거 근데 라면 가장 작은걸 먼저 빼야되니까 

        for (int i=0;i<N;i++){
           int deadLine = lists[i][0]; 
           pq.add(lists[i][1]);
           if(pq.size()>deadLine){
                pq.poll(); // 라면 가장 작은 값 제거 
           }
        }
        long sum = 0;
        while(!pq.isEmpty()){
            sum += pq.poll();
        }

        System.out.println(sum);
    }
}
// 문제 N 개에 대해선 데드라인이 있음. 받을 수 있는 컵라면이 있음.
// 데드라인은 시간임. 문제는 하나씩 밖에 못푸니까 2번 문제에 데드라인이 1이고 1번 문제에 데드라인이 1이면
// 둘중에 하나만 성공이 가능함. 
// 잘 조합해서 최대 컵라면 수를 구해야 함.
// 컵라면 수는 많이 주는 것 부터 정렬 
// 데드라인은 시간이 가장 짧은 것 부터 정렬해야 함. 
// 서로 마쳐야되는 시간이 같은 애들 중에서는 컵라면수를 많이 주는걸 선택해야 함. 
// 문제는 하나당 한시간이 걸린다. 
// 데드라인의 가장 큰 값이 최종 시간이므로 12라면 총 풀수있는 문제는 12개인게 된다. 
// 현재까지 본 문제들 중 보상이 높은 
// 한개 씩 추가해가자.