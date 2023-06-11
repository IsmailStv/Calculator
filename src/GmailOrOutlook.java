import java.util.regex.Pattern;

public class GmailOrOutlook {
    public static void main(String[] args) {
        String email = "kata12@gmail.com";
        System.out.println(isGmailOrOutlook(email));
//        System.out.println(isAlpha(email));
        System.out.println(email.substring(0, email.length() - 10));
    }
    public static boolean isAlpha(String email) {
        return email.matches("[a-zA-Z0-9]+");
    }
    public static boolean isGmailOrOutlook(String email){
        if (Pattern.matches("@gmail.com", email.substring(email.length() - 10)) &
        email.substring(0, email.length() - 10).matches("[a-zA-Z0-9]+")) {
            return true;
        } else if (Pattern.matches("@outlook.com", email.substring(email.length() - 12)) &
        email.substring(0, email.length() - 12).matches("[a-zA-Z0-9]+")) {
            return true;
        } else return false;
//        String emailChar = email.replaceAll("[^A-Za-z0-9]+", "");
//        if (email.length() != emailChar.length() + 2){
//            return false;
//        } else if (email.substring(email.length() - 10).equals("@gmail.com") || email.substring(email.length() - 12).equals("@outlook.com")) {
//            return true;
//        } else {
//            return false;
//        }
//        if (email.length() == email.replaceAll("[^A-Za-zА-Яа-я0-9]", "").length() + 2 & email.substring(email.length() - 10).equals("@gmail.com") || email.substring(email.length() - 12).equals("@outlook.com")) {
//            return true;
//        } else return false;
//        String gmail = email.substring(email.length() - 10);
//        boolean foundGmail = Pattern.matches("@gmail.com", gmail);
//        String outlook = email.substring(email.length() - 12);
//        boolean foundOutlook = Pattern.matches("@outlook.com", outlook);
//        boolean adres = email.length() == emailChar.length() + 2;
//        if (foundGmail || foundOutlook & adres) {
//            return true;
//        } else return false;
    }
}
