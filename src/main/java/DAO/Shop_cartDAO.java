package DAO;

import Entity.Shop_cart;

import java.sql.SQLException;
import java.util.List;

public interface Shop_cartDAO {
    void add(Shop_cart shop_cart) throws SQLException;

    void update(Shop_cart shop_cart) throws SQLException;

    void remove(int idUser) throws SQLException;

    List<Shop_cart> getAll() throws SQLException;

    Shop_cart getId(int idUser) throws SQLException;
}
