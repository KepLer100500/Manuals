import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
class User {
    private Long id;
    private String name;
    private Status status;
    private ColorNick colorNick;
    private Role role;
}
