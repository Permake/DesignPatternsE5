package fr.uge.poo.uberclient.question3;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

public class UberClient {
  private interface FirstNameStep {
    LastNameStep firstName(String firstName);
  }
  private interface LastNameStep {
    UIDStep lastName(String lastName);
  }
  private interface UIDStep {
    GradesStep uid(long uid);
  }
  private interface GradesStep {
    OptionalStep grades(List<Integer> grades);
  }
  private interface OptionalStep {
    BuildStep emails(List<String> emails);
    BuildStep phoneNumbers(List<String> phoneNumbers);
  }
  private interface BuildStep extends OptionalStep{
    UberClient build();
  }
  public static class UberClientBuilder implements FirstNameStep, LastNameStep, UIDStep, GradesStep, OptionalStep, BuildStep{
    private String firstName;
    private String lastName;
    private long uid = -1;
    private List<Integer> grades = new ArrayList<>();
    private List<String> emails = new ArrayList<>();
    private List<String> phoneNumbers = new ArrayList<>();
    private boolean randomUid = false;

    public UberClientBuilder firstName(String firstName) {
      this.firstName = Objects.requireNonNull(firstName);
      return this;
    }

    public UberClientBuilder lastName(String lastName) {
      this.lastName = Objects.requireNonNull(lastName);
      return this;
    }

    public UberClientBuilder uid(long uid) {
      if (uid<0) {
        throw new IllegalArgumentException("UID must be positive");
      }
      this.uid = uid;
      return this;
    }

    public UberClientBuilder grades(List<Integer> grades) {
      this.grades = Objects.requireNonNull(List.copyOf(grades));
      for(var grade : grades){
        if (grade < 1 ||grade > 5) {
          throw new IllegalArgumentException("All grades must be between 1 and 5");
        }
      }
      return this;
    }
    public UberClientBuilder grades(int grade) {
      if (grade < 1 || grade > 5) {
        throw new IllegalArgumentException("All grades must be between 1 and 5");
      }
      grades.add(grade);
      return this;
    }

    public UberClientBuilder emails(List<String> emails) {
      this.emails = Objects.requireNonNull(List.copyOf(emails));
      return this;
    }

    public UberClientBuilder emails(String email) {
      emails.add(Objects.requireNonNull(email));
      return this;
    }

    public UberClientBuilder phoneNumbers(List<String> phoneNumbers) {
      this.phoneNumbers = Objects.requireNonNull(phoneNumbers);
      return this;
    }

    public UberClientBuilder phoneNumbers(String phoneNumber) {
      phoneNumbers.add(Objects.requireNonNull(phoneNumber));
      return this;
    }

    public UberClientBuilder randomUid(boolean bool) {
      randomUid = bool;
      return this;
    }

    public UberClient build() {
      if (firstName == null || lastName == null || grades == null || phoneNumbers == null){
        throw new IllegalStateException();
      }
      if (grades.isEmpty()){
        throw new IllegalArgumentException("A client must have at least one grade");
      }
      if (emails.isEmpty() && phoneNumbers.isEmpty()) {
        throw new IllegalArgumentException("A client must have at least an email or a phoneNumber");
      }
      if (uid == -1 && randomUid) {
        uid = ThreadLocalRandom.current().nextLong(0,Long.MAX_VALUE);
      }
      return new UberClient(firstName, lastName, uid, grades, emails, phoneNumbers);
    }
  }
  private final String firstName;
  private final String lastName;
  private final long uid;
  private final List<Integer> grades;
  private final List<String> emails;
  private final List<String> phoneNumbers;

  private UberClient(String firstName, String lastName, long uid, List<Integer> grades, List<String> emails, List<String> phoneNumbers) {
    this.firstName = Objects.requireNonNull(firstName);
    this.lastName = Objects.requireNonNull(lastName);
    this.uid = uid;
    this.grades = List.copyOf(grades);
    this.emails = List.copyOf(emails);
    this.phoneNumbers = List.copyOf(phoneNumbers);
  }

  static void main(String[] args) {
    var arnaud = new UberClientBuilder()
            .firstName("Arnaud")
            .lastName("Carayol")
            .uid(1).grades(List.of(1,2,5,2,5,1,1,1))
            .emails(List.of("arnaud.carayol@univ-eiffel.fr","arnaud.carayol@u-pem.fr"))
            .phoneNumbers(List.of("07070707070707"))
            .build();
    var youssef = new UberClientBuilder()
            .firstName("Youssef")
            .lastName("Bergeron")
            .grades(List.of(5))
            .emails(List.of("youssefbergeron@outlook.fr"))
            .phoneNumbers(List.of())
            .build();
  }
}