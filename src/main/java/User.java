import java.time.LocalDate;
import java.time.Period;

public class User {
    private String name;
    private String lastName;
    private LocalDate bornDate;
    private String phoneNumber;

    public User(String name, String lastName, LocalDate bornDate, String phoneNumber) {
        this.name = name;
        this.lastName = lastName;
        this.bornDate = bornDate;
        this.phoneNumber = phoneNumber;
    }

    public User(String name, String lastName, LocalDate bornDate) {
        this.name = name;
        this.lastName = lastName;
        this.bornDate = bornDate;
    }

    @Override
    public String toString() {
        return name + " " + lastName + ", " + returnAgeOfUser() + ", phone: " + phoneNumber;
    }

    public LocalDate getBornDate() {
        return bornDate;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public int returnAgeOfUser() {
        return Period.between(bornDate, LocalDate.now()).getYears();
    }
}

