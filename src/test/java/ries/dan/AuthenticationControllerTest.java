package ries.dan;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Disabled;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import ries.dan.Controller.AuthenticationController;
import ries.dan.Model.User.Auth.UserAuth;
import ries.dan.Model.User.User;
import ries.dan.Model.User.UserDTO;
import ries.dan.Service.Auth.UserAuthServiceImpl;
import ries.dan.Service.User.UserServiceImpl;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@WebMvcTest(value = AuthenticationController.class, secure = false)
public class AuthenticationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private UserAuthServiceImpl userAuthService;

    @Mock
    private UserServiceImpl userService;

    @InjectMocks
    private AuthenticationController authenticationController;

    UserAuth mockUserAuth;
    User mockUser;

    @Before
    public void init(){
        mockUserAuth = new UserAuth(1, "test", "test", "test", true);
        mockUser = new User("testee","tester","tdd","tdd@test.com");
        mockUser.setId(1);
    }

    @Test
    @Disabled("not working yet")
    public void createUserTest() throws Exception {
        when(userAuthService.createNewUser(anyString(), anyString())).thenReturn(1);
        when(userService.createNewUser(1, any(UserDTO.class))).thenReturn(mockUser);

        String mockUserDTOJSON = "{\"username\" : \"test\", \"password\" : \"test\", \"firstName\" : \"test\", \"lastName\" : \"test\", \"email\" : \"test@test.com\"}";

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/auth/createUser")
                .accept(MediaType.APPLICATION_JSON)
                .content(mockUserDTOJSON)
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        MockHttpServletResponse response = result.getResponse();

        System.out.println(response.getContentAsString());

        assertEquals(HttpStatus.OK.value(), response.getStatus());
        assertEquals("http://localhost/auth/createUser", response.getHeader(HttpHeaders.LOCATION));
    }

    @Test
    @Disabled("not working yet")
    public void loginUserTest() throws Exception {}

}
