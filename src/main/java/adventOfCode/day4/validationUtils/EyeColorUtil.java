package adventOfCode.day4.validationUtils;

public class EyeColorUtil {
    public static boolean isValid(String eyeColor) {
        return eyeColor.matches("amb|blu|brn|gry|grn|hzl|oth");
    }
}
