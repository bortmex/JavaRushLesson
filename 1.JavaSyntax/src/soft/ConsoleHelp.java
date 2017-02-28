package soft;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by alexa on 28.02.2017.
 */
public class ConsoleHelp {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static String readStr() throws IOException {
        return reader.readLine();
    }

    public static int readInt() throws IOException {
        return Integer.parseInt(reader.readLine());
    }
}
