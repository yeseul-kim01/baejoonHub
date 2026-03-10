
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    // 두 함수에서 쓰일 변수 넣기
    static int N; // 크기 개수
    static int[] list; // 배열 들어갈 거
    static Long all = 0L;
    static Long max_money;
    public static int coculMean(int left,int right){
        return (left+right)/2; // 평균 저장 - int 임. 더 작은 값 넣으면 됨. 
    }

    public static int binarySearch(int left, int right) {

        int answer = 0;
    
        while (left <= right) {
    
            int mid = (left + right) / 2;
    
            long total = 0;
    
            for (int i = 0; i < N; i++) {
                total += Math.min(list[i], mid);
            }
    
            if (total <= max_money) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
    
        return answer;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());//10000이하 값이므로 int 로 가져간다.
        StringTokenizer st = new StringTokenizer(br.readLine());
        list = new int[N];
        int max_list = 0;
        for (int i= 0; i<N;i++){
            list[i] = Integer.parseInt(st.nextToken()); // 한개씩 집어넣기 
            int a = list[i];
            all += a;
            if (max_list<a){
                max_list = a;
            }
        }
        max_money = Long.parseLong(br.readLine());//10000이하 값이므로 int 로 가져간다.
        if (all <= max_money){
            System.out.println(max_list);
        }
        else {
            int f_left = 0; // 첫번째 꺼 저장 
            int f_right = max_list; // 마지막 꺼
            int result = binarySearch(f_left, f_right);
            System.out.println(result);
        }
    }


}

// 국가의 예산의 총액은 미리 정해져있다.
// 정해진 총액 이하에서 가능한 한 최대의 총 예산을 다음과 같은 방법으로 배정한다
// 특정한 정수 상한액을 계산해서 그 이상인 예상 요청에는 모두 상한액을 배정
// 상한액 이하으 ㅣ예산은 요청한 금액 그대로 배정
