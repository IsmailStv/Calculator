import java.util.Scanner;

import static java.lang.Integer.parseInt;
public class  Test {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
//        System.out.println("Input a number:");
        String string = in.nextLine();
        String[] elements = string.split(" ");
        in.close();
        enum RomanNumeral {
            I, II, III, IV, V, VI,
            VII, VIII, IX, X
        }
        enum RomanNumeralXX {
            I, II, III, IV, V, VI, VII, VIII, IX, X, XI, XII, XIII, XIV, XV, XVI, XVII, XVIII, XIX, XX,
            XXI, XXII, XXIII, XXIV, XXV, XXVI, XXVII, XXVIII, XXIX, XXX, XXXI, XXXII, XXXIII, XXXIV, XXXV,
            XXXVI, XXXVII, XXXVIII, XXXIX, XL, XLI, XLII, XLIII, XLIV, XLV, XLVI, XLVII, XLVIII, XLIX, L, LI,
            LII, LIII, LIV, LV, LVI, LVII, LVIII, LIX, LX,  LXI, LXII, LXIII, LXIV, LXV, LXVI, LXVII, LXVIII,
            LXIX, LXX, LXXI, LXXII, LXXIII, LXXIV, LXXV, LXXVI, LXXVII, LXXVIII, LXXIX, LXXX, LXXXI, LXXXII,
            LXXXIII, LXXXIV, LXXXV, LXXXVI, LXXXVII, LXXXVIII, LXXXIX, XC, XCI, XCII, XCIII, XCIV, XCV,
            XCVI, XCVII, XCVIII, XCIX, C
        }

        String a = elements[0];
        String b = elements[1];
        String c = elements[2];
        Boolean q = false;
        Boolean w = false;
        Boolean r = false;
        int x;

        if (3 != elements.length) {
            try {
                throw new Exception();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        switch (b){
            case "+":
                r = true;
                break;
            case "-":
                r = true;
                break;
                case "*":
                r = true;
                break;
            case "/":
                r = true;
                break;
        }
        if (r == false) {
            try {
                throw new Exception();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        for (int i = 0; i < 10; i++) {
            String string1 = String.valueOf(RomanNumeral.values()[i]);
            if (a.equals(string1)) {
                q = true;
            }
        }
        for (int k = 0; k < 10; k++){
                String string2 = String.valueOf(RomanNumeral.values()[k]);
                if (c.equals(string2)){
                    w = true;
                }
        }
                if (q == true & w == true){
                    switch (b){
                        case "+":
                            x = ((RomanNumeral.valueOf(a).ordinal() + 1) + (RomanNumeral.valueOf(c).ordinal() + 1));
                            System.out.println(RomanNumeralXX.values()[x - 1]);
                            break;
                        case "-":
                            x = ((RomanNumeral.valueOf(a).ordinal() + 1) - (RomanNumeral.valueOf(c).ordinal() + 1));
                            if (x < 1) {
                                try {
                                    throw new Exception();
                                } catch (Exception e) {
                                    throw new RuntimeException(e);
                                }
                            }
                            System.out.println(RomanNumeralXX.values()[x - 1]);
                            break;
                        case "*":
                            x = ((RomanNumeral.valueOf(a).ordinal() + 1) * (RomanNumeral.valueOf(c).ordinal() + 1));
                            System.out.println(RomanNumeralXX.values()[x - 1]);
                            break;
                        case "/":
                            x = ((RomanNumeral.valueOf(a).ordinal() + 1) / (RomanNumeral.valueOf(c).ordinal() + 1));
                            if (x < 1) {
                                try {
                                    throw new Exception();
                                } catch (Exception e) {
                                    throw new RuntimeException(e);
                                }
                            }
                            System.out.println(RomanNumeralXX.values()[x - 1]);
                            break;
                    }
                }
                else {
                    int y = parseInt(elements[0]);
                    int z = parseInt(elements[2]);
                    if ((y < 0) || (y > 10) || (z < 0) || (z > 10)) {
                        try {
                            throw new Exception();
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                    }
                    switch (b) {
                        case "+":
                            System.out.println(y + z);
                            break;
                        case "-":
                            System.out.println(y - z);
                            break;
                        case "*":
                            System.out.println(y * z);
                            break;
                        case "/":

                            if (z == 0) {
                                try {
                                    throw new Exception();
                                } catch (Exception e) {
                                    throw new RuntimeException(e);
                                }
                            }
                            System.out.println(y / z);
                            break;
                    }
                }
        }
}