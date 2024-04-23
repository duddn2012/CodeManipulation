package dicontainer;

import static org.junit.Assert.*;

import org.junit.jupiter.api.Test;

public class ContainerServiceTest {

    @Test
    public void getObject_UserRepository() {
        UserRepository userRepository = ContainerService.getObject(UserRepository.class);
        assertNotNull(userRepository);
    }

    @Test
    public void getObject_BookService() {
        UserService userService = ContainerService.getObject(UserService.class);
        assertNotNull(userService);
        assertNotNull(userService.userRepository);
    }
}