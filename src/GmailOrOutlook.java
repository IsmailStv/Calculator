public class GmailOrOutlook {
    public static void main(String[] args) {
        String email = "kata12@gmail.com";
        System.out.println(isGmailOrOutlook(email));
    }
    public static boolean isGmailOrOutlook(String email){
        String emailChar = email.replaceAll("[^A-Za-zА-Яа-я0-9]", "");
        if (email.length() != emailChar.length() + 2){
            return false;
        } else if (email.substring(email.length() - 10).equals("@gmail.com") || email.substring(email.length() - 12).equals("@outlook.com")) {
            return true;
        } else {
            return false;
        }
    }
}
