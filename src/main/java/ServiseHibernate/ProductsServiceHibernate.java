package ServiseHibernate;

import EntityHibernate.ProductsHibernate;
import Util.HibernateSession;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;

import java.sql.SQLException;
import java.util.List;

public class ProductsServiceHibernate extends HibernateSession {
    Session session = null;

    public void add(ProductsHibernate product) throws SQLException {
        openTransaction();
        session = getSession();
        session.save(product);
        closeTransaction();
    }


    public void update(ProductsHibernate product) throws SQLException {
        openTransaction();
        session = getSession();
        session.update(product);
        closeTransaction();
    }


    public void remove(ProductsHibernate idProduct) throws SQLException {
        openTransaction();
        session = getSession();
        session.remove(idProduct);
        closeTransaction();
    }


    public List<ProductsHibernate> getAll() throws SQLException {
        openTransaction();
        session = getSession();

        String sql = "SELECT * FROM products";
        NativeQuery query = session.createNativeQuery(sql).addEntity(ProductsHibernate.class);
        List<ProductsHibernate> products = query.list();

        closeTransaction();
        return products;
    }


    public ProductsHibernate getId(int idProduct) throws SQLException {
        openTransaction();
        session = getSession();

        String sql = "SELECT * FROM products WHERE idProduct = ?";
        NativeQuery query = session.createNativeQuery(sql).addEntity(ProductsHibernate.class);
        query.setParameter(1, idProduct);

        ProductsHibernate products = (ProductsHibernate) query.getSingleResult();
        closeTransaction();

        return products;
    }
}
