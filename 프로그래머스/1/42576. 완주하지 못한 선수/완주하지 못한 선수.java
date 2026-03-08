
import java.util.HashMap;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String,Long> requestCount = new HashMap<>(); 
        for (String req: participant) {
            requestCount.put(req,requestCount.getOrDefault(req,0L)+1 ); //  있다면 그 값에 +1, 없다면 0+1 로 계산
        }
        for(String complet:completion){
            requestCount.put(complet,requestCount.getOrDefault(complet, 1L)-1);
        }
        for(String noComlet: requestCount.keySet()){
            if (requestCount.get(noComlet)>0){
                answer += noComlet;
            }
        }
        return answer;
    }
}