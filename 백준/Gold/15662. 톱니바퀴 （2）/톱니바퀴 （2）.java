import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
public class Main {
    
    // 삽입과 추가가 Linkedlist 로 
    // 톱니바퀴를 linkedList에 저장할 거임.
    static LinkedList<Integer>[] list;
    // 큐에 rotation 돌려야되는 애들 집어넣기 
    // 큐는 [num,dir] 로 저장할 거임.
    static Queue<int[]> queue = new LinkedList<>();
    static int t;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader ( new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        list = new LinkedList[t];
        for ( int i = 0; i < t; i++) {
            String input = br.readLine();
            list[i] = new LinkedList<>();
            for ( int j = 0; j < 8; j++) {
                list[i].add(input.charAt(j)-'0');
            }
        }
        int k = Integer.parseInt(br.readLine());
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken()) -1;
            int dir = Integer.parseInt(st.nextToken());
            rotate(num, dir);
        }
        int count = 0;
        for (int i = 0; i<t;i++){
            if (list[i].get(0)==1){
                count++;
            }
        }
        System.out.println(count);
    }

    private static void rotate(int num, int dir) {
        int [] rot = new int [t];
        Arrays.fill(rot,0);
        queue = new LinkedList<>();
        queue.add(new int[] {num, dir});
        rot[num] = dir;
        while(!queue.isEmpty()) {
            int cur_num, cur_dir;
            int[] cur = queue.poll();
            cur_num = cur[0];
            cur_dir = cur[1];
            // 왼쪽 먼저 확인 해야 함. 
            if (cur_num>0 && rot[cur_num-1] ==0){
                if  (list[cur_num].get(6) != list[cur_num - 1].get(2)){
                    rot[cur_num -1] = -cur_dir;
                    queue.add(new int[] {cur_num -1, -cur_dir});
                }
            }
            // 오른쪽 확인 
            if (cur_num < t-1 && rot[cur_num +1] ==0) {
                if  (list[cur_num].get(2) != list[cur_num + 1].get(6)){
                    rot [cur_num +1] = -cur_dir;
                    queue.add(new int[] {cur_num +1, -cur_dir});
                }

        }
    }
        for (int i = 0; i < t; i++) {
            int k = rot[i];
            if ( k == 0) continue;
            else if (k==1) {
                list[i].addFirst(list[i].removeLast());
            }
            else {
                list[i].addLast(list[i].removeFirst());
            }
        }
        
    }
}
