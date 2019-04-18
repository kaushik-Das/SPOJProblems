import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CommonUtils {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static Integer getIntegerFromConsole() throws Exception {
        return Integer.parseInt(bufferedReader.readLine().trim());
    }

    public static String getStringFromConsole() throws Exception {
        return bufferedReader.readLine().trim();
    }

    public static Long getLongFromConsole() throws Exception {
        return Long.parseLong(bufferedReader.readLine().trim());
    }
}
