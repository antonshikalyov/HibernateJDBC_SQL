package DAO;

import Entity.Products;

import java.sql.SQLException;
import java.util.List;

public interface ProductsDAO {

    void add(Products product) throws SQLException;

    void update(Products product) throws SQLException;

    void remove(int idProduct) throws SQLException;

    List<Products> getAll() throws SQLException;

    Products getId(int idProduct) throws SQLException;
}
