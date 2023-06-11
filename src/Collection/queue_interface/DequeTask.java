package Collection.queue_interface;

import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class DequeTask {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int n = 0;
        Deque<Integer> deque = new ArrayDeque<>();
        while (scanner.hasNextInt()) {
            if (n % 2 != 0) {
                deque.addFirst(scanner.nextInt());
            } else {
                scanner.next();
            }
            n++;
        }
        while (deque.peek() != null) {
            System.out.print(deque.pop() + " ");
        }
    }
}
