package adventOfCode.day4;

import adventOfCode.day4.validationUtils.*;

import java.math.BigInteger;
import java.util.Objects;

public class Passport {

    private String height, hairColor, eyeColor;
    private Integer birthYear, issueYear, expirationYear, countryId;
    private BigInteger passportId;

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getHairColor() {
        return hairColor;
    }

    public void setHairColor(String hairColor) {
        this.hairColor = hairColor;
    }

    public String getEyeColor() {
        return eyeColor;
    }

    public void setEyeColor(String eyeColor) {
        this.eyeColor = eyeColor;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public int getIssueYear() {
        return issueYear;
    }

    public void setIssueYear(int issueYear) {
        this.issueYear = issueYear;
    }

    public int getExpirationYear() {
        return expirationYear;
    }

    public void setExpirationYear(int expirationYear) {
        this.expirationYear = expirationYear;
    }

    public BigInteger getPassportId() {
        return passportId;
    }

    public void setPassportId(BigInteger passportId) {
        this.passportId = passportId;
    }

    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    public boolean isValid() {
        return birthYear != null && issueYear != null && expirationYear != null && height != null && hairColor != null
                && eyeColor != null && passportId != null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Passport passport = (Passport) o;
        return Objects.equals(height, passport.height) &&
                Objects.equals(hairColor, passport.hairColor) &&
                Objects.equals(eyeColor, passport.eyeColor) &&
                Objects.equals(birthYear, passport.birthYear) &&
                Objects.equals(issueYear, passport.issueYear) &&
                Objects.equals(expirationYear, passport.expirationYear) &&
                Objects.equals(countryId, passport.countryId) &&
                Objects.equals(passportId, passport.passportId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(height, hairColor, eyeColor, birthYear, issueYear, expirationYear, countryId, passportId);
    }

    @Override
    public String toString() {
        return "Password{" +
                "height='" + height + '\'' +
                ", hairColor='" + hairColor + '\'' +
                ", eyeColor='" + eyeColor + '\'' +
                ", birthYear=" + birthYear +
                ", issueYear=" + issueYear +
                ", expirationYear=" + expirationYear +
                ", countryId=" + countryId +
                ", passwordId=" + passportId +
                '}';
    }
}
