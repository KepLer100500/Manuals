package behavioral.mediator;

import java.util.ArrayList;
import java.util.List;

public class TextChat implements Chat {
    User admin;
    List<User> users = new ArrayList<>();

    public void setAdmin(User admin) {
        this.admin = admin;
    }

    public void addUserToChat(User user) {
        users.add(user);
    }

    @Override
    public void sendMessage(String text, User user) {
        for (User u : users) {
            if(u != user) {
                u.getMessage(text);
            }
        }
        admin.getMessage(text);
    }
}
