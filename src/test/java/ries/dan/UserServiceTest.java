package ries.dan;

import ries.dan.Dao.UserDao;
import ries.dan.Model.User.User;
import static org.assertj.core.api.Assertions.*;

import ries.dan.Model.User.UserDTO;
import ries.dan.Service.User.UserServiceImpl;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

    User user;

    UserDTO userDTO;

    @Mock
    private UserDao userDao;

    @InjectMocks
    private UserServiceImpl userService;

    @Before
    public void setup(){
        user = new User("Admin", "Test", "admin", "admin@admin.com");
        userDTO = new UserDTO("admin","39248703jfkds90f9dusf","Admin","Test","admin@admin.com");
    }

    @Test
    public void testMockCreation(){
        assertNotNull(userDao);
    }

    @Test
    public void whenFindByIdReturnUser() {
        //Given
        when(userDao.findOne(1)).thenReturn(user);

        //When
        User returned = userService.getUserById(1);

        //Then
        assertThat(returned).isEqualToComparingFieldByField(user);

    }

    @Test
    public void createNewUserTest(){
        //Given
        when(userDao.save(any(User.class))).thenReturn(user);

        //When
        User savedUser = userService.createNewUser(1, userDTO);

        //Then
        assertThat(savedUser).isEqualToComparingFieldByField(user);
    }

}
