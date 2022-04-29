package Service;

import DAO.ProductsDAO;
import Entity.Products;
import Entity.Seller;
import Entity.User;
import Util.DBDriver;

import java.sql.*;
import java.util.ArrayList;
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
        List<Products> productList = new ArrayList<>();
        String sql = "SELECT * FROM products";

        Statement statement = null;

        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()){
                Products product = new Products();
                product.setIdProduct(resultSet.getInt("idProduct"));
                product.setNameOfProduct(resultSet.getString("nameOfProduct"));
                product.setIdSeller(resultSet.getInt("idSeller"));
                product.setCost(resultSet.getInt("cost"));
                product.setDiscription(resultSet.getString("discription"));

                productList.add(product);
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
        return productList;
    }


    @Override
    public Products getId(int idProduct) throws SQLException {
        PreparedStatement preparedStatement = null;
        String sql = "SELECT * FROM products WHERE idProduct = ?";

        Products product = new Products();
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, idProduct);

            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();

            product.setIdProduct(resultSet.getInt("idProduct"));
            product.setNameOfProduct(resultSet.getString("nameOfProduct"));
            product.setIdSeller(resultSet.getInt("idSeller"));
            product.setCost(resultSet.getInt("cost"));
            product.setDiscription(resultSet.getString("discription"));


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
        return product;
    }
}
