package ServiseHibernate;

import EntityHibernate.OrdersHibernate;
import Util.HibernateSession;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;

import java.sql.SQLException;
import java.util.List;

public class OrdersServiceHibernate extends HibernateSession {
    Session session = null;

    public void add(OrdersHibernate order) throws SQLException {
        openTransaction();
        session = getSession();
        session.save(order);
        closeTransaction();
    }

    public void update(OrdersHibernate order) throws SQLException {
        openTransaction();
        session = getSession();
        session.update(order);
        closeTransaction();
    }

    public void remove(OrdersHibernate idOrder) throws SQLException {
        openTransaction();
        session = getSession();
        session.remove(idOrder);
        closeTransaction();
    }

    public List<OrdersHibernate> getAll() throws SQLException {
        openTransaction();
        session = getSession();

        String sql = "SELECT * FROM orders";
        NativeQuery query = session.createNativeQuery(sql).addEntity(OrdersHibernate.class);
        List<OrdersHibernate> orders = query.list();

        closeTransaction();
        return orders;
    }

    public OrdersHibernate getId(int idOrder) throws SQLException {
        openTransaction();
        session = getSession();

        String sql = "SELECT * FROM orders WHERE idOrder = ?";
        NativeQuery query = session.createNativeQuery(sql).addEntity(OrdersHibernate.class);
        query.setParameter(1, idOrder);

        OrdersHibernate order = (OrdersHibernate) query.getSingleResult();
        closeTransaction();

        return order;
    }
}
