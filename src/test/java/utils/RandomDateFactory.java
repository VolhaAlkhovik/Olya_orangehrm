package utils;

import com.github.javafaker.Faker;
import core.DateUtils;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class RandomDateFactory {

    private static final Faker faker = new Faker();

    public static String randomBirthDate() {
        LocalDate date = faker.date().birthday().toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
        return DateUtils.format(date);
    }

    public static String randomLicenseExpiry() {
        LocalDate date = faker.date().future(2000, TimeUnit.DAYS).toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
        return DateUtils.format(date);
    }
}
