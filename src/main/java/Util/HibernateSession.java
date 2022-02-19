package Util;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class HibernateSession {
    private Session session;
    private Transaction transaction;

    public Session getSession() {
        return session;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public Session openSession() {
        return JavaHibernate.getSessionFactory().openSession();
    }

    public Session openTransaction(){
        session = openSession();
        transaction = session.beginTransaction();
        return session;
    }

    public void closeSession() {
        session.close();
    }

    public void closeTransaction(){
        transaction.commit();
        closeSession();
    }
}
