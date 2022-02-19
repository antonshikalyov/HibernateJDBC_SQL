package EntityHibernate;

import javax.persistence.*;

@Entity
@Table(name = "orders")
public class OrdersHibernate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idOrder;

    @ManyToOne()
    @JoinColumn(name = "idUser")
    private UsersHibernate idUser;

    @ManyToOne()
    @JoinColumn(name = "idProduct")
    private ProductsHibernate idProduct;

    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    public UsersHibernate getIdUser() {
        return idUser;
    }

    public void setIdUser(UsersHibernate idUser) {
        this.idUser = idUser;
    }

    public ProductsHibernate getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(ProductsHibernate idProduct) {
        this.idProduct = idProduct;
    }

    @Override
    public String toString() {
        return "OrdersHibernate{" +
                "idOrder=" + idOrder +
                ", idUser=" + idUser +
                ", idProduct=" + idProduct +
                '}';
    }
}
