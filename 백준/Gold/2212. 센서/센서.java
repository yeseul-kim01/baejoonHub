
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static class Node {
        int gap; // 차이 저장 
        int startidx; // 시작하는 값 저장 
        Node(int gap,int startidx){
            this.gap = gap;
            this.startidx = startidx;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine()); // 센서 개수
        int K = Integer.parseInt(bf.readLine()); // 집중국 개수 

        StringTokenizer st = new StringTokenizer(bf.readLine());

        int [] lists = new int[N];

        for (int i=0; i<N;i++){
            lists[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(lists); // 오름차순으로 정렬하기 
        if (K >= N) {
            System.out.println(0);
            return;
        }        
        PriorityQueue<Node> pq = new PriorityQueue<>((Node a,Node b)-> b.gap - a.gap); // 반대로 저장해야되니까. 큰 수부터 뺴야됨.. 
        Node[] nodes = new Node[N-1];
        int allgap = 0;
        for (int i=0; i<N-1;i++){
            int gap = lists[1+i] - lists[i];
            allgap += gap;
            nodes[i] = new Node(gap, i);
            pq.add(nodes[i]);
        }
        int sum =0;        
        for (int i=0;i<K-1;i++){
            // 총 k-1개의 선을 그려야 되므로 
            Node n = pq.poll();
            sum += n.gap;
        }
        System.out.println(allgap-sum);

        
    }
    
}
// 센서 개수 N 개 , int
// 집중국 개수 K 개 , int 
// 센서 좌표 int 로 반환 

// k를 막대기로 생각
// k 가 2이면 수평상 그룹을 두개만드는거니까 총 1번의 직선을 그음
// 각 직선으로 만들어진 그룹의 최대값-최소값 끼리의 합이 가장 작아야 한다. 
// 정렬 시켜야 됨. 좌표 거리에 따라서 오름차순으로 
// Maxheap 에다가 저장해야 함. 가장 큰 값을 먼저 빼야 하고, 해당 값을 뺐을 때 자르는 위치의 시작 인덱스도 저쟝해야지 헷갈리지 않는다. 