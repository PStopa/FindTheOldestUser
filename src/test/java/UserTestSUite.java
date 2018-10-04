import static org.junit.Assert.assertEquals;
import org.junit.BeforeClass;
import org.junit.Test;

import java.time.LocalDate;

public class UserTestSUite {

    static User user;

    @BeforeClass
    public static void initialUser() {
        LocalDate data = LocalDate.of(1990,1,1);
        user = new User("Karol", "Nowak", data, "123345567");
    }

    @Test
    public void returnAgeOfUserTest() {
        //Given & When
        int resultAge = user.returnAgeOfUser();
        int expectedAge = 28;

        //Then
        assertEquals(expectedAge,resultAge);
    }

    @Test
    public void getNameTest() {
        //Given & When
        String returnName = user.getName();
        String expectedName = "Karol";

        //Then
        assertEquals(expectedName,returnName);
    }

    @Test
    public void getLastNameTest() {
        //Given & When
        String returnLastName = user.getLastName();
        String expectedLastName = "Nowak";

        //Then
        assertEquals(expectedLastName,returnLastName);
    }

    @Test
    public void getPhoneNumberTest() {
        //Given & When
        String returnPhoneNumber = user.getPhoneNumber();
        String expectedPhonenUmber = "123345567";

        //Then
        assertEquals(expectedPhonenUmber,returnPhoneNumber);
    }
}