
import java.util.Scanner;


public class Main {
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        int M = input.nextInt();
        long [] arr = new long[N];
        int sumFirst = 0;
        boolean state = true;
        for ( int i=0;i<N;i++) {
            arr[i] = input.nextInt();
            sumFirst += arr[i];
            if( arr[i] == M) {
                System.out.println(1);
                state = false;
                return;                
            }
        }
        // System.out.println("sumFirst: "+ sumFirst);
        if (sumFirst<M){
            System.out.println(0);
            state = false;
            return;
        }
        int r = 0 , l = 0;
        int leng = Integer.MAX_VALUE;
        int sum = 0;
        while (true) { 
            if (sum>=M){
                leng = Math.min(leng,r-l);
                state = false;
                l ++;
                sum -= arr[l-1];
            }
            else if (r ==N){
                break;
            }
            else {
                r ++;
                sum += arr[r-1];
            }
        }
        if (state) {
            System.out.println(0);
        }
        else {System.out.println(leng);}
    
    }
}
