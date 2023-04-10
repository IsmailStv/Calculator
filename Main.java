import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        in.close();
        System.out.println(calc(input));
    }

    public static String calc(String input) {
        String[] elements = input.split(" ");
        if (elements.length != 3) {
            try {
                throw new Exception();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        String a = elements[0];
        String b = elements[1];
        String c = elements[2];
        boolean q = false;
        boolean w = false;
        int x;
        switch (b) {
            case "+", "-", "*", "/" -> {
            }
            default -> throw new IllegalStateException("Unexpected value: " + b);
        }
        for (int i = 0; i < 10; i++) {
            String string1 = String.valueOf(RomanNumeral.values()[i]);
            if (a.equals(string1)) {
                q = true;
                break;
            }
        }
        for (int k = 0; k < 10; k++) {
            String string2 = String.valueOf(RomanNumeral.values()[k]);
            if (c.equals(string2)) {
                w = true;
                break;
            }
        }
        if (q & w ) {
            switch (b) {
                case "+" -> {
                    x = ((RomanNumeral.valueOf(a).ordinal() + 1) + (RomanNumeral.valueOf(c).ordinal() + 1));
                    return String.valueOf(RomanNumeralXX.values()[x - 1]);
                }
                case "-" -> {
                    x = ((RomanNumeral.valueOf(a).ordinal() + 1) - (RomanNumeral.valueOf(c).ordinal() + 1));
                    if (x < 1) {
                        try {
                            throw new Exception();
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                    }
                    return String.valueOf(RomanNumeralXX.values()[x - 1]);
                }
                case "*" -> {
                    x = ((RomanNumeral.valueOf(a).ordinal() + 1) * (RomanNumeral.valueOf(c).ordinal() + 1));
                    return String.valueOf(RomanNumeralXX.values()[x - 1]);
                }
                case "/" -> {
                    x = ((RomanNumeral.valueOf(a).ordinal() + 1) / (RomanNumeral.valueOf(c).ordinal() + 1));
                    if (x < 1) {
                        try {
                            throw new Exception();
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                    }
                    return String.valueOf(RomanNumeralXX.values()[x - 1]);
                }
            }
        } else {
            int y = parseInt(elements[0]);
            int z = parseInt(elements[2]);
            if ((y < 1) || (y > 10) || (z < 1) || (z > 10)) {
                try {
                    throw new Exception();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
            switch (b) {
                case "+" -> {
                    return String.valueOf((y + z));
                }
                case "-" -> {
                    return String.valueOf((y - z));
                }
                case "*" -> {
                    return String.valueOf((y * z));
                }
                case "/" -> {
                    return String.valueOf((y / z));
                }
            }
        }
        return a;
    }

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
}
