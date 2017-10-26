package ries.dan.Dao;

import ries.dan.Model.User.User;
import org.springframework.data.repository.CrudRepository;

public interface UserDao extends CrudRepository<User, Integer>{
}
