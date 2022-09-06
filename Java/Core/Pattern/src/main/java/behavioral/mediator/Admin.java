package behavioral.mediator;

public class Admin implements User {
    Chat chat;
    String name;

    public Admin(Chat chat, String name) {
        this.name = name;
        this.chat = chat;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void sendMessage(String text) {
        chat.sendMessage(text, this);
    }

    @Override
    public void getMessage(String text) {
        System.out.println(this.name + ": " + text);
    }
}
