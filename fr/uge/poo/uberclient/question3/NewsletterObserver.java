package fr.uge.poo.uberclient.question3;

public interface NewsletterObserver {

    void onSubscribe(Newsletter newsletter, User user, MailService mailService);
    void onFailedSubscribe(Newsletter newsletter, User user, MailService mailService);
}
