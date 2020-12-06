package adventOfCode.day4;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.assertj.core.api.Assertions.assertThat;

public class PassportTest {

    @Test
    void shouldBeValidWhenHasRequiredInfo(){
        Passport passport = new Passport();
        passport.setEyeColor("gry");
        passport.setPassportId(new BigInteger("860033327"));
        passport.setExpirationYear(2020);
        passport.setHairColor("#fffffd");
        passport.setBirthYear(1937);
        passport.setIssueYear(2017);
        passport.setCountryId(147);
        passport.setHeight("183cm");

        assertThat(passport.isValid()).isTrue();
    }

    @Test
    void shouldBeInvalidWhenHasNotRequiredInfo(){
        Passport passport = new Passport();
        passport.setEyeColor("amb");
        passport.setPassportId(new BigInteger("028048884"));
        passport.setExpirationYear(2023);
        passport.setHairColor("#cfa07d");
        passport.setBirthYear(1929);
        passport.setIssueYear(2013);
        passport.setCountryId(350);

        assertThat(passport.isValid()).isFalse();
    }

    @Test
    void shouldBeValidWhenMissingOnlyCid(){
        Passport passport = new Passport();
        passport.setEyeColor("gry");
        passport.setPassportId(new BigInteger("860033327"));
        passport.setExpirationYear(2020);
        passport.setHairColor("#fffffd");
        passport.setBirthYear(1937);
        passport.setIssueYear(2017);
        passport.setHeight("183cm");

        assertThat(passport.isValid()).isTrue();
    }

    @Test
    void shouldGetInfoFromLines(){
        Passport passport = new Passport();
        passport = PassportMapper.setLineInfo("ecl:gry pid:860033327 eyr:2020 hcl:#fffffd",passport);
        passport = PassportMapper.setLineInfo("byr:1937 iyr:2017 cid:147 hgt:183cm",passport);

        Passport expectedPassport = new Passport();
        expectedPassport.setEyeColor("gry");
        expectedPassport.setPassportId(new BigInteger("860033327"));
        expectedPassport.setExpirationYear(2020);
        expectedPassport.setHairColor("#fffffd");
        expectedPassport.setBirthYear(1937);
        expectedPassport.setIssueYear(2017);
        expectedPassport.setCountryId(147);
        expectedPassport.setHeight("183cm");

        assertThat(passport).isEqualTo(expectedPassport);

    }
}
