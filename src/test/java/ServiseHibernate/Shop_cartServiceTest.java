package ServiseHibernate;

import Entity.Products;
import Entity.Shop_cart;
import Entity.User;
import Service.ProductsService;
import Service.Shop_cartService;
import Service.UserService;
import org.junit.jupiter.api.*;

import java.sql.SQLException;
import java.util.ArrayList;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class Shop_cartServiceTest {
    Shop_cartService shop_cartService = new Shop_cartService();
    Shop_cart shop_cart = new Shop_cart();

    UserService userService = new UserService();
    Products products = new Products();
    ProductsService productsService = new ProductsService();

    public Shop_cart currentValue() throws SQLException {
        ArrayList<Shop_cart> shopCartList = (ArrayList<Shop_cart>) shop_cartService.getAll();
        return shopCartList.get(shopCartList.size() - 1);
    }

    @Order(1)
    @Test
    void add() throws SQLException {
        ArrayList<User> users = (ArrayList<User>) userService.getAll();
        ArrayList<Products> products = (ArrayList<Products>) productsService.getAll();

        int idUser = users.get(users.size() -1).getIdUser();
        int idProduct = products.get(products.size() -1).getIdProduct();

        shop_cart.setIdUser(idUser);
        shop_cart.setIdProduct(idProduct);
        shop_cartService.add(shop_cart);

        Assertions.assertEquals(idUser, currentValue().getIdUser());
        Assertions.assertEquals(idProduct, currentValue().getIdProduct());
    }

    @Order(2)
    @Test
    void update() throws SQLException {
        ArrayList<User> users = (ArrayList<User>) userService.getAll();
        ArrayList<Products> products = (ArrayList<Products>) productsService.getAll();

        int idUser = users.get(users.size() -1).getIdUser();
        int idProduct = products.get(products.size() -1).getIdProduct();

        shop_cart.setIdUser(idUser);
        shop_cart.setIdProduct(idProduct);
        shop_cartService.update(shop_cart);

        Assertions.assertEquals(idUser, currentValue().getIdUser());
        Assertions.assertEquals(idProduct, currentValue().getIdProduct());
    }

    @Order(5)
    @Test
    void remove() throws SQLException {
        Shop_cart shopCart = shop_cartService.getId(currentValue().getIdUser());
        shop_cartService.remove(shopCart.getIdUser());
    }

    @Order(4)
    @Test
    void getAll() throws SQLException {
        ArrayList<Shop_cart> shop_carts = (ArrayList<Shop_cart>) shop_cartService.getAll();
        Assertions.assertFalse(shop_carts.isEmpty());
    }

    @Order(3)
    @Test
    void getId() throws SQLException {
        Shop_cart shop_carts = shop_cartService.getId(currentValue().getIdUser());
        Assertions.assertNotNull(shop_carts);
    }
}