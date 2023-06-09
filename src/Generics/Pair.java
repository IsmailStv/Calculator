package Generics;

import java.util.Objects;

public class Pair <T extends Object, S extends Object> {
    private T first;
    private S second;

    public Pair(T first, S second) {
        this.first = first;
        this.second = second;
    }
    public T getFirst() {
        return first;
    }
    public S getSecond() {
        return second;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
//        if (!(o instanceof Pair<?, ?> pair)) return false;
//        return Objects.equals(getFirst(), pair.getFirst()) && Objects.equals(getSecond(), pair.getSecond());
        if (o == null || getClass() != o.getClass()) return false;
        Pair pair = (Pair) o;
        return Objects.equals(first, pair.first) &&
                Objects.equals(second, pair.second);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFirst(), getSecond());
    }
    public static Pair of(Object in, Object string) {
        Pair pair = new Pair(in,string);
        return pair;
    }

}
