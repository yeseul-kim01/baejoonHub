import java.util.*;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.*;
//TODO: stream 스트림 연습 
class Solution {
    public int solution(String[][] clothes) {
    return Arrays.stream(clothes)
    .collect(Collectors.groupingBy(t -> t[1],mapping(t->t[0], counting())))
    .values().stream()
    .collect(reducing(1L,(x,y) -> x*(y+1))).intValue()-1;
}
}
// 카테고리별 데이터 집계 하는 법 
