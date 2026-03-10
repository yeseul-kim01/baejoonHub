import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException  {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());

        Long[][] classLists = new Long[N][2];

        for (int i =0; i<N; i++){
            StringTokenizer st = new StringTokenizer(bf.readLine());
            Long start = Long.parseLong(st.nextToken());
            Long end = Long.parseLong(st.nextToken());
            classLists[i][0] = start;
            classLists[i][1] = end; 
        }
        // start 기준으로 정렬하기
        Arrays.sort(classLists,(a,b)-> Long.compare(a[0], b[0]));
        PriorityQueue<Long> pq = new PriorityQueue<>(); // 큐 만들기 우선순위큐로 작은값을 먼저 빼자. 
        pq.add(classLists[0][1]);// 끝에 있는 거 저장하기
        for (int i=1;i<N;i++){ // 1부터 시작. 위에 꺼 넣어놨으니까
            if (pq.peek() <= classLists[i][0]){
                pq.poll();
            }
            pq.add(classLists[i][1]);
        }
        System.out.println(pq.size());
    }
    // 최소의 강의실을 사용해서 모든 수업을 가능하게 해야함.
    // 수ㅜ업이 끝난 직후에 다음 수업 시작 가능. 시간이 똑같으면 같이할 수 있음. 
    // 강의실 최소- 강의실 기준으로 정렬하자. 
    // 수업의 개수가 주어진다.
    // 처음 한개 씩 꺼낼 때는 시작 시간이 최소인 값부터 하나씩 꺼냄. 
    // 꺼내고 나서 시작 시간과 강의실 list 에 있는 시간을 비교해서 이을 수 있는게 없다면, 강의실 list 에다가 끝나는 시간을 저장함. 
    // 강의실 리스트는 저장될 때 가장 최솟값을 먼저 꺼낼수 있도록 meanqueue 를 사용하자
}