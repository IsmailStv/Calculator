public class Palidrom {
    public static void main(String[] args) {
        String text = "Was it a cat I saw?";
//        boolean a = false;
//        isPalindrome(text);
        System.out.println(isPalindrome(text));
    }
    public static boolean isPalindrome(String text) {
        String textChar = text.replaceAll("[^A-Za-zА-Яа-я0-9]", "");
        System.out.println(textChar);
        String textReverse = new StringBuilder(textChar).reverse().toString();
        System.out.println(textReverse);
//        boolean a = textChar.equalsIgnoreCase(textReverse);
        return textChar.equalsIgnoreCase(textReverse);
    }
}
