import java.io.*;
public class Main {
    static int n;
    static char[][] grid;//격자판 - char 인 이유 ?
    static StringBuilder sb = new StringBuilder();

    // 현재 구역이 단색인지 확인한다.
    static boolean isSingleColor(int x,int y, int size){
        // 기준점 (x,y)에서 size 만큼의 구역이 모두 같은 색인지 확인한다.
        // 시작점을 기준 색으로 잡는다.
        for (int k=x; k < x + size; k++) {
            for (int l = y; l < y + size; l++) {
                if (grid[k][l] != grid[x][y]) { // 기준점과 다른 색이 있으면
                    return false;
                }
            }
        }
        // 시작점을 기준으로 2중 for 문을 돌면서 저장된 색과 다르면 False를 반환
        // 모두 같으면 True 를 반환 
        return true;

    }

    // 구역을 분할하여 압축 출력을 한다. 
    // 처음 들어온 값은 입력값 그대로이다. 
    static void compress(int x, int y, int size){

    if (isSingleColor(x, y, size)) // 서로 같을 때 
    {
        sb.append(grid[x][y]); // 단색일 때 해당 색을 sb에 추가한다.
        return ;
    }


    // 들어온 x,y ,size 를 이용하여 4분할해 재귀적으로 압축한다.
    // 출력 형식은 ( 위왼, 위오, 아래왼, 아래오) 순서로 출력된다.
    // 스트링으로 출력되므로 isSingle 을 거쳐온 경우에 해당 색을 sb에 추가하면 된다. 
    // 만약에 singleColor 가 아니면 sb에 ( 를 추가하고 4분할하여 재귀적으로 compress 함수를 호출한다.
    sb.append("(");
    int newS = size / 2; // 새로운 사이즈는 기존 사이즈의 절반이다.
    //왼쪽 위에꺼
    compress(x,y, newS);
    //오른쪽 위에꺼
    compress(x+newS,y, newS);
    //왼쪽 아래에꺼
    compress(x,y+newS, newS);
    //오른쪽 아래에꺼
    compress(x+newS,y+newS, newS);
    sb.append(")");
    return ; }

    public static void main(String[] args) throws Exception {
        // 입력값을 받아 grid 에 저장한다,
        // 이때 x,y는 0,0 부터 시작되며, 
        //입력한 순서에 맞춰 x,y가 증가한다.
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        // 한줄을 입력 받고 for 문 돌리기 
        n = Integer.parseInt(br.readLine());
        grid = new char[n][n];
        // N은 격자 크기이다. 
        for ( int i = 0; i < n; i++ ) {
            // i 는 y축의 위치임
            // 한줄은 01101 이런식으로 이어붙여져서 들어온다.
            String line = br.readLine().trim();
            for ( int j = 0; j < n; j++ ) {
                // j 는 x축의 위치임
                grid[j][i] = line.charAt(j); // j는 x축의 위치, i는 y축의 위치 //charAt은 문자열에서 특정 위치의 문자를 반환하는 메소드이다.
            }
        }

        // 입력이 끝나면 compress 함수를 호출하여 압축된 결과를 sb에 저장한다.
        compress(0,0,n);
        System.out.println(sb.toString()); // sb에 저장된 압축된 결과를 출력한다.
    }
}

