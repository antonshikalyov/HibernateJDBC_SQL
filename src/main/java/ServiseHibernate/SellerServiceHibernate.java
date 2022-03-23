package ServiseHibernate;

import EntityHibernate.SellerHibernate;
import Util.HibernateSession;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;

import java.sql.SQLException;
import java.util.List;

public class SellerServiceHibernate extends HibernateSession {
    Session session = null;

    public void add(SellerHibernate seller) throws SQLException {
        openTransaction();
        session = getSession();
        session.save(seller);
        closeTransaction();
    }

    public void update(SellerHibernate seller) throws SQLException {
        openTransaction();
        session = getSession();
        session.update(seller);
        closeTransaction();
    }

    public void remove(SellerHibernate idSeller) throws SQLException {
        openTransaction();
        session = getSession();
        session.remove(idSeller);
        closeTransaction();
    }

    public List<SellerHibernate> getAll() throws SQLException {
        openTransaction();
        session = getSession();

        String sql = "SELECT * FROM seller";
        NativeQuery query = session.createNativeQuery(sql).addEntity(SellerHibernate.class);
        List<SellerHibernate> sellers = query.list();

        closeTransaction();
        return sellers;
    }

    public SellerHibernate getId(int idSeller) throws SQLException {
        openTransaction();
        session = getSession();

        String sql = "SELECT * FROM seller WHERE idSeller = ?";
        NativeQuery query = session.createNativeQuery(sql).addEntity(SellerHibernate.class);
        query.setParameter(1, idSeller);

        SellerHibernate seller = (SellerHibernate) query.getSingleResult();
        closeTransaction();

        return seller;
    }
}
