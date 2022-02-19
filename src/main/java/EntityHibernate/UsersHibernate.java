package EntityHibernate;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "user")
public class UsersHibernate {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int idUser;
        @Column(name = "name")
        private String name;
        @Column(name = "surname")
        private String surname;

    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST,
            CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinTable(name = "shop_cart",
            joinColumns = { @JoinColumn(name = "idUser") },
            inverseJoinColumns = { @JoinColumn(name = "idProduct") })

    private List<ProductsHibernate> products;

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surnamename) {
        this.surname = surnamename;
    }

    public List<ProductsHibernate> getProducts() {
        return products;
    }

    public void setProducts(List<ProductsHibernate> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "UsersHibernate{" +
                "idUser=" + idUser +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}
