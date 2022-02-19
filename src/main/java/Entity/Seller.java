package Entity;

public class Seller {
    private int idSeller;
    private String name;
    private String surname;

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

    @Override
    public String toString() {
        return "Seller{" +
                "idSeller=" + idSeller +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}
