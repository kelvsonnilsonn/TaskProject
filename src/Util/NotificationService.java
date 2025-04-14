package Util;

import Interfaces.Notification;
import model.Message;

public class NotificationService implements Notification {
    @Override
    public void sendEmail(Message message){
        System.out.printf("Enviando %s para %s...", message.getSubject(), message.getReceiver());
    }
}
