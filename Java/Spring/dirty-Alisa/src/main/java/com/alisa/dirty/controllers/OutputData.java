package com.alisa.dirty.controllers;


public class OutputData {
    private String version;
    private Session session;
    private Response response;

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }
}

class Response {
    private boolean end_session;
    private String text;

    public String getTts() {
        return tts;
    }

    public void setTts(String tts) {
        this.tts = tts;
    }

    private String tts;

    public boolean isEnd_session() {
        return end_session;
    }

    public void setEnd_session(boolean end_session) {
        this.end_session = end_session;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
