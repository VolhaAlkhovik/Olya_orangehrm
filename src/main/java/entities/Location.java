package entities;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Location {

    private String name;
    private String city;
    private String zip;
    private String phone;
}
