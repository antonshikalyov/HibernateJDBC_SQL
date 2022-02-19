package EntityHibernate;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "seller")
public class SellerHibernate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idSeller;
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;

    @OneToMany(mappedBy = "idSeller", fetch = FetchType.LAZY)
    private Set<ProductsHibernate> products;

    public int getIdSeller() {
        return idSeller;
    }

    public void setIdSeller(int idSeller) {
        this.idSeller = idSeller;
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

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Set<ProductsHibernate> getProducts() {
        return products;
    }

    public void setProducts(Set<ProductsHibernate> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "SellerHibernate{" +
                "idSeller=" + idSeller +
                ", name='" + name + '\'' +
                ", surname='" + surname + '}';
    }
}
