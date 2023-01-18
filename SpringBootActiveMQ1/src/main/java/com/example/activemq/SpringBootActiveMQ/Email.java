package com.example.activemq.SpringBootActiveMQ;

public class Email {
    private String emailIdAddress;
    private String subject;
    private String body;

    public String getEmailIdAddress() {
        return emailIdAddress;
    }

    public void setEmailIdAddress(String emailIdAddress) {
        this.emailIdAddress = emailIdAddress;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "Email{" +
                "emailIdAddress='" + emailIdAddress + '\'' +
                ", subject='" + subject + '\'' +
                ", body='" + body + '\'' +
                '}';
    }

    public Email(String emailIdAddress, String subject, String body) {
        this.emailIdAddress = emailIdAddress;
        this.subject = subject;
        this.body = body;
    }
}
