package adventOfCode.day4.validationUtils;

public class YearUtil {
    public static boolean dateIsValid(String year, int minYear, int maxYear) {
        boolean valid = false;
        if(!year.isEmpty() && year.matches("\\d*")){
            int numericYear = Integer.parseInt(year);
            if(numericYear >= minYear && numericYear <= maxYear){
                valid = true;
            }
        }

        return valid;
    }
}
