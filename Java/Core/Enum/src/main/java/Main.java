import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    private final static Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        System.setProperty("java.util.logging.SimpleFormatter.format",
                "%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS %4$s %2$s %5$s%6$s%n");

        List<User> users = Stream.of(
                new User(1L, "User1", Status.ACTIVE, ColorNick.GREEN, Role.ADMIN),
                new User(2L, "User2", Status.DISABLE, ColorNick.BLUE, Role.USER),
                new User(3L, "User3", Status.BANNED, ColorNick.RED, Role.USER)
        ).collect(Collectors.toList());

        for (User user: users) {
            logger.info(user.toString());
        }

        logger.log(Level.INFO, String.format("%s - %d - %s",
                Status.BANNED.name(),
                Status.BANNED.ordinal(),
                Status.valueOf("BANNED")
        ));

        logger.log(Level.INFO, String.format("%s - %s",
                ColorNick.RED.name(),
                ColorNick.RED.getColor()
        ));

        logger.info(
                String.format(
                        "\n6 + 2 = %d\n6 - 2 = %d\n6 * 2 = %d\n6 / 2 = %d",
                        Operation.SUM.action(6, 2),
                        Operation.SUB.action(6, 2),
                        Operation.MUL.action(6, 2),
                        Operation.DIV.action(6, 2)
                )
        );

        logger.info(
                String.format(
                        "\n\tUSER can read: %s, can write: %s\n\tADMIN can read: %s, can write: %s",
                        Role.USER.isCanRead(),
                        Role.USER.isCanWrite(),
                        Role.ADMIN.isCanRead(),
                        Role.ADMIN.isCanWrite()
                )
        );

    }
}
