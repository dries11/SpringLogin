package ries.dan;

import ries.dan.Model.User.Auth.UserAuth;
import ries.dan.Model.User.Auth.UserAuthFactory;
import ries.dan.Service.Auth.PasswordHash;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class UserAuthFactoryTest {

    @Mock
    private PasswordHash passwordHash;

    @InjectMocks
    UserAuthFactory userAuthFactory;

    UserAuth userAuth;

    @Before
    public void init(){
        when(passwordHash.hashPassword("testSalt", "testHash")).thenReturn("test1234test1234");
        userAuthFactory = new UserAuthFactory();
        userAuth = new UserAuth(1,"test","test1234test1234","",true);
    }

    @Test
    public void testUserAuthCreation(){
        PasswordHash passwordHash = new PasswordHash();

        String password = "testHash", username = "test";

        UserAuth userAuthFactoryNewUser = userAuthFactory.createNewUser(username, password);

        assertThat(userAuthFactoryNewUser).isEqualToComparingOnlyGivenFields(userAuth, "username", "isActive");

    }

}
