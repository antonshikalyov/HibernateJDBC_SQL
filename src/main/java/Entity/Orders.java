package Entity;

public class Orders {
    private int idOrder;
    private int idUser;
    private int idProductOrder;

    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdProductOrder() {
        return idProductOrder;
    }

    public void setIdProductOrder(int idProductOrder) {
        this.idProductOrder = idProductOrder;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "idOrder=" + idOrder +
                ", idUser=" + idUser +
                ", idProductOrder=" + idProductOrder +
                '}';
    }
}
