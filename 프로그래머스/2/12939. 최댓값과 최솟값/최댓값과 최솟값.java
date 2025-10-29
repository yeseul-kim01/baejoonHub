class Solution {
    public String solution(String s) {
        String answer = "";
        
        // 공백으로 문자열 나눠서 문자열 배열에 담기
        String[] parts = s.split(" ");
        
        // 문자열 배열의 길이만큼 정수 배열 만들기
        int[] numbers = new int[parts.length];
        
        // 문자열 하나씩 정수로 바꿔서 numbers에 저장하기
        for (int i =0; i<parts.length; i++) {
            // Integer.parseInt (변환)
            numbers[i] = Integer.parseInt(parts[i]);
        }
        
        // min max 처음 값으로 초기화하기
        int min = numbers[0];
        int max = numbers[0];
            
        for (int num : numbers) {
            if (min>num) {
                min = num;
            }
            if (max<num) {
                max = num;
            }
        }
        
        // String.valueOf == Integer.toString
        answer += String.valueOf(min) +" " +Integer.toString(max);
        
        return answer;
    }
}