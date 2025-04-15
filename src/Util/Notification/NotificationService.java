package Util.Notification;

import Interfaces.NotificationInterface;
import model.Message;

public class NotificationService implements NotificationInterface {
    @Override
    public void sendEmail(Message message){
        System.out.printf("Enviando %s para %s...", message.getSubject(), message.getReceiver());
    }
}
