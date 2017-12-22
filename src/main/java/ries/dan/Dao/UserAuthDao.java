package ries.dan.Dao;

import ries.dan.Model.User.Auth.UserAuth;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface UserAuthDao extends CrudRepository<UserAuth, Integer>{

    @Query(value = "Select * from pick_up.user_auth where pick_up.user_auth.username= :username", nativeQuery = true)
    UserAuth getUserAuthByUsername(@Param("username") String username);

    Iterable<UserAuth> findAll();

}
