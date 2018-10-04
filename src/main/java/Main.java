public class Main {
    public static void main(String[] args) {
        System.out.println("Program napisany na potrzeby rekturacji\n\t\t\tPaweł Stopa\n");
        UserRepository userRepo = UserRepository.getInstance();
        FileFounder fileFounder = new FileFounder(userRepo);

        boolean fileIsOpen = false;
        while (!fileIsOpen) {
            String path = fileFounder.getAbsolutPath();
            fileIsOpen = fileFounder.openFile(path);
        }
        fileFounder.readFile();

        System.out.println("Users in file: " + userRepo.getUsers().size());
        User oldestUser = userRepo.findOldestUser();
        if (oldestUser != null) {
            System.out.println("The oldest user with phone number: " + oldestUser);
        } else {
            System.out.println("There`s no user with phone number");
        }
    }
}
