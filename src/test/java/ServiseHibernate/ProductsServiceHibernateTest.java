package ServiseHibernate;

import EntityHibernate.ProductsHibernate;
import EntityHibernate.SellerHibernate;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.jupiter.api.*;

import java.sql.SQLException;
import java.util.ArrayList;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ProductsServiceHibernateTest {
    SellerServiceHibernate sellerServiceHibernate = new SellerServiceHibernate();
    ProductsServiceHibernate productsServiceHibernate = new ProductsServiceHibernate();
    ProductsHibernate productsHibernate = new ProductsHibernate();

    @BeforeClass
    public static void globalSetUp() {
        System.out.println("Загрузка теста...");
        System.out.println("...");
    }

    public ProductsHibernate currentValue() throws SQLException {
        ArrayList<ProductsHibernate> productsList = (ArrayList<ProductsHibernate>) productsServiceHibernate.getAll();
        return productsList.get(productsList.size() - 1);
    }

    @Order(1)
    @Test
    void add() throws SQLException {
        ArrayList<SellerHibernate> List = (ArrayList<SellerHibernate>) sellerServiceHibernate.getAll();

        String name = "TestProduct";
        SellerHibernate seller = List.get(List.size() - 1);
        int cost = 5;
        String discrption = "Discription";

        productsHibernate.setNameOfProduct(name);
        productsHibernate.setSeller(seller);
        productsHibernate.setCost(cost);
        productsHibernate.setDiscription(discrption);
        productsServiceHibernate.add(productsHibernate);

        Assertions.assertEquals(name, currentValue().getNameOfProduct());
        Assertions.assertEquals(seller, currentValue().getSeller());
        Assertions.assertEquals(cost, currentValue().getCost());
        Assertions.assertEquals(discrption, currentValue().getDiscription());
    }

    @Order(2)
    @Test
    void update() throws SQLException {
        ArrayList<SellerHibernate> sellersList = (ArrayList<SellerHibernate>) sellerServiceHibernate.getAll();
        ProductsHibernate id = productsServiceHibernate.getId(currentValue().getIdProduct());

        int idOfproduct = id.getIdProduct();
        String name = "Test1";
        SellerHibernate seller = sellersList.get(sellersList.size() - 1);
        int cost = 1;
        String discrption = "11111";

        productsHibernate.setIdProduct(idOfproduct);
        productsHibernate.setNameOfProduct(name);
        productsHibernate.setSeller(seller);
        productsHibernate.setCost(cost);
        productsHibernate.setDiscription(discrption);
        productsServiceHibernate.update(productsHibernate);

        ProductsHibernate updatedProduct = productsServiceHibernate.getId(idOfproduct);
        seller = sellerServiceHibernate.getId(seller.getIdSeller());

        Assertions.assertEquals(name, updatedProduct.getNameOfProduct());
        Assertions.assertEquals(seller, updatedProduct.getSeller());
        Assertions.assertEquals(cost, updatedProduct.getCost());
        Assertions.assertEquals(discrption, updatedProduct.getDiscription());
    }

    @Order(5)
    @Test
    void remove() throws SQLException {
        ProductsHibernate product = productsServiceHibernate.getId(currentValue().getIdProduct());
        productsServiceHibernate.remove(productsServiceHibernate.getId(product.getIdProduct()));
    }

    @Order(4)
    @Test
    void getAll() throws SQLException {
        ArrayList<ProductsHibernate> productsList = (ArrayList<ProductsHibernate>) productsServiceHibernate.getAll();
        Assertions.assertFalse(productsList.isEmpty());
    }

    @Order(3)
    @Test
    void getId() throws SQLException {
        ProductsHibernate product = productsServiceHibernate.getId(currentValue().getIdProduct());
        Assertions.assertNotNull(product);
    }

    @AfterClass
    public static void ExitTest() {
        System.out.println("Тест завершен");
    }
}