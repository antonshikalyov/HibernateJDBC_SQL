package Entity;

public class Shop_cart {
    private int idUser;
    private int idProduct;

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    @Override
    public String toString() {
        return "Shop_cart{" +
                "idUser=" + idUser +
                ", idProduct=" + idProduct +
                '}';
    }
}
