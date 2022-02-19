package Entity;

public class Products {
    private int idProduct;
    private String nameOfProduct;
    private int idSeller;
    private int cost;
    private String discription;

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

    public int getIdSeller() {
        return idSeller;
    }

    public void setIdSeller(int idSeller) {
        this.idSeller = idSeller;
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

    @Override
    public String toString() {
        return "Products{" +
                "idProduct=" + idProduct +
                ", nameOfProduct='" + nameOfProduct + '\'' +
                ", idSeller=" + idSeller +
                ", cost=" + cost +
                ", discription='" + discription + '\'' +
                '}';
    }
}
