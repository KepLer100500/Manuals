package com.alisa.dirty.controllers;
import com.google.gson.annotations.SerializedName;


public class InputData {
    private Meta meta;
    private Session session;
    private Request request;
    private String version;

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public Request getRequest() {
        return request;
    }

    public void setRequest(Request request) {
        this.request = request;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}

class Meta {
    private String locale;
    private String timezone;
    private String client_id;
    private Interfaces interfaces;

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public String getClient_id() {
        return client_id;
    }

    public void setClient_id(String client_id) {
        this.client_id = client_id;
    }

    public Interfaces getInterfaces() {
        return interfaces;
    }

    public void setInterfaces(Interfaces interfaces) {
        this.interfaces = interfaces;
    }
}

class Interfaces {
    private Screen screen;
    private Payments payments;
    private Account_linking account_linking;

    public Screen getScreen() {
        return screen;
    }

    public void setScreen(Screen screen) {
        this.screen = screen;
    }

    public Payments getPayments() {
        return payments;
    }

    public void setPayments(Payments payments) {
        this.payments = payments;
    }

    public Account_linking getAccount_linking() {
        return account_linking;
    }

    public void setAccount_linking(Account_linking account_linking) {
        this.account_linking = account_linking;
    }
}

class Screen {

}

class Payments {

}

class Account_linking {

}

class Session {
    private int message_id;
    private String session_id;
    private String skill_id;
    private User user;
    private Application application;
    private @SerializedName("new") boolean new_;
    private String user_id;

    public int getMessage_id() {
        return message_id;
    }

    public void setMessage_id(int message_id) {
        this.message_id = message_id;
    }

    public String getSession_id() {
        return session_id;
    }

    public void setSession_id(String session_id) {
        this.session_id = session_id;
    }

    public String getSkill_id() {
        return skill_id;
    }

    public void setSkill_id(String skill_id) {
        this.skill_id = skill_id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Application getApplication() {
        return application;
    }

    public void setApplication(Application application) {
        this.application = application;
    }

    public boolean getNew_() {
        return new_;
    }

    public void setNew_(boolean new_) {
        this.new_ = new_;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }
}

class User {
    private String user_id;

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }
}

class Application {
    private String application_id;

    public String getApplication_id() {
        return application_id;
    }

    public void setApplication_id(String application_id) {
        this.application_id = application_id;
    }
}

class Request {
    private String command;
    private String original_utterance;
    private Nlu nlu;
    private Markup markup;
    private String type;

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public String getOriginal_utterance() {
        return original_utterance;
    }

    public void setOriginal_utterance(String original_utterance) {
        this.original_utterance = original_utterance;
    }

    public Nlu getNlu() {
        return nlu;
    }

    public void setNlu(Nlu nlu) {
        this.nlu = nlu;
    }

    public Markup getMarkup() {
        return markup;
    }

    public void setMarkup(Markup markup) {
        this.markup = markup;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}

class Nlu {
    private String[] tokens;
    private String[] entities;
    private Intents intents;

    public String[] getTokens() {
        return tokens;
    }

    public void setTokens(String[] tokens) {
        this.tokens = tokens;
    }

    public String[] getEntities() {
        return entities;
    }

    public void setEntities(String[] entities) {
        this.entities = entities;
    }

    public Intents getIntents() {
        return intents;
    }

    public void setIntents(Intents intents) {
        this.intents = intents;
    }
}

class Intents {

}

class Markup {
    private boolean dangerous_context;

    public boolean isDangerous_context() {
        return dangerous_context;
    }

    public void setDangerous_context(boolean dangerous_context) {
        this.dangerous_context = dangerous_context;
    }
}
