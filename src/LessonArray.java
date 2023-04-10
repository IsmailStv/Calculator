public class LessonArray {
    public static void main(String[] args){
        int[] numbers =  {1,3,5,6,9,11,24};
        int start = 4;
        int end = 10;
        printArray(getSubArrayBetween(numbers, start, end));
    }
    public static void printArray(int[] numbers) {
        System.out.print("[");
        if (numbers.length > 0) {
            for ( int i = 0; i < numbers.length ; i++) {
                if (i < numbers.length - 1) {
                    System.out.print(numbers[i] + ", ");
                } else {
                    System.out.print(numbers[i] + "]");
                }
            }
        } else {
            System.out.print("]");
        }

    }
    public static int[] getSubArrayBetween(int[] numbers, int start, int end) {
        int j = 0;
        int k = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] >= start & numbers[i] <= end) {
//                result[j] = numbers[i];
                 j++;
            }
        }
        int[] result = new int[j];
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] >= start & numbers[i] <= end) {
                result[k] = numbers[i];
                k++;
            }
        }
        return result;
    }
}
