package Collection.set_inteface;

import java.util.HashSet;
import java.util.Set;

public class SymmetricDifference {
    public static void main(String[] args) {

        Set<Integer> set1 = new HashSet<>();
        set1.add(1);
        set1.add(2);
        set1.add(3);

        HashSet<Integer> set2 = new HashSet<>();
        set2.add(0);
        set2.add(1);
        set2.add(2);

        Set<Integer> result = symmetricDifference(set1,set2);
        System.out.println(result);
    }
    public static <T> Set<T> symmetricDifference(Set<? extends T> set1, Set<? extends T> set2) {
        Set<T> set11 = new HashSet<>(set1);
        Set<T> set21 = new HashSet<>(set2);
        HashSet<T> subtract1 = new HashSet<>(set11);
        subtract1.removeAll(set21);
        HashSet<T> subtract2 = new HashSet<>(set21);
        subtract2.removeAll(set11);
        HashSet<T> union = new HashSet<>(subtract1);
        union.addAll(subtract2);
        return union;
    }
}
