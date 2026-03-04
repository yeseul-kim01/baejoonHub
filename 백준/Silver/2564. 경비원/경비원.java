import java.io.*;
import java.util.StringTokenizer;

public class Main{
    public static int width;
    public static int height;
    public static int storeCount;
    public static int guardPosition;
    public static int pullLength;
    public static int storeD;
    public static int storeP;

    public static int minDistance(int sL) {
        // 상점의 거리와 경비원의 거리를 뺀 값의 절대값이 전체 둘레의 반보다 작으면 그 값이 최단거리, 크다면 전체 둘레에서 그 값을 뺀게 최단거리
        int distance = Math.abs(sL - guardPosition);
        if (distance < (pullLength) / 2) {
            return distance;
        }
        else {
            return pullLength - distance;
        }
    }

    // 조건 분기 함수 
    // 방향과 위치를 입력받아서, 거리로 환산해서 반환하는 함수
    public static int distance(int d, int y) {
        if (d == 1) {
            return y;
        }
        else if (d == 2) {
            return width + height + width - y;
        }
        else if (d == 3) {
            return width + height + width + height - y;
        }
        else if (d == 4) {
            return width + y;
        }
        else {
            return 0;
        }
    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader( new InputStreamReader (System.in));
        // String 으로 입력받아서 split 으로 나누는건 정규식이라 느리다.
        // 그래서 StringTokenizer 를 이용해서 입력받는게 더 빠르다.


        StringTokenizer st = new StringTokenizer(br.readLine());
        width = Integer.parseInt(st.nextToken());
        height = Integer.parseInt(st.nextToken());
        pullLength = (width + height) * 2;
        storeCount = Integer.parseInt(br.readLine()); 
        int[] storeLotation = new int[storeCount];
        for ( int i = 0; i < storeCount; i++) {
            st = new StringTokenizer(br.readLine());
            storeD = Integer.parseInt(st.nextToken());
            storeP = Integer.parseInt(st.nextToken());


            // 거리의 기준점은 맨 왼쪽 맨 위를 기준으로 펼친다고 생각 
            storeLotation[i] = distance(storeD, storeP);
        }
        st = new StringTokenizer(br.readLine());
        guardPosition = distance(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        int sum = 0;
        for (int j=0; j < storeCount; j++) {
            sum += minDistance(storeLotation[j]);
        }
        System.out.println(sum);
}
}