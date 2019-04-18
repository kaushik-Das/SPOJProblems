import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Problem5 {
    private static final BigInteger[] FACT_STORE = new BigInteger[101];

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bufferedReader.readLine().trim());
        FACT_STORE[0] = BigInteger.ONE;
        FACT_STORE[1] = BigInteger.ONE;
        FACT_STORE[2] = BigInteger.valueOf(2);
        populateFactStore();
        while (T-- > 0) {
            int N = Integer.parseInt(bufferedReader.readLine().trim());
            System.out.println(FACT_STORE[N].toString());
        }
    }

    private static void populateFactStore() {
        for (int i = 3; i <= 100; i++) {
            FACT_STORE[i] = BigInteger.valueOf(i).multiply(FACT_STORE[i - 1]);
        }
    }
}
