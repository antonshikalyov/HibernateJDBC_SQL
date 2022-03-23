package ServiseHibernate;

import EntityHibernate.SellerHibernate;
import org.junit.*;

import java.sql.SQLException;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class SellerServiceHibernateTest implements CurrentValue{

    SellerHibernate sellerHibernate = new SellerHibernate();
    SellerServiceHibernate sellerServiceHibernate = new SellerServiceHibernate();

    @BeforeClass
    public static void globalSetUp() {
        System.out.println("Загрузка теста...");
        System.out.println("...");
    }

    @Test
    public void add() throws SQLException {
        String name = "Test";
        String surname = "Test";
        sellerHibernate.setName(name);
        sellerHibernate.setSurname(surname);
        sellerServiceHibernate.add(sellerHibernate);

        assertEquals(name, currentValue().getName());
        assertEquals(surname, currentValue().getSurname());
    }

    @Test
    public void getAll() throws SQLException {
        SellerServiceHibernate sellerServiceHimernate = new SellerServiceHibernate();
        ArrayList<SellerHibernate> sellers = (ArrayList<SellerHibernate>) sellerServiceHimernate.getAll();
        assertFalse(sellers.isEmpty());
    }

    @Test
    public void getId() throws SQLException {
        int id = currentValue().getIdSeller();
        SellerHibernate idOfSeller = sellerServiceHibernate.getId(id);
        assertNotNull(idOfSeller);
        System.out.println(idOfSeller);
    }

    @Test
    public void update() throws SQLException {
        ArrayList<SellerHibernate> sellers = (ArrayList<SellerHibernate>) sellerServiceHibernate.getAll();
        SellerHibernate thisId = sellers.get(sellers.size() - 1);
        int idOfSeller = thisId.getIdSeller();
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

    @Test
    public void remove() throws SQLException {
        SellerHibernate idOfSeller = sellerServiceHibernate.getId(currentValue().getIdSeller());
        sellerServiceHibernate.remove(idOfSeller);
    }

    @AfterClass
    public static void ExitTest() {
        System.out.println("Тест завершен");

    }

    @Override
    public SellerHibernate currentValue() throws SQLException {
        ArrayList<SellerHibernate> sellers = (ArrayList<SellerHibernate>) sellerServiceHibernate.getAll();
        SellerHibernate thisId = sellers.get(sellers.size() - 1);
        return thisId;
    }
}