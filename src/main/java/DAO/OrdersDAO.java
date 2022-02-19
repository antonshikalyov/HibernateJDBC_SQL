package DAO;

import Entity.Orders;

import java.sql.SQLException;
import java.util.List;

public interface OrdersDAO {
    void add(Orders order) throws SQLException;

    void update(Orders order) throws SQLException;

    void remove(int idOrder) throws SQLException;

    List<Orders> getAll() throws SQLException;

    Orders getId(int idOrder) throws SQLException;
}
