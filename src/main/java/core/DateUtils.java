package core;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateUtils {
  private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-dd-MM");

  private DateUtils() {

  }

  public static String format(LocalDate date) {
    return date.format(FORMATTER);
  }
}
