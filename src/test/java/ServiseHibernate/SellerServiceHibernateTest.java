package ServiseHibernate;

import EntityHibernate.SellerHibernate;
import org.junit.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;

import java.sql.SQLException;
import java.util.ArrayList;

import static org.junit.Assert.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SellerServiceHibernateTest {

    SellerHibernate sellerHibernate = new SellerHibernate();
    SellerServiceHibernate sellerServiceHibernate = new SellerServiceHibernate();

    @BeforeClass
    public static void globalSetUp() {
        System.out.println("Загрузка теста...");
        System.out.println("...");

    }

    @BeforeEach
    public SellerHibernate currentValue() throws SQLException {
        ArrayList<SellerHibernate> sellers = (ArrayList<SellerHibernate>) sellerServiceHibernate.getAll();
        return sellers.get(sellers.size() - 1);
    }

    @Order(1)
    @Test()
    public void add() throws SQLException {
        String name = "Test";
        String surname = "Test";
        sellerHibernate.setName(name);
        sellerHibernate.setSurname(surname);
        sellerServiceHibernate.add(sellerHibernate);
        assertEquals(name, currentValue().getName());
        assertEquals(surname, currentValue().getSurname());
    }

    @Order(4)
    @Test
    public void getAll() throws SQLException {
        ArrayList<SellerHibernate> sellers = (ArrayList<SellerHibernate>) sellerServiceHibernate.getAll();
        assertFalse(sellers.isEmpty());
    }

    @Order(3)
    @Test
    public void getId() throws SQLException {
        int id = currentValue().getIdSeller();
        SellerHibernate idOfSeller = sellerServiceHibernate.getId(id);
        assertNotNull(idOfSeller);}

    @Order(2)
    @Test
    public void update() throws SQLException {
        SellerHibernate id = sellerServiceHibernate.getId(currentValue().getIdSeller());
        int idOfSeller = id.getIdSeller();
        String name = "Test1";
        String surname = "Test1";
        sellerHibernate.setIdSeller(idOfSeller);
        sellerHibernate.setName(name);
        sellerHibernate.setSurname(surname);
        sellerServiceHibernate.update(sellerHibernate);

        SellerHibernate updateValue = sellerServiceHibernate.getId(idOfSeller);
        assertEquals(name, updateValue.getName());
        assertEquals(surname, updateValue.getSurname());
    }

    @Order(5)
    @Test
    public void remove() throws SQLException {
        SellerHibernate seller = sellerServiceHibernate.getId(currentValue().getIdSeller());
        sellerServiceHibernate.remove(seller);
    }

    @AfterClass
    public static void ExitTest() {
        System.out.println("Тест завершен");
    }

}