import static org.junit.Assert.assertEquals;
import org.junit.BeforeClass;
import org.junit.Test;

import java.time.LocalDate;
public class UserRepositoryTest {

    static UserRepository userRepo = UserRepository.getInstance();

    @BeforeClass
    public static void initialRepository() {
        LocalDate dataUser1 = LocalDate.of(1990,1,1);
        String[] userInfo1 = {"Karol", "Nowak","1990-1-1", "123345567"};
        LocalDate dataUser2 = LocalDate.of(2000,10,10);
        String[] userInfo2 = {"Anna", "Kowalska","2000-10-10", "765543321"};
        userRepo.addUser(userInfo1,dataUser1);
        userRepo.addUser(userInfo2,dataUser2);
    }

    @Test
    public void addUser() {
        //Given
        LocalDate data = LocalDate.of(1990,7,10);
        String[] userInfo = {"Adam", "Skalski", "444555666"};
        //When
        userRepo.addUser(userInfo,data);
        //Then
        assertEquals(userRepo.getUsers().size(),3);
    }

    @Test
    public void getUsers() {
        //Then
        assertEquals(userRepo.getUsers().size(), 3);
    }

    @Test
    public void findOldestUser() {
        //When
        User oldestUser = userRepo.findOldestUser();
        //Then
        assertEquals(oldestUser.getName(), "Karol");
        assertEquals(oldestUser.getLastName(), "Nowak");
    }
}