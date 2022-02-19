package Service;

import DAO.OrdersDAO;
import Entity.Orders;
import Util.DBDriver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrdersService extends DBDriver implements OrdersDAO {
    Connection connection = getConnection();

    @Override
    public void add(Orders orders) throws SQLException {
        PreparedStatement preparedStatement = null;
        String sql = "INSERT INTO orders (idUser, idProduct) VALUES (?,?)";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, orders.getIdUser());
            preparedStatement.setInt(2, orders.getIdProductOrder());

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
    public void update(Orders orders) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "UPDATE ORDERS SET idUser=?, idProduct=? WHERE idOrder = ?";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, orders.getIdUser());
            preparedStatement.setInt(2, orders.getIdProductOrder());
            preparedStatement.setInt(3, orders.getIdOrder());

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
    public void remove(int idOrder) throws SQLException {
        PreparedStatement preparedStatement = null;
        String sql = "DELETE FROM ORDERS WHERE idOrder=?";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, idOrder);

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
    public List<Orders> getAll() throws SQLException {
        List<Orders> orderList = new ArrayList<>();
        String sql = "SELECT * FROM ORDERS";

        Statement statement = null;

        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Orders order = new Orders();

                order.setIdOrder(resultSet.getInt("idOrder"));
                order.setIdProductOrder(resultSet.getInt("idUser"));
                order.setIdUser(resultSet.getInt("idProduct"));

                orderList.add(order);
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
        return orderList;
    }

    @Override
    public Orders getId(int idOrder) throws SQLException {
        PreparedStatement preparedStatement = null;
        String sql = "SELECT idOrder, idUser FROM ORDERS WHERE idOrder=?";
        Orders order = new Orders();

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, idOrder);

            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();

            order.setIdOrder(resultSet.getInt(1));
            order.setIdUser(resultSet.getInt(2));

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
        return order;
    }
}
