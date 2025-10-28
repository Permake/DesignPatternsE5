package fr.uge.poo.uberclient.question3;

public class WelcomeMessageObserver implements NewsletterObserver{
    @Override
    public void onSubscribe(Newsletter newsletter, User user, MailService mailService) {
        mailService.send(user.name(), "Welcome", "Herzlich Wilkommen");
    }

    @Override
    public void onFailedSubscribe(Newsletter newsletter, User user, MailService mailService) {

    }
}
