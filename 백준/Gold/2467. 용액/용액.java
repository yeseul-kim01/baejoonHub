
import java.util.Scanner;
public class Main {

    public static void main(String[] args) throws Exception {
        
        Scanner fs = new Scanner(System.in);
        int N = fs.nextInt();
        int [] arr = new int[N];
        for (int i=0; i < N; i++){
            arr[i] = fs.nextInt();
        }
        int start= 0;
        int end = N-1;
        int min_sum = Integer.MAX_VALUE;
        int min_start = 0;
        int min_end = 0;
        while (start < end) { 
            int sum = arr[start] + arr[end];
            if (Math.abs(sum) < Math.abs(min_sum)) {
                min_sum = sum;
                min_start = start;
                min_end = end;
            }
            if (sum == 0) {
                System.out.println(arr[start] + " " + arr[end]);
                return;
            }
            else if (sum < 0) {
                start ++;
            }
            else {
                end --;
            }
        }
        System.out.println(arr[min_start] + " " + arr [min_end]);
        return;
    }
}
    
