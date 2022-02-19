package DAO;

import Entity.Seller;

import java.sql.SQLException;
import java.util.List;

public interface SellerDAO {
    void add(Seller seller) throws SQLException;

    void update(Seller seller) throws SQLException;

    void remove(int idSeller) throws SQLException;

    List<Seller> getAll() throws SQLException;

    Seller getId(int idSeller) throws SQLException;
}
