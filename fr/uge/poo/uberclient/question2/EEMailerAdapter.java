package fr.uge.poo.uberclient.question2;

import java.util.List;

public class EEMailerAdapter implements MailService{
  private final EEMailer mailer = new EEMailer();

  @Override
  public void send(String receiver, String title, String content) {
    var mail = new EEMailer.Mail(receiver, title, content);
    mailer.send(mail);
  }

  @Override
  public void sendBulk(List<String> receivers, String title, String content) {
    receivers.forEach(receiver -> mailer.send(new EEMailer.Mail(receiver, title, content)));
  }
}
