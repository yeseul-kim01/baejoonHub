import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        // A 의 부 배열의 합은 최소 ( T의 값 - B의 부 배열 중 최대값) 이고, 최대는 (T의 값 - B의 부 배열 중 최소값) 이다.
        // B의 부 배열의 합은 최소 (T의 값 - A의 부 배열 중 최대값) 이고, 최대는 (T의 값 - A의 부 배열 중 최소값) 이다.

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long T = Long.parseLong(br.readLine());
        int Anum = Integer.parseInt(br.readLine()); 
        Long[] A = new Long[Anum];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < Anum; i++){
            A[i] = Long.parseLong(st.nextToken());
        }
        int Bnum = Integer.parseInt(br.readLine());
        Long[] B = new Long[Bnum];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < Bnum; i++){
            B[i] =Long.parseLong(st.nextToken());
        }
        
        List<Long> sumA = new ArrayList<>();
        List<Long> sumB = new ArrayList<>();
        // A 의 부분합을 저장한 배열 먼저 구하기 
        for (int i = 0; i < Anum; i++) {
            long sum = 0;
            for (int j = i; j < Anum; j++) {
                sum += A[j];
                sumA.add(sum);
                
            }
        }
        //디버깅용
        // System.out.println("A의 부분합 개수: " + sumA.toString());
        // B 의 부분합을 저장한 배열 구하기
        for (int i = 0; i < Bnum; i++) {
            long sum = 0;
            for (int j = i; j < Bnum; j++) {
                sum += B[j];
                sumB.add(sum);
                
            }
        }
        // System.out.println("B의 부분합 개수: " + sumB.toString());

        HashMap<Long, Long> map = new HashMap<>();
        long answer = 0;
        for (long a : sumA) {
            map.put(a, map.getOrDefault(a, 0L) + 1);
        }
        for (long b : sumB) {
            long complement = T - b;
            if (map.containsKey(complement)) {
                answer += map.get(complement);
            }
        }
        
        System.out.println(answer);
    }
}