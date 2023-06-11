package Collection.set_inteface;

import java.util.HashSet;
import java.util.Set;

public class HashSetEx {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("Zaur");
        set.add("Oleg");
        set.add("Marina");
        set.add("Igor");
//        set.add(null);
        set.remove("Zaur");
        System.out.println(set.contains("Marina"));
        for(String s: set) {
            System.out.println(s);
        }
    }
}
