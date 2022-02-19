package Service;

import DAO.UserDAO;
import Entity.User;
import Util.DBDriver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserService extends DBDriver implements UserDAO {
    Connection connection = getConnection();

    @Override
    public void add(User user) throws SQLException {
        PreparedStatement preparedStatement = null;
        String sql = "INSERT INTO USER (name, surname) VALUES (?,?)";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getSurname());

            preparedStatement.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (preparedStatement == null){
                preparedStatement.close();
            }
            if (connection == null){
                connection.close();
            }
        }
    }

    @Override
    public void update(User user) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "UPDATE USER SET name=?, surname=? WHERE idUser = ?";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getSurname());
            preparedStatement.setInt(3, user.getIdUser());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (preparedStatement == null){
                preparedStatement.close();
            }
            if (connection == null){
                connection.close();
            }
        }
    }

    @Override
    public void remove(int idUser) throws SQLException {
        PreparedStatement preparedStatement = null;
        String sql = "DELETE FROM USER WHERE idUser=?";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, idUser);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement == null) {
                preparedStatement.close();
            }
            if (connection == null) {
                connection.close();
            }
        }
    }

    @Override
    public List<User> getAll() throws SQLException {
        List<User> userList = new ArrayList<>();
        String sql = "SELECT * FROM USER";

        Statement statement = null;

        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()){
                User user = new User();
                user.setIdUser(resultSet.getInt("idUser"));
                user.setName(resultSet.getString("name"));
                user.setSurname(resultSet.getString("surname"));

                userList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (statement == null){
                statement.close();
            }
            if (connection == null){
                connection.close();
            }
        }
        return userList;
    }

    @Override
    public User getId(int idUser) throws SQLException {
        PreparedStatement preparedStatement = null;
        String sql = "SELECT * FROM USER WHERE idUser=?";
        User user = new User();

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,idUser);

            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();

            user.setIdUser(resultSet.getInt(1));
            user.setName(resultSet.getString("name"));
            user.setSurname(resultSet.getString("surname"));

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (preparedStatement == null){
                preparedStatement.close();
            }
            if (connection == null){
                connection.close();
            }
        }
        return user;
    }
}
