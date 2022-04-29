package ServiseHibernate;

import EntityHibernate.OrdersHibernate;
import EntityHibernate.ProductsHibernate;
import EntityHibernate.UsersHibernate;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.jupiter.api.*;

import java.sql.SQLException;
import java.util.ArrayList;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class OrdersServiceHibernateTest {

    OrdersServiceHibernate ordersServiceHibernate = new OrdersServiceHibernate();
    UserServiceHibernate userServiceHibernate = new UserServiceHibernate();
    ProductsServiceHibernate productsServiceHibernate = new ProductsServiceHibernate();

    OrdersHibernate ordersHibernate = new OrdersHibernate();


    @BeforeClass
    public static void globalSetUp() {
        System.out.println("Загрузка теста...");
        System.out.println("...");
    }

    public OrdersHibernate currentValue() throws SQLException {
        ArrayList<OrdersHibernate> orders = (ArrayList<OrdersHibernate>) ordersServiceHibernate.getAll();
        return orders.get(orders.size() - 1);
    }

    @Order(1)
    @Test
    void add() throws SQLException {
        ArrayList<UsersHibernate> users = (ArrayList<UsersHibernate>) userServiceHibernate.getAll();
        ArrayList<ProductsHibernate> products = (ArrayList<ProductsHibernate>) productsServiceHibernate.getAll();

        UsersHibernate user = users.get(users.size() -1);
        ProductsHibernate product = products.get(products.size() -1);

        ordersHibernate.setIdUser(user);
        ordersHibernate.setIdProduct(product);
        ordersServiceHibernate.add(ordersHibernate);
        Assertions.assertEquals(user.getIdUser(), currentValue().getIdUser().getIdUser());
        Assertions.assertEquals(product.getIdProduct(), currentValue().getIdProduct().getIdProduct());
    }

    @Order(2)
    @Test
    void update() throws SQLException {
        ArrayList<UsersHibernate> users = (ArrayList<UsersHibernate>) userServiceHibernate.getAll();
        ArrayList<ProductsHibernate> products = (ArrayList<ProductsHibernate>) productsServiceHibernate.getAll();

        OrdersHibernate order = ordersServiceHibernate.getId(currentValue().getIdOrder());

        int idOrder = order.getIdOrder();
        UsersHibernate user = users.get(users.size() - 1);
        ProductsHibernate product = products.get(products.size() -1);

        ordersHibernate.setIdOrder(idOrder);
        ordersHibernate.setIdUser(user);
        ordersHibernate.setIdProduct(product);
        ordersServiceHibernate.update(ordersHibernate);

        OrdersHibernate updatedOrder = ordersServiceHibernate.getId(idOrder);

        Assertions.assertEquals(idOrder, updatedOrder.getIdOrder());
        Assertions.assertEquals(user, updatedOrder.getIdUser());
        Assertions.assertEquals(product, updatedOrder.getIdProduct());

    }

    @Order(5)
    @Test
    void remove() throws SQLException {
        OrdersHibernate order = ordersServiceHibernate.getId(currentValue().getIdOrder());
        ordersServiceHibernate.remove(order);
    }

    @Order(4)
    @Test
    void getAll() throws SQLException {
        ArrayList<OrdersHibernate> orderList = (ArrayList<OrdersHibernate>) ordersServiceHibernate.getAll();
        Assertions.assertFalse(orderList.isEmpty());
    }

    @Order(3)
    @Test
    void getId() throws SQLException {
        OrdersHibernate order = ordersServiceHibernate.getId(currentValue().getIdOrder());
        Assertions.assertNotNull(order);
    }

    @AfterClass
    public static void ExitTest() {
        System.out.println("Тест завершен");
    }

}