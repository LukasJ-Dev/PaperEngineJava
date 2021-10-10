package engine;

import java.io.InputStream;
import java.util.Scanner;

public class FileManager {

    public static String loadResource(String fileName) throws Exception {
        String result;
        try (InputStream in = FileManager.class.getResourceAsStream("/shaders/" +fileName);
             Scanner scanner = new Scanner(in, java.nio.charset.StandardCharsets.UTF_8.name())) {
            result = scanner.useDelimiter("\\A").next();
        }
        return result;
    }
}
