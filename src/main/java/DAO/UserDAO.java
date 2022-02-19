package DAO;

import Entity.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDAO {
    void add(User user) throws SQLException;

    void update(User user) throws SQLException;

    void remove(int idUser) throws SQLException;

    List<User> getAll() throws SQLException;

    User getId(int idUser) throws SQLException;
}
