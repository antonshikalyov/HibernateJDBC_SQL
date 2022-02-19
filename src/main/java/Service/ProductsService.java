package Service;

import DAO.ProductsDAO;
import Entity.Products;
import Util.DBDriver;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class ProductsService extends DBDriver implements ProductsDAO {
    Connection connection = getConnection();

    @Override
    public void add(Products products) throws SQLException {
        PreparedStatement preparedStatement = null;
        String sql = "INSERT INTO PRODUCTS (nameOfProduct, idSeller, cost, discription) VALUES (?,?,?,?)";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, products.getNameOfProduct());
            preparedStatement.setInt(2, products.getIdSeller());
            preparedStatement.setInt(3, products.getCost());
            preparedStatement.setString(4, products.getDiscription());

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
    public void update(Products products) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "UPDATE PRODUCTS SET nameOfProduct=?, idSeller = ?, cost=?, discription=? WHERE idProduct = ?";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, products.getNameOfProduct());
            preparedStatement.setInt(2, products.getIdSeller());
            preparedStatement.setInt(3,products.getCost());
            preparedStatement.setString(4, products.getDiscription());
            preparedStatement.setInt(5, products.getIdProduct());

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
    public void remove(int idProduct) throws SQLException {

    }

    @Override
    public List<Products> getAll() throws SQLException {
        return null;
    }

    @Override
    public Products getId(int idProduct) throws SQLException {
        return null;
    }
}
