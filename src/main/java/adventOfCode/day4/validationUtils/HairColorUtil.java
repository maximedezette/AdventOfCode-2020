package adventOfCode.day4.validationUtils;

public class HairColorUtil {
    public static boolean isValid(String hairColor) {
        return hairColor.matches("#([a-f]|\\d){6}");
    }
}
