package ries.dan;

import ries.dan.Dao.UserAuthDao;
import ries.dan.Model.User.Auth.UserAuth;
import ries.dan.Model.User.Auth.UserAuthFactory;
import ries.dan.Service.Auth.PasswordHash;
import ries.dan.Service.Auth.UserAuthServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.*;

@RunWith(MockitoJUnitRunner.class)
public class UserAuthServiceTest {

    @Mock
    UserAuthDao userAuthDao;

    @Mock
    UserAuthFactory userAuthFactory;

    @Mock
    PasswordHash passwordHash;

    @InjectMocks
    UserAuthServiceImpl userAuthService;

    UserAuth userAuth;

    @Before
    public void init(){
        userAuth = new UserAuth(1,"test", "1234", "test", true);
    }

    @Test
    public void createNewUserShouldReturnIntegerId(){
        when(userAuthFactory.createNewUser("test", "test")).thenReturn(userAuth);
        when(userAuthDao.save(any(UserAuth.class))).thenReturn(userAuth);

        Integer idReturned = userAuthService.createNewUser("test", "test");

        assertThat(idReturned).isEqualTo(userAuth.getId());


    }

    @Test
    public void loginUserShouldReturnUserId(){
        when(userAuthDao.getUserAuthByUsername(anyString())).thenReturn(userAuth);
        when(passwordHash.hashPassword(anyString(), anyString())).thenReturn("1234");

        Integer idReturned = userAuthService.loginUser("test", "testPass");

        assertThat(idReturned).isEqualTo(userAuth.getId());
    }

}
