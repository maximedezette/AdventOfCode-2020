package adventOfCode.day4.validationUtils;

public class PassportIdUtil {
    public static boolean isValid(String pid) {
        return pid.matches("\\d{9}");
    }
}
