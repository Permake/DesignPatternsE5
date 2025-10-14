package fr.uge.poo.uberclient.question3;

import java.util.List;

public interface MailService {
  void send(String receiver, String title, String content);
  void sendBulk(List<String> receivers, String title, String content);
}
