public class LongParseAndSqrt {
    public static void main(String[] args) {
        String number = "5";
        System.out.println(parseAndSqrt(number));
    }
    public static long parseAndSqrt(String number) {
//        long a = Long.parseLong(number);
//        double b = Math.sqrt(a);
        return Math.round(Math.sqrt(Long.parseLong(number)));
    }
}

