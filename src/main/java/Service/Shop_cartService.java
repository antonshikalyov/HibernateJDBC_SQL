package Service;

import DAO.Shop_cartDAO;
import Entity.Shop_cart;
import Util.DBDriver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Shop_cartService extends DBDriver implements Shop_cartDAO {
    Connection connection = getConnection();

    @Override
    public void add(Shop_cart shop_cart) throws SQLException {
        PreparedStatement preparedStatement = null;
        String sql = "INSERT INTO SHOP_CART (idUser, idProduct) VALUES (?,?)";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, shop_cart.getIdUser());
            preparedStatement.setInt(2, shop_cart.getIdProduct());

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
    public void update(Shop_cart shop_cart) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "UPDATE SHOP_CART SET idProduct=? WHERE idUser = ?";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, shop_cart.getIdProduct());
            preparedStatement.setInt(2, shop_cart.getIdUser());

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
        String sql = "DELETE FROM SHOP_CART WHERE idUser=?";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, idUser);

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
    public List<Shop_cart> getAll() throws SQLException {
        List<Shop_cart> shopingcartList = new ArrayList<>();
        String sql = "SELECT * FROM SHOP_CART";

        Statement statement = null;

        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                Shop_cart shopingcart = new Shop_cart();
                shopingcart.setIdUser(resultSet.getInt("idUser"));
                shopingcart.setIdProduct(resultSet.getInt("idProduct"));

                shopingcartList.add(shopingcart);
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
        return shopingcartList;
    }

    @Override
    public Shop_cart getId(int idUser) throws SQLException {
        PreparedStatement preparedStatement = null;
        String sql = "SELECT * FROM SHOP_CART WHERE idUser=?";

        Shop_cart shopingcart = new Shop_cart();
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, idUser);

            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            shopingcart.setIdUser(resultSet.getInt("idUser"));
            shopingcart.setIdProduct(resultSet.getInt("idProduct"));

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
        return shopingcart;
    }
}
