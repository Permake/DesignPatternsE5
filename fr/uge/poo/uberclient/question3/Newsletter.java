package fr.uge.poo.uberclient.question3;

import java.util.*;
import java.util.function.Predicate;

import static fr.uge.poo.uberclient.question3.User.Nationality.BRITISH;
import static fr.uge.poo.uberclient.question3.User.Nationality.FRENCH;

public class Newsletter {
  private String name;
  private final Predicate<User> verifier;
  private final HashMap<String, User> emails = new HashMap<>();
  private final MailService mailer;
  private final List<NewsletterObserver> observers = new ArrayList<>();
  private boolean is100 = false;

  static class NewsletterBuilder {
    private String name;
    private int minAge;
    private MailService mailer;
    private final Set<User.Nationality> authorizedNationalities = new HashSet<>();

    public NewsletterBuilder name(String name) {
      Objects.requireNonNull(name);
      this.name = name;
      return this;
    }

    public NewsletterBuilder minAge(int minAge) {
      this.minAge = minAge;
      return this;
    }
    public NewsletterBuilder nationalities(List<User.Nationality> nationalities) {
      Objects.requireNonNull(nationalities);
      this.authorizedNationalities.addAll(nationalities);
      return this;
    }

    public NewsletterBuilder nationalities(User.Nationality nationality) {
      Objects.requireNonNull(nationality);
      this.authorizedNationalities.add(nationality);
      return this;
    }

    private NewsletterBuilder mailer(MailService mailer) {
      Objects.requireNonNull(mailer);
      this.mailer = mailer;
      return this;
    }

    private MailService getDefaultMailService() {
      return new GGMailerAdapter();
    }

    public Newsletter build() {
      return new Newsletter(name,
              user -> user.age() >= minAge && (authorizedNationalities.isEmpty() || authorizedNationalities.contains(user.nationality())),
              mailer == null ? getDefaultMailService() : mailer);
    }
  }

  public Newsletter(String name, Predicate<User> verifier, MailService mailer) {
    this.name = name;
    this.verifier = verifier;
    this.mailer = mailer;
  }

  public String name() {
      return name;
  }

  public boolean is100() {
      return is100;
  }

    public HashMap<String, User> emails() {
        return emails;
    }

    public void subscribe (User user) {
    Objects.requireNonNull(user);
    if (!verifier.test(user)) {
      throw new IllegalArgumentException("The user doesn't meet the criteria for this newsletter");
    }
    var userEmail = user.email();
    if(emails.containsKey(userEmail)) {
        observers.forEach(o -> o.onFailedSubscribe(this, user, mailer));
    }
    emails.put(userEmail, user);
    observers.forEach(o -> o.onSubscribe(this, user, mailer));
    if (emails.size() == 100) is100 = true;
  }

  public void unsubscribe (User user) {
    Objects.requireNonNull(user);
    var userEmail = user.email();
    emails.remove(userEmail);
  }

  public void sendMessage (String title,  String content) {
    Objects.requireNonNull(title);
    Objects.requireNonNull(content);
    var subject  = "[" + name + "]" + title;
    mailer.sendBulk(emails.keySet().stream().toList(), subject, content);
  }

  static void main (String[] args) {
    var newsletterPotter = new NewsletterBuilder()
            .name("Potter 4ever")
            .minAge(18)
            .nationalities(BRITISH)
            .build();
    var newsletterJava = new NewsletterBuilder()
            .name("Java 4ever")
            .minAge(21)
            .nationalities(List.of(FRENCH, BRITISH))
            .mailer(new EEMailerAdapter())
            .build();
    var newsletterWhyMe = new Newsletter("Why Me!",
            user -> user.age()%2 == 0 && user.email().endsWith("@univ-eiffel.fr"),
            new NewsletterBuilder().getDefaultMailService());
  }
}
