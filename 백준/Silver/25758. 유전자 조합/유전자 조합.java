import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap <String, Integer> map = new HashMap<>(); // 문자열과 개수를 저장하는 HashMap
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i<N;i++) {
            String s = st.nextToken();
            map.put(s, map.getOrDefault(s,0)+1); // 문자열이 이미 존재하면 개수를 1 증가, 없으면 1로 초기화
        }
        HashSet<Character> set = new HashSet<>(); // 문자열이 존재하는지 확인하는 HashSet 
        for (String i : map.keySet()) { // 첫번째 꺼
            for (String j : map.keySet()) { // 두번째 꺼
                if (i.equals(j) && map.get(i) < 2) continue; // 같은 문자열이지만 개수가 1개인 경우는 건너뛰기
                char f = i.charAt(0); // 첫번째
                char se = j.charAt(1); // 두번째
                char result = (char) Math.max(f,se); // char 중 큰 값 반환
                set.add(result); // 결과를 문자열로 변환하여 HashSet에 추가
            }
        }
        List<Character> list = new ArrayList<>(set); // HashSet을 List로 변환
        Collections.sort(list);
        StringBuilder sb = new StringBuilder();
        sb.append(list.size()).append("\n"); // 결과의 개수 추가
        for (char c : list) {
            sb.append(c).append(" "); // 결과 추가
        }
        System.out.println(sb); // 결과 출력

    }
}