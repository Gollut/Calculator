import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Reader {

    public String readFromFile(String fileName) {
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(fileName)))) {
            String line;
            while ((line = reader.readLine()) != null) {
                return line;
            }
        } catch (IOException e) {
            return null;
        }
        return null;
    }
}
