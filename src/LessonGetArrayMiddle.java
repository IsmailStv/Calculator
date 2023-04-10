public class LessonGetArrayMiddle {
    public static void main(String[] args){
        int[] numbers =  {1, 5, 2, 17};
//        int start = 4;
//        int end = 10;
        printArray(getArrayMiddle(numbers));
    }
    public static void printArray(int[] result) {
        System.out.print("[");
        if (result.length > 0) {
            for (int i = 0; i < result.length; i++) {
                if (i < result.length - 1) {
                    System.out.print(result[i] + ", ");
                } else {
                    System.out.print(result[i] + "]");
                }
            }
        } else {
            System.out.print("]");
        }
    }
    public static int[] getArrayMiddle(int[] numbers) {
        int k = (numbers.length%2 == 0) ? 2 : 1;
        int[] result = new int[k];
        if(k == 1) {
            result[0] = numbers[numbers.length/2];
        } else {
            result[0] = numbers[numbers.length/2 - 1];
            result[1] = numbers[numbers.length/2];
        }
        return result;
    }
}
