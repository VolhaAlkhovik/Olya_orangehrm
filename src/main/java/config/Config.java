package config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {
  private static final Properties PROPERTIES = new Properties();

  private Config() {

  }

  static {
    try (InputStream input =
                 Config.class.getClassLoader().getResourceAsStream("config.properties")) {
      if (input == null) {
        throw new RuntimeException("config.properties not found");
      }
      PROPERTIES.load(input);
    } catch (IOException e) {
      throw new RuntimeException("Failed to load config.properties", e);
    }
  }

  public static String getProperty(String key) {
    String value = System.getProperty(key);
    if (value == null) {
      value = PROPERTIES.getProperty(key);
    }
    return value;
  }
}
