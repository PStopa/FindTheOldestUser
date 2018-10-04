import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UserRepository {
    private static UserRepository userListsInstance = null;
    private ArrayList<User> users;

    private UserRepository() {
        users = new ArrayList<>();
    }

    public static UserRepository getInstance() {
        if (userListsInstance == null) {
            userListsInstance = new UserRepository();
        }
        return userListsInstance;
    }

    public void addUser(String[] userData, LocalDate date) {
        if (userData.length == 4) {
            users.add(new User(userData[0], userData[1], date, userData[3]));
        } else if (userData.length == 3) {
            users.add(new User(userData[0], userData[1], date));
        }
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public User findOldestUser() {
        List<User> usersWithPhoneNumber = users.stream()
                .filter(u -> u.getPhoneNumber() != null)
                .collect(Collectors.toList());

        if (usersWithPhoneNumber.size() == 0) {
            return null;
        } else {
            User oldestUser = usersWithPhoneNumber.get(0);

            for (User user : usersWithPhoneNumber) {
                if (user.getBornDate().isBefore(oldestUser.getBornDate())) {
                    oldestUser = user;
                }
            }
            return oldestUser;
        }
    }
}
