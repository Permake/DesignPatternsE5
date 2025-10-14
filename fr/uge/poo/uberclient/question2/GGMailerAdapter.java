package fr.uge.poo.uberclient.question2;

import java.util.List;

public class GGMailerAdapter implements MailService{
  private final GMailer mailer = new GMailer();
  @Override
  public void send(String receiver, String title, String content) {
    var mail = new GMailer.Mail( title, content);
    mailer.send(receiver, mail);
  }

  @Override
  public void sendBulk(List<String> receivers, String title, String content) {
    var mail = new GMailer.Mail( title, content);
    mailer.sendBulk(receivers, mail);
  }
}
