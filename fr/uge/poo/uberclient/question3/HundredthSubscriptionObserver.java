package fr.uge.poo.uberclient.question3;

import java.util.stream.Collectors;

public class HundredthSubscriptionObserver implements NewsletterObserver{
    @Override
    public void onSubscribe(Newsletter newsletter, User user, MailService mailService) {
        if (!newsletter.is100() && newsletter.emails().size() >= 100) {
            mailService.send("sales@goodcorp.com", "A HUNDRED", newsletter.emails().values().stream().map(User::name).collect(Collectors.joining(", ")));
        }
    }

    @Override
    public void onFailedSubscribe(Newsletter newsletter, User user, MailService mailService) {

    }
}
