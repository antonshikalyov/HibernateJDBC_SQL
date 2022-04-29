package EntityHibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "orders")
public class OrdersHibernate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idOrder;

    @ManyToOne(cascade = {})
    @JoinColumn(name = "idUser")
    private UsersHibernate idUser;

    @ManyToOne(cascade = {})
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrdersHibernate that = (OrdersHibernate) o;
        return idOrder == that.idOrder && Objects.equals(idUser, that.idUser) && Objects.equals(idProduct, that.idProduct);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idOrder, idUser, idProduct);
    }
}
