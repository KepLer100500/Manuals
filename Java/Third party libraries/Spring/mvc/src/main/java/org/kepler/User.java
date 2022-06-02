package org.kepler;

import lombok.*;
import java.util.*;
import javax.validation.constraints.*;
import org.springframework.stereotype.Component;
import org.kepler.validation.CheckMail;


@AllArgsConstructor
@Setter
@Getter
@ToString
@Component
public class User {
    @Size(min = 5, max = 200, message = "Name must be between 5 and 200 characters")
    private String name;
    @NotBlank(message = "Password not be empty and dont be only spaces characters")
    private String pass;
    @Min(value = 1, message = "Age must be greater than 1")
    @Max(value = 100, message = "Age must be less than 100")
    private int age;
    @Pattern(regexp = "\\d{2}-\\d{2}-\\d{2}", message = "Please use pattern: XX-XX-XX")
    private String phone;
    @CheckMail
    private String email;
    private String department;
    private String subDepartment;
    private Map<String, String> subDepartments;
    @NotEmpty(message = "Sex not be empty")
    private String sex;
    private Map<String, String> sexs;
    //@NotNull
    private List<String> roles;
    private Map<String, String> rolesMap;

    public User() {
        subDepartments = new HashMap<>();
		subDepartments.put("Otdel1", "Otdel1 title");
		subDepartments.put("Otdel2", "Otdel2 title");
		subDepartments.put("Otdel3", "Otdel3 title");

        sexs = new HashMap<>();
        sexs.put("M", "Man"); // value, label
        sexs.put("F", "Female");

        //roles = new ArrayList<>();
        rolesMap = new HashMap<>();
        rolesMap.put("user", "Common user");
        rolesMap.put("moderator", "Moderator user");
        rolesMap.put("admin", "Administrator");
    }
}
