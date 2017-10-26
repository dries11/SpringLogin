package ries.dan.Model.User.Auth;

import javax.persistence.*;

@Entity(name = "user_auth")
public class UserAuth {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column
    private String hashedPassword;

    @Column
    private String generatedSalt;

    @Column
    private Boolean isActive;

    public UserAuth(){
        this.isActive = true;
    }

    public UserAuth(Integer id, String username, String hashedPassword, String generatedSalt, Boolean isActive){
        this.id = id;
        this.username = username;
        this.hashedPassword = hashedPassword;
        this.generatedSalt = generatedSalt;
        this.isActive = isActive;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getHashedPassword() {
        return hashedPassword;
    }

    public void setHashedPassword(String hashedPassword) {
        this.hashedPassword = hashedPassword;
    }

    public String getGeneratedSalt() {
        return generatedSalt;
    }

    public void setGeneratedSalt(String generatedSalt) {
        this.generatedSalt = generatedSalt;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }
}
