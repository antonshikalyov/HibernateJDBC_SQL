package ServiseHibernate;

import EntityHibernate.UsersHibernate;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.jupiter.api.*;

import java.sql.SQLException;
import java.util.ArrayList;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UserServiceHibernateTest {

    UserServiceHibernate userServiceHibernate = new UserServiceHibernate();
    UsersHibernate usersHibernate = new UsersHibernate();

    @BeforeClass
    public static void globalSetUp() {
        System.out.println("Загрузка теста...");
        System.out.println("...");

    }


     public UsersHibernate currentValue() throws SQLException {
        ArrayList<UsersHibernate> users = (ArrayList<UsersHibernate>) userServiceHibernate.getAll();
        return users.get(users.size() - 1);
    }

    @Order(1)
    @Test
    void add() throws SQLException {
        String name = "TestUser";
        String surname = "TestUser";
        usersHibernate.setName(name);
        usersHibernate.setSurname(surname);
        userServiceHibernate.add(usersHibernate);
        Assertions.assertEquals(name, currentValue().getName());
        Assertions.assertEquals(surname, currentValue().getSurname());
    }

    @Order(2)
    @Test
    void update() throws SQLException {
        UsersHibernate id = userServiceHibernate.getId(currentValue().getIdUser());
        int idOfUser = id.getIdUser();
        String name = "TestUser1";
        String surname = "TestUser1";
        usersHibernate.setIdUser(idOfUser);
        usersHibernate.setName(name);
        usersHibernate.setSurname(surname);
        userServiceHibernate.update(usersHibernate);

        UsersHibernate updateValue = userServiceHibernate.getId(idOfUser);
        Assertions.assertEquals(name, updateValue.getName());
        Assertions.assertEquals(surname, updateValue.getSurname());
    }


    @Test
    void remove() throws SQLException {
        UsersHibernate user = userServiceHibernate.getId(currentValue().getIdUser());
        userServiceHibernate.remove(user);
    }

    @Order(3)
    @Test
    void getAll() throws SQLException {
        ArrayList<UsersHibernate> users = (ArrayList<UsersHibernate>) userServiceHibernate.getAll();
        Assertions.assertFalse(users.isEmpty());
    }

    @Order(4)
    @Test
    void getId() throws SQLException {
        int id = currentValue().getIdUser();
        UsersHibernate idOfUser = userServiceHibernate.getId(id);
        Assertions.assertNotNull(idOfUser);
    }

    @AfterClass
    public static void ExitTest() {
        System.out.println("Тест завершен");
    }
}