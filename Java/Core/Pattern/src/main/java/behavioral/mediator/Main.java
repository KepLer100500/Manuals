package behavioral.mediator;

/**
 * Посредник — это поведенческий паттерн проектирования, который позволяет уменьшить связанность
 * множества классов между собой, благодаря перемещению этих связей в один класс-посредник.
 */

public class Main {
    public static void main(String[] args) {
        TextChat chat = new TextChat();

        User admin = new Admin(chat,"admin");
        User user1 = new SimpleUser(chat,"user1");
        User user2 = new SimpleUser(chat,"user2");

        chat.setAdmin(admin);
        chat.addUserToChat(user1);
        chat.addUserToChat(user2);

        user1.sendMessage("Hello all");
        admin.sendMessage("Welcome!");

    }
}
