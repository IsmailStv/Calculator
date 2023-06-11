package Lambda;

import java.util.function.UnaryOperator;

public class UnaryOperatorTask {
    public static void main(String[] args) {

        UnaryOperator<Integer> square = x -> x*x;
        System.out.println(square.apply(5)); // 25
    }
}
//    public UnaryOperator<Integer> sqrt() {
//        UnaryOperator<Integer> sqrt = x -> x * x;
//        return sqrt;
//    }