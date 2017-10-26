package ries.dan.Model.User;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {

    @Id
    private Integer id;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private String username;

    @Column
    private String email;

    @Column
    private Integer gamesPlayed;

    @Column
    private Integer gameOneId;

    @Column
    private Integer gameTwoId;

    @Column
    private Integer gameThreeId;

    @Column
    private Integer gameFourId;

    @Column
    private Integer gameFiveId;

    public User(){}

    public User(String firstName, String lastName, String username, String email){
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getGamesPlayed() {
        return gamesPlayed;
    }

    public void setGamesPlayed(Integer gamesPlayed) {
        this.gamesPlayed = gamesPlayed;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGameOneId() {
        return gameOneId;
    }

    public void setGameOneId(Integer gameOneId) {
        this.gameOneId = gameOneId;
    }

    public Integer getGameTwoId() {
        return gameTwoId;
    }

    public void setGameTwoId(Integer gameTwoId) {
        this.gameTwoId = gameTwoId;
    }

    public Integer getGameThreeId() {
        return gameThreeId;
    }

    public void setGameThreeId(Integer gameThreeId) {
        this.gameThreeId = gameThreeId;
    }

    public Integer getGameFourId() {
        return gameFourId;
    }

    public void setGameFourId(Integer gameFourId) {
        this.gameFourId = gameFourId;
    }

    public Integer getGameFiveId() {
        return gameFiveId;
    }

    public void setGameFiveId(Integer gameFiveId) {
        this.gameFiveId = gameFiveId;
    }
}
