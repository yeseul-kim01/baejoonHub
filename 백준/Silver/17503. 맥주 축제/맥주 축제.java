
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Beer{
        int like;
        Long alc;
        Beer(int like,Long alc){
            this.alc = alc;
            this.like = like;
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); // 입출력 
        StringTokenizer st = new StringTokenizer(bf.readLine());  

        int N = Integer.parseInt(st.nextToken());
        Long M = Long.parseLong(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Beer[] beers = new Beer[K];

        for (int i =0;i<K;i++){
            StringTokenizer st1 = new StringTokenizer(bf.readLine());   
            int like = Integer.parseInt(st1.nextToken()); // 선호도 
            Long alc = Long.parseLong(st1.nextToken()); // 도수 
            beers[i] = new Beer(like,alc);
        }

        Arrays.sort(beers, (a,b) -> Long.compare(a.alc, b.alc)); 

        PriorityQueue<Integer> pq = new PriorityQueue<>(); // 선호도 저장 - 작은순으로 제거할거임.

        long sum = 0;

        for (Beer b : beers){
            pq.add(b.like); // 선호도 저장
            sum += b.like;
            if (pq.size()>N){
                sum -= pq.poll(); // 작은거 먼저 제거 하자. 
            }
            if (pq.size() == N && sum >= M){
                System.out.println(b.alc); // 도수가 가장 높은애 
                return;
            }
        }
        System.out.println(-1); // 중간 return 이 안되면 없다는 뜻 이므로. 
    }


    
}
// 축제 열리는 기간  N, 채워야 하는 선호도의 합 M - M 은 큰 수 BIGINTEGER 로 받아야 한다.
// 마실 수 있는 맥주 종류의 수는 K 
// 1번 부터 K번 맥주의 선호도 vi,ci  이 공백 사이에 두고 주어짐 - 정수다. 
// 종류는 모두 다름 
// 전씨의 간 레벨 과 도수레벨 비교
// 다 마신 맥주 N 개의 선호도의 합이 M 이상이 되게 해야 함. 
// 간 레벨의 최솟값을 만들어야 한다.
// k 개 중 N개를 선택할 수 있고 전체 K 개의 선호도 합은 M 이상이여야 하며, 도수레벨을 최소화 해야 한다.
// 힙과 그리디 
// 전체를 탐색해야 함.
// 도수 기준을 정렬하고 
// 가장 낮은 거 부터 꺼냄.
// 도수가 최소인게 목표기 때문에 
// 도수 기준으로 정렬을 해야한다. 