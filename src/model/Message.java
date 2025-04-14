package model;

public class Message {
    private String subject;
    private String body;
    private String sender;
    private String receiver;

    public Message(String subject, String body, String sender, String receiver){
        this.subject = subject;
        this.body = body;
        this.sender = sender;
        this.receiver = receiver;
    }

    public String getSubject() { return this.subject; }
    public String getBody() { return this.body; }
    public String getSender() { return this.sender; }
    public String getReceiver() { return this.receiver; }

    public void setSubject(String subject) { this.subject = subject; }
    public void setBody(String body) { this.body = body; }
    public void setReceiver(String receiver) { this.receiver = receiver; }
    public void setSender(String sender) { this.sender = sender; }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Mensagem : " + getSubject()).append("\n")
                .append("Enviado por : " + getSender()).append("\n")
                .append("Escrito : " + getBody()).append("\n")
                .append("Para : " + getReceiver()).append("\n");
        return sb.toString();
    }
}
