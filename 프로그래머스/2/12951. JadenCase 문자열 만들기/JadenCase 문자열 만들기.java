//11분
import java.util.Arrays;
class Solution {
    public String solution(String s) {
        boolean state = true;
        StringBuilder answer = new StringBuilder();
        for (char i : s.toCharArray()) {
            
            if (Character.isLetter(i)) {
                if (state) {
                    answer.append(Character.toUpperCase(i));
                }
                else {
                    answer.append(Character.toLowerCase(i));
                }
            }
            else if (i==' '){
                answer.append(i);
                state = true;
                continue;
            }
            else {
                answer.append(i);
            }
            state = false;
            
        }
        
        return answer.toString();
    }
}