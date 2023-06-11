package Collection.set_inteface;

import java.util.HashSet;

public class HashSetEx2 {
    public static void main(String[] args) {
        HashSet<Integer> hashSet = new HashSet<>();
        hashSet.add(5);
        hashSet.add(8);
        hashSet.add(3);
        hashSet.add(1);
        hashSet.add(2);
        HashSet<Integer> hashSet1 = new HashSet<>();
        hashSet1.add(5);
        hashSet1.add(8);
        hashSet1.add(3);
        hashSet1.add(7);
        hashSet1.add(4);
        HashSet<Integer> intersect = new HashSet<>(hashSet);
        intersect.retainAll(hashSet1);
        System.out.println(intersect);
        HashSet<Integer> union = new HashSet<>(hashSet);
        union.addAll(hashSet1);
        System.out.println(union);
        HashSet<Integer> subtract = new HashSet<>(hashSet);
        subtract.removeAll(hashSet1);
        System.out.println(subtract);
        HashSet<Integer> subtract1 = new HashSet<>(hashSet1);
        subtract1.removeAll(hashSet);
        System.out.println(subtract1);
        HashSet<Integer> unionResult = new HashSet<>(subtract);
        unionResult.addAll(subtract1);
        System.out.println(unionResult);
        System.out.println(subtract.addAll(subtract1));

    }
}
