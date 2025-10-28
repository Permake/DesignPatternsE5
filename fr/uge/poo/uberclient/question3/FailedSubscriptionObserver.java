package fr.uge.poo.uberclient.question3;

public class FailedSubscriptionObserver implements NewsletterObserver{
    @Override
    public void onSubscribe(Newsletter newsletter, User user, MailService mailService) {

    }

    @Override
    public void onFailedSubscribe(Newsletter newsletter, User user, MailService mailService) {
        mailService.send("support@goodcorp.com", "Failed subscription", user.name());
    }
}
