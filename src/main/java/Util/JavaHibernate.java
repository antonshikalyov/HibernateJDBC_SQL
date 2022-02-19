package Util;

import EntityHibernate.OrdersHibernate;
import EntityHibernate.ProductsHibernate;
import EntityHibernate.SellerHibernate;
import EntityHibernate.UsersHibernate;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class JavaHibernate {
    private static final SessionFactory sessionFactory;
    static {

        sessionFactory = new Configuration().configure("Hibernate.cfg.xml")
                .addAnnotatedClass(UsersHibernate.class)
                .addAnnotatedClass(ProductsHibernate.class)
                .addAnnotatedClass(SellerHibernate.class)
                .addAnnotatedClass(OrdersHibernate.class)
                .buildSessionFactory();
    }

    public static SessionFactory getSessionFactory(){
        return sessionFactory;
    }
    public static void SessionClose(){
        getSessionFactory().close();
    }

}
