package streamAPI;
import java.util.function.IntSupplier;
import java.util.stream.IntStream;
public class Generator {

    public static IntStream pseudoRandomStream(int seed) {
        IntSupplier generator = new IntSupplier() {
            int current = 0;

            int mid(int idx) {
                if (idx == 0) return seed;
                int m = mid(idx - 1); m *= m;

                int result = 0, cnt = 0, r;
                while (m > 0) {
                    r = m % 10; cnt++;
                    if (cnt >= 2 && cnt <= 4) result += r * Math.pow(10, cnt - 2);
                    m /= 10;
                }

                return result;
            }

            public int getAsInt() {
                return mid(current++);
            }
        };

        IntStream natural = IntStream.generate(generator);

        return natural;
    }

    public static void main(String[] args) {

        IntStream i = pseudoRandomStream(13);
        i.limit(10).forEach(System.out::println);
    }
}