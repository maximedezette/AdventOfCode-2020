package adventOfCode.day4;

import adventOfCode.day4.validationUtils.*;

import java.math.BigInteger;

public class PassportMapper {


    public static Passport setLineInfo(String line, Passport passport) {
        String[] lineArray = line.split(" ");
        Passport updatedPassport = passport;

        for (String bloc : lineArray) {

            String[] blocArray = bloc.split(":");
            String value = blocArray[1];

            if (birthdayIsValid(blocArray)) {
                updatedPassport.setBirthYear(Integer.parseInt(value));
            } else if (issueYearIsValid(blocArray)) {
                updatedPassport.setIssueYear(Integer.parseInt(value));
            } else if (expirationYearIsValid(blocArray)) {
                updatedPassport.setExpirationYear(Integer.parseInt(value));
            } else if (heightIsValid(blocArray)) {
                updatedPassport.setHeight(value);
            } else if (hairColorIsValid(blocArray)) {
                updatedPassport.setHairColor(value);
            } else if (eyeColorIsValid(blocArray)) {
                updatedPassport.setEyeColor(value);
            } else if (passportIdIsValid(blocArray)) {
                updatedPassport.setPassportId(new BigInteger(value));
            } else if (countryIdIsValid(blocArray[0], "cid")) {
                updatedPassport.setCountryId(Integer.parseInt(value));
            }

        }
        return updatedPassport;
    }

    private static boolean countryIdIsValid(String s, String cid) {
        return s.equals(cid);
    }

    private static boolean passportIdIsValid(String[] blocArray) {
        return blocArray[0].equals("pid") && PassportIdUtil.isValid(blocArray[1]);
    }

    private static boolean eyeColorIsValid(String[] blocArray) {
        return blocArray[0].equals("ecl") && EyeColorUtil.isValid(blocArray[1]);
    }

    private static boolean hairColorIsValid(String[] blocArray) {
        return blocArray[0].equals("hcl") && HairColorUtil.isValid(blocArray[1]);
    }

    private static boolean heightIsValid(String[] blocArray) {
        return blocArray[0].equals("hgt") && HeightUtil.isValid(blocArray[1]);
    }

    private static boolean expirationYearIsValid(String[] blocArray) {
        return blocArray[0].equals("eyr") && YearUtil.dateIsValid(blocArray[1],2020,2030);
    }

    private static boolean issueYearIsValid(String[] blocArray) {
        return blocArray[0].equals("iyr") && YearUtil.dateIsValid(blocArray[1],2010,2020);
    }

    private static boolean birthdayIsValid(String[] blocArray) {
        return blocArray[0].equals("byr") && YearUtil.dateIsValid(blocArray[1],1920,2002);
    }

}
