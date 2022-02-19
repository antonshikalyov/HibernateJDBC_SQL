package ServiseHibernate;

import EntityHibernate.UsersHibernate;
import Util.HibernateSession;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;

import java.sql.SQLException;
import java.util.List;

public class UserServiceHibernate extends HibernateSession {
    Session session = null;

    public void add(UsersHibernate user) throws SQLException {
        openTransaction();
        session = getSession();
        session.save(user);
        closeTransaction();
    }


    public void update(UsersHibernate user) throws SQLException {
        openTransaction();
        session = getSession();
        session.update(user);
        closeTransaction();
    }

    public void remove(UsersHibernate idUser) throws SQLException {
        openTransaction();
        session = getSession();
        session.remove(idUser);
        closeTransaction();
    }

    public List<UsersHibernate> getAll() throws SQLException {
        openTransaction();
        session = getSession();

        String sql = "SELECT * FROM user";
        NativeQuery query = session.createNativeQuery(sql).addEntity(UsersHibernate.class);
        List<UsersHibernate> users = query.list();

        closeTransaction();
        return users;
    }

    public UsersHibernate getId(int idUser) throws SQLException {
        openTransaction();
        session = getSession();

        String sql = "SELECT * FROM user WHERE idUser = ?";
        NativeQuery query = session.createNativeQuery(sql).addEntity(UsersHibernate.class);
        query.setParameter(1, idUser);

        UsersHibernate user = (UsersHibernate) query.getSingleResult();
        closeTransaction();

        return user;
    }
}
