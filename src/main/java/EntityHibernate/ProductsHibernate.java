package EntityHibernate;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "products")
public class ProductsHibernate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idProduct;
    @Column(name = "nameOfProduct")
    private String nameOfProduct;
    @Column(name = "cost")
    private int cost;
    @Column(name = "discription")
    private String discription;

    @ManyToOne()
    @JoinColumn(name = "idSeller")
    private SellerHibernate idSeller;

    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST,
            CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinTable(name = "shop_cart",
            joinColumns = { @JoinColumn(name = "idProduct") },
            inverseJoinColumns = { @JoinColumn(name = "idUser") })

    private List<UsersHibernate> users;

    @OneToMany(mappedBy = "idOrder", fetch = FetchType.LAZY)  //  добавлено недавно
    private List<OrdersHibernate> orders;


    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public String getNameOfProduct() {
        return nameOfProduct;
    }

    public void setNameOfProduct(String nameOfProduct) {
        this.nameOfProduct = nameOfProduct;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public SellerHibernate getIdSeller() {
        return idSeller;
    }

    public void setIdSeller(SellerHibernate idSeller) {
        this.idSeller = idSeller;
    }

    public List<UsersHibernate> getUsers() {
        return users;
    }

    public void setUsers(List<UsersHibernate> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "ProductsHibernate{" +
                "idProduct=" + idProduct +
                ", nameOfProduct='" + nameOfProduct + '\'' +
                ", cost=" + cost +
                ", discription='" + discription + '\'' +
                ", idSeller=" + idSeller +
                '}';
    }
}
