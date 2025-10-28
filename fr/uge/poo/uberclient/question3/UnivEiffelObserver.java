package fr.uge.poo.uberclient.question3;

public class UnivEiffelObserver implements NewsletterObserver{
    @Override
    public void onSubscribe(Newsletter newsletter, User user, MailService mailService) {
        if (user.email().endsWith("etud.univ-eiffel.fr")) {
            mailService.send("spy@nsa.org", "étudiant", newsletter.name());
        }
    }

    @Override
    public void onFailedSubscribe(Newsletter newsletter, User user, MailService mailService) {

    }
}
