package adventOfCode.day4.validationUtils;

public class HeightUtil {

    public static boolean isValid(String height) {
        boolean valid = false;
        int numericHeight = 0;
        if(height.matches("\\d*cm")){
            numericHeight = Integer.parseInt(height.split("cm")[0]);
            if(numericHeight >= 150 && numericHeight <= 193){
                valid = true;
            }
        }
        if(height.matches("\\d*in")){
            numericHeight = Integer.parseInt(height.split("in")[0]);
            if(numericHeight >= 59 && numericHeight <= 76){
                valid = true;
            }
        }

        return valid;
    }
}
