package Collection;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SalesMap {
    public static void main(String[] args) throws IOException {
        ByteArrayInputStream bais = new ByteArrayInputStream("Алексей 3000\nДмитрий 9000\nАнтон 3000\nАлексей 7000\nАнтон 8000".getBytes());
        BufferedReader buffReader = new BufferedReader(new InputStreamReader(bais));
        getSalesMap(buffReader);
        System.out.println(getSalesMap(buffReader));
    }

    public static Map<String, Long> getSalesMap(BufferedReader reader) throws IOException {
        Map<String, Long> map = new HashMap();
        Scanner scanner = new Scanner(reader);
        String name;
        long salary;

//        BiFunction<Long, Long, Long> bFunc = (oldValue, newValue) -> oldValue + newValue;
        while (scanner.hasNext() == true) {
            name = scanner.next();
            salary = scanner.nextLong();
            if (map.containsKey(name)) {
                map.merge(name, salary, Long::sum);
            } else {
                map.put(name, salary);
            }
        }
        return map;
    }
}