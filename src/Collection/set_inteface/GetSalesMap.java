package Collection.set_inteface;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class GetSalesMap {
    public static void main(String[] args) throws IOException {
        Reader reader = new StringReader("Алексей 3000\n" +
                "Дмитрий 9000\n" +
                "Антон 3000\n" +
                "Алексей 7000\n" +
                "Антон 8000");
        System.out.println(getSalesMap(reader));
    }
    public static Map<String, Long> getSalesMap(Reader reader) throws IOException{
        Map<String, Long> map = new HashMap();
        Scanner scanner = new Scanner(reader);
        while (scanner.hasNext() == true) {
            map.merge(scanner.next(), scanner.nextLong(), Long::sum);
        }
        return map;
    }
}
