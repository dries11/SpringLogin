package ries.dan;

import org.junit.Before;
import org.junit.Test;
import ries.dan.Service.Auth.PasswordHash;
import static org.assertj.core.api.Assertions.*;

public class PasswordHashTest {

    PasswordHash passwordHash;

    @Before
    public void init(){
        passwordHash = new PasswordHash();
    }

    @Test
    public void testPasswordHashWorks(){
        String stringToHash = "test";
        String fakeSalt = "salt";

        String hashedPassword = passwordHash.hashPassword(fakeSalt, stringToHash);

        assertThat(hashedPassword).isNotEqualToIgnoringCase(fakeSalt+stringToHash);
        assertThat(hashedPassword).hasSize(64);
    }

}
