import java.io.*;
import java.util.*;

public class Main {



    public static void main(String[] a) throws IOException {

        int size = 0; // 현재 사진틀에 걸려있는 학생 수
        int[] idxOf = new int[101]; // 학생 번호에 따른 사진틀 인덱스
        Arrays.fill(idxOf, -1); // 초기화

        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        //평행 배열 관리
        int[] num = new int[N]; 
        int[] count = new int[N];
        int[] order = new int[N]; // 처음 게시된게 언제인지 기록

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i < M; i++){
            int s = Integer.parseInt(st.nextToken()); // 추천 받은 학생번호

            if (idxOf[s] != -1) { // 이미 사진틀에 걸려 있는 학생인 경우
                count[idxOf[s]]++; // 추천 횟수 증가
                continue; // 다음 추천으로 넘어감
            }
            // 없다면 추가하기 
            if (size < N) {
                num[size] = s; // 학생 번호 저장
                count[size] = 1; // 추천 횟수 1로 초기화
                order[size] = i; // 추천 받은 순서 저장
                idxOf[s] = size; // 학생 번호에 따른 사진틀 인덱스 저장
                size++; // 사진틀에 걸려있는 학생 수 증가
                continue; 
                // 다음 추천으로 넘어감
            }

            int rm = 0; // 제거할 학생의 사진틀 인덱스
            for (int j =1; j< N; j++) {
                //제거할 학생의 사진틀 인덱스를 찾는다.
                if (count[j]<count[rm] || (count[j] == count[rm] && order[j] < order[rm])) {
                    // 추천 횟수가 더 적은 학생이 있다면 그 학생을 제거할 학생으로 설정
                    // 추천 횟수가 같다면 먼저 게시된 학생이 제거할 학생이 된다.
                    rm = j;
                }
            }
                // 제거할 학생을 골랐다면, 해당 위치에 새로운 학생으로 업데이트
                idxOf[num[rm]] = -1; // 제거되는 학생의 사진틀 인덱스 초기화
                num[rm] = s; // 새로운 학생 번호 저장
                count[rm] = 1; // 추천 횟수 1로 초기화
                order[rm] = i; // 추천 받은 순서 저장
                idxOf[s] = rm; // 학생 번호에 따른 사진틀 인덱스 저장


            }
            Arrays.sort(num, 0, size);
            for (int i = 0; i < size; i++) {
                System.out.print(num[i] + " ");
            }        
        }

    }
    
