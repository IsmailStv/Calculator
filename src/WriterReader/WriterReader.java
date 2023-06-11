package WriterReader;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class WriterReader {
    public static void main(String[] args) {
        writeText();
        readText();
    }
    private static void writeText() {
        String test = "TEST !!!";
        try (FileWriter fw =  new FileWriter("text.txt")) {
            for (int i = 0; i < test.length(); i++) {
                fw.write(test.charAt(i));
            }
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }
    }
    private static void readText() {
        try (FileReader fr = new FileReader("text.txt")) {
            StringBuilder sb = new StringBuilder();
            int code = -1;
            while ((code = fr.read()) != -1) {
                sb.append(Character.toChars(code));
            }
            System.out.println(sb.toString());
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }
    }
}
