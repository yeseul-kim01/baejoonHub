class Solution {
        static int step; // static 변수로 저장하는 이유 - 완전 탐색 문제이기 때문에, step 이라는 변수를 여러번 바꿔가면서 탐색해야 됨.
    static int result; // 압축 결과 길이 저장하는 변수. 완전 탐색 문제이기 때문에, result 라는 변수를 여러번 바꿔가면서 탐색해야 됨.
    static int step_result;
    public int solution(String s) {

        int length = s.length();

        if (length==1) {return 1;} // 길이가 1인 경우는 압축이 안되니까, 바로 1 반환.

        // 문자열을 몇 글자 단위로 자를지 다 해봐야 됨. 즉 1개 부터 length/2 까지.
        // 각 스텝마다 압축 결과 길이를 계산해서 가장 짧은 길이를 저장한다
        result = length; // 초기값은 원래 문자열 길이로 설정. 압축이 안되는 경우도 있기 때문에.
        
        step_result = length; // step_result 는 각 스텝마다 압축 결과 길이 저장하는 변수. 초기값은 원래 문자열 길이로 설정. 압축이 안되는 경우도 있기 때문에.


        // step 업데이트
        for (step = 1 ; step<=length/2; step++) {
            System.out.println("step: " + step); // 디버깅용 출력문
            StringBuilder compressed = new StringBuilder(); // 압축된 문자열 저장하는 StringBuilder. 매 스텝마다 초기화 해줘야 됨.
            String prev = s.substring(0, step); // 이전 문자열 저장하는 변수. 초기값은 첫 번째 단위로 자른 문자열.
            int count = 1; // 반복 횟수 저장하는 변수. 초기값은 1로 설정. 첫 번째 단위는 이미 prev 에 저장되어 있기 때문에.

            for( int i = step; i < length; i+= step) {
                // 조각을 꺼내서 비교하기 
                int end = Math.min(i+step,length); // 마지막 조각이 step 보다 짧을 수 있기 때문에, end 는 i+step 과 length 중 작은 값으로 설정.
                String current = s.substring(i,end);

                if (prev.equals(current)) {
                    count++; // 이전 문자열과 현재 문자열이 같으면, count 증가.
                } else {
                    // 이전 문자열과 현재 문자열이 다르면, 압축된 문자열에 추가하기
                    if (count > 1) {
                        compressed.append(count); // count 가 1보다 크면, count 도 추가하기
                    }
                    compressed.append(prev); // 이전 문자열 추가하기
                    prev = current; // prev 업데이트 하기
                    count = 1; // count 초기화 하기
                }
            }

            // 마지막으로 남은 문자열 처리하기
            if (count > 1) {
                compressed.append(count); // count 가 1보다 크면, count 도 추가하기
            }
            compressed.append(prev); // 마지막 문자열 추가하기

            step_result = compressed.length();
            // step 이 끝난 후 우선 결과 반환 해주기 
            if (step_result < result) {
                result = step_result;
            }

        }
        return result;
    }
}