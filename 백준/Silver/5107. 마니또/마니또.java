import java.io.*;
import java.util.*;
public class Main{
    static int order;
    public static void solution(int N, HashMap<String, String> map) {
        int count = 0; // 선행 집합 개수 
        HashSet<String> set = new HashSet<>(); // 선행을 받는 사람들을 저장하는 HashSet 
        String key = null; // 선행 집합의 키값을 저장하는 변수
        while(!map.isEmpty()) {
            if(key == null) { key = map.keySet().iterator().next();} // 맨 처음 아무거나 키값을 가져옴.
            String value = map.get(key); // 그 키값에 해당하는 value값을 가져옴.
            // System.out.println(key + " " + value); // 디버깅용 출력문
            if(!set.contains(key)) {set.add(key);} // 선행 집합에 key값을 추가함.
            else{
                count++; // 선행 집합에 이미 key값이 존재한다면, 선행 집합의 개수를 하나 증가시킴.
                set.clear(); // 선행 집합을 초기화함.
                map.remove(key); // map에서 key값을 제거함.
                key = null; // key값을 초기화함.

                continue; // 다음 반복으로 넘어감.
            }
            map.remove(key); // map에서 key값을 제거함.
            key = value; // key값을 value값으로 업데이트함.
            
        } 
        count+=1;
        System.out.println(order + " " + count); // 선행 집합의 개수를 출력함.
    }
    public static void main(String[] args)  throws IOException{
        BufferedReader br = new BufferedReader( new InputStreamReader (System.in));
        int N = Integer.parseInt(br.readLine());
        order = 1;
        while (N!=0) {
            HashMap<String, String>map = new HashMap<>();
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String a = st.nextToken(); //String으로 받는 이유 = 숫자보다 길이가 길 수 있기 때문
                String b = st.nextToken();
                map.put(a, b); // a가 션행하는 사람 사람, b가 a의 선행을 받는 사람
            }
            solution(N,map);
            N = Integer.parseInt(br.readLine());
            order +=1;
        }

    }
}