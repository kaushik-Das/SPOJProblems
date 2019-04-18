import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Problem6 {
    private static final char BEGIN_BRACKET = '(';
    private static final char END_BRACKET = ')';

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bufferedReader.readLine().trim());
        while (T-- > 0) {
            String expression = bufferedReader.readLine().trim();
            expression = expression.replaceAll(" ", "");
            System.out.println(resolve(expression).toString());
        }
    }

    private static StringBuilder resolve(String expression) {
        if (expression.length() == 1)
            return new StringBuilder(expression);
        String expression1 = "";
        String expression2 = "";
        String operator = "";
        if (expression.charAt(0) == BEGIN_BRACKET && expression.charAt(expression.length() - 1) == END_BRACKET)
            expression = expression.substring(1, expression.lastIndexOf(END_BRACKET));
        if (expression.charAt(0) == BEGIN_BRACKET) {
            Stack<Character> stack = new Stack<>();
            stack.push(expression.charAt(0));
            int i = 1;
            while (!stack.empty()) {
                if (expression.charAt(i) != END_BRACKET) {
                    stack.push(expression.charAt(i));
                } else {
                    while (!stack.isEmpty() && stack.pop() != BEGIN_BRACKET) {
                    }
                }
                i++;
            }
            expression1 = expression.substring(0, i);
            operator = expression.substring(i, i + 1);
            expression2 = expression.substring(i + 1, expression.length());
        } else {
            expression1 = expression.substring(0, 1);
            operator = expression.substring(1, 2);
            expression2 = expression.substring(2, expression.length());
        }
        return resolve(expression1).append(resolve(expression2)).append(operator);
    }
}
