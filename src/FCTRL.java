import java.io.BufferedReader;
import java.io.InputStreamReader;

/* For any positive integer N, Z(N) is the number of zeros at the end of the decimal form of number N!. They noticed that this function never decreases. If we have two numbers N1<N2, then Z(N1) <= Z(N2). It is because we can never "lose" any trailing zero by multiplying by any positive number. We can only get new and new zeros. The function Z is very interesting, so we need a computer program that can determine its value efficiently.*/

public class FCTRL {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bufferedReader.readLine().trim());
        while (T-- > 0) {
            int N = Integer.parseInt(bufferedReader.readLine().trim());
            long result = 0;
            for (int i = 1; ; i++) {
                int count = (int) (N / (Math.pow(5, i)));
                if (count == 0)
                    break;
                result += count;
            }
            System.out.println(result);

        }
    }
}
