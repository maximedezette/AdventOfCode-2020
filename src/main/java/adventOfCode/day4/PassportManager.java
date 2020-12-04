package adventOfCode.day4;

import java.util.List;

public class PassportManager {
    public int countValidPassword(List<Passport> passportList) {
        int numberOfValidPassport = 0;

        for(Passport passport : passportList){
            if(passport.isValid()){
                numberOfValidPassport++;
            }
        }

        return numberOfValidPassport;
    }
}
