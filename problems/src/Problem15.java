import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Problem15 {
    public static void main(String[] args) throws Exception {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bfr.readLine());
        while (T-- > 0) {
            String[] ab = bfr.readLine().trim().split(" ");
            int a = Integer.parseInt(ab[0]);
            int b = Integer.parseInt(ab[1]);
            if(b==0) {System.out.println(1); continue;}
            if(b%4==0){System.out.println((int)Math.pow(a,4)%10);}
            else{System.out.println((int)Math.pow(a,(b%4))%10);}
        }
    }
}