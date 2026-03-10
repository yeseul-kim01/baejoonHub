
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main{

    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader (new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] lists = new int[N][2]; // 보석 리스트
        int[] bags = new int[K];
        for (int i=0;i<N;i++){
            StringTokenizer st1 = new StringTokenizer(bf.readLine());
            int m = Integer.parseInt(st1.nextToken());//무게
            int v = Integer.parseInt(st1.nextToken());//가격
            lists[i][0] = m;
            lists[i][1] = v; // 보석 저장 
        }
        for (int i=0;i<K;i++){
            StringTokenizer st1 = new StringTokenizer(bf.readLine());
            int m = Integer.parseInt(st1.nextToken());//무게
            bags[i] = m; // 가방 무게 저장 
        }

        Arrays.sort(lists,(a,b)-> a[0]-b[0]); // 보석은 오름차순으로 저장, 기준은 무게로
        Arrays.sort(bags); // 가방 오름차순 저장
        int count = 0; // 탐색 중간 지점 기록용
        Long result = 0L;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder()); 
        //TODO: collections.reverseOrder시 정렬 반대로.
        for (int bag : bags){ // 가방 하나씩 넣기 , 
            while (count < N &&lists[count][0] <=bag){
                pq.add(lists[count][1]);
                count +=1;
            }
            if (!pq.isEmpty()){
                result += pq.poll();
            }
        }
        System.out.println(result);
    }
}
// 보석점 털기
// 보석 총 N 개 
// Mj와 Vj 무게와 가격을 가지고 있음
// 가방 K 개 
// 각 가방에 담을 수 있는 최대 무게는 Ci 임. 
// 가방에는 한개 씩 담을 수 있다. 
// int list 로 두개를 만든다. 그리고 각각 정렬을 때리자. -오름차순 
// 현재 가방에 들어갈수 있는 무게까지의 인덱스를 heap 에 넣고 
// heap 에서 가장 비싼걸 택하자. - maxheap 을 구현해야 한다. 