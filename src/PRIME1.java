/*Peter wants to generate some prime numbers for his cryptosystem. Help him! Your task is to generate all prime numbers between two given numbers!

Input
The input begins with the number t of test cases in a single line (t<=10). In each of the next t lines there are two numbers m and n (1 <= m <= n <= 1000000000, n-m<=100000) separated by a space.

Output
For every test case print all prime numbers p such that m <= p <= n, one number per line, test cases separated by an empty line.*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class PRIME1 {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bufferedReader.readLine().trim());
        while (T-- > 0) {
            String s = bufferedReader.readLine();
            String[] input = s.trim().split(" ");
            int M = Integer.parseInt(input[0].trim());
            int N = Integer.parseInt(input[1].trim());

            List<Integer> primes = getPrimesBetweenMN(Math.min(M, N), Math.max(M, N));

            for (int i : primes) {
                System.out.println(i);
            }
            System.out.println(primes.size());
        }
    }

    private static List<Integer> getPrimesBetweenMN(int M, int N) {
        List<Integer> primes = new ArrayList<>();
        boolean[] composites = new boolean[N - M + 1];

        //populate evens
        int start = M / 2 + M % 2;
        if (start == 1) start++;
        for (int i = 2 * start; i <= N; i += 2)
            composites[i - M] = true;

        for (int i = 3; i * i <= N; i += 2) {
            start = (M / i) + (M % i == 0 ? 0 : 1);
            if (start == 1) start += 2;
            if (start % 2 == 0) start++;

            for (int j = start * i; j <= N; j += 2 * i) {
                composites[j - M] = true;
            }
        }
        for (int i = Math.max(2, M); i <= N; i++) {
            if (!composites[i - M])
                primes.add(i);
        }

        return primes;
    }

    private static List<Integer> getPrimesBetween(int M, int N) {
        List<Integer> primes = new ArrayList<>();
        boolean[] composites = new boolean[N + 1];
        if (N >= 1) {
            composites[0] = true;
            composites[1] = true;
        }


        for (int i = 2; i * i <= N; i++) {
            if (!composites[i]) {
                int start = (M / i) + ((M % i) == 0 ? 0 : 1);
                if (start == 1)
                    start++;

                for (int j = i * start; j <= N; j += i) {
                    composites[j] = true;
                }
            }

        }

        for (int i = Math.max(2, M); i <= N; i++) {
            if (!composites[i])
                primes.add(i);
        }

        return primes;
    }

    private static List<Integer> getAllPrimesBetween(int M, int N) {
        List<Integer> primes = new ArrayList<>();
        boolean[] composites = new boolean[N + 1];

        if (N >= 1) {
            composites[0] = true;
            composites[1] = true;
        }

        for (int i = 2; i * i <= N; i++) {
            if (!composites[i]) {
                for (int j = 2 * i; j <= N; j += i) {
                    composites[j] = true;
                }
            }
        }

        for (int i = Math.max(2, M); i <= N; i++) {
            if (!composites[i])
                primes.add(i);
        }
        return primes;
    }
}
