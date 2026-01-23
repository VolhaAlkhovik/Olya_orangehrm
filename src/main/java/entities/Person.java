package entities;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Person {

    private String firstName;
    private String middleName;
    private String lastName;
    private String otherId;
    private String driverLicenseNumber;
    private String licenseExpirydate;
    private String nationality;
    private String maritalStatus;
    private String dateOfBirth;
    private String gender;
}
