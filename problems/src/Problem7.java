public class Problem7 {
    private static final String NO_NUMBER = "No Number";

    public static void main(String[] args) throws Exception {
        int N = CommonUtils.getIntegerFromConsole();
        while (N-- > 0) {
            String[] input = CommonUtils.getStringFromConsole().trim().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);
            String result = "";
            if (y == x) {
                if (x % 2 == 0) result += (2 * x);
                else result += ((2 * x) - 1);
            } else if (y == x - 2) {
                if (y % 2 == 0) result += ((2 * y) + 2);
                else result += ((2 * y) + 1);
            } else result += NO_NUMBER;
            System.out.println(result);
        }
    }
}