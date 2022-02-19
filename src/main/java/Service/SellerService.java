package Service;

import DAO.SellerDAO;
import Entity.Seller;
import Util.DBDriver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SellerService extends DBDriver implements SellerDAO {
    Connection connection = getConnection();

    @Override
    public void add(Seller seller) throws SQLException {
        PreparedStatement preparedStatement = null;
        String sql = "INSERT INTO SELLER (name, surname) VALUES (?,?)";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, seller.getName());
            preparedStatement.setString(2, seller.getSurname());

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
    public void update(Seller seller) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "UPDATE SELLER SET name = ?, surname = ? WHERE idSeller = ?";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, seller.getName());
            preparedStatement.setString(2, seller.getSurname());
            preparedStatement.setInt(3, seller.getIdSeller());

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
    public void remove(int idSeller) throws SQLException {
        PreparedStatement preparedStatement = null;
        String sql = "DELETE FROM SELLER WHERE idSeller=?";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, idSeller);

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
    public List<Seller> getAll() throws SQLException {
        List<Seller> sellerList = new ArrayList<>();
        String sql = "SELECT * FROM SELLER";

        Statement statement = null;

        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Seller seller = new Seller();

                seller.setIdSeller(resultSet.getInt("idSeller"));
                seller.setName(resultSet.getString("name"));
                seller.setSurname(resultSet.getString("surname"));

                sellerList.add(seller);
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
        return sellerList;
    }

    @Override
    public Seller getId(int idSeller) throws SQLException {
        PreparedStatement preparedStatement = null;
        String sql = "SELECT * FROM SELLER WHERE idSeller = ?";

        Seller seller = new Seller();
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, idSeller);

            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();

            seller.setIdSeller(resultSet.getInt("idSeller"));
            seller.setName(resultSet.getString("name"));
            seller.setSurname(resultSet.getString("surname"));

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
        return seller;
    }
}