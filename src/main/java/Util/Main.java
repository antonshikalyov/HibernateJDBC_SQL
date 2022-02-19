package Util;


import Entity.Orders;
import Entity.Products;
import Entity.Seller;
import Entity.User;
import EntityHibernate.OrdersHibernate;
import EntityHibernate.ProductsHibernate;
import EntityHibernate.SellerHibernate;
import EntityHibernate.UsersHibernate;

import Service.OrdersService;
import Service.ProductsService;
import Service.SellerService;
import Service.UserService;
import ServiseHibernate.OrdersServiceHibernate;
import ServiseHibernate.ProductsServiceHibernate;
import ServiseHibernate.SellerServiceHimernate;
import ServiseHibernate.UserServiceHibernate;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//        JavaHibernate.getSessionFactory();



        UserServiceHibernate userServiceHibernate = new UserServiceHibernate();
        ProductsServiceHibernate productsServiceHibernate = new ProductsServiceHibernate();
        SellerServiceHimernate sellerServiceHimernate = new SellerServiceHimernate();
        OrdersServiceHibernate ordersServiceHibernate = new OrdersServiceHibernate();

        UsersHibernate usersHibernate = new UsersHibernate();
        ProductsHibernate productsHibernate = new ProductsHibernate();
        SellerHibernate sellerHibernate = new SellerHibernate();
        OrdersHibernate ordersHibernate = new OrdersHibernate();

        usersHibernate.setIdUser(33);
        productsHibernate.setIdProduct(23);

        ordersHibernate.setIdUser(usersHibernate);
        ordersHibernate.setIdProduct(productsHibernate);



        try {

//            UsersHibernate user1 = userServiceHibernate.getId(34);
//            List<ProductsHibernate> productsList = productsServiceHibernate.getAll();
//            user1.setProducts(productsList);
//            userServiceHibernate.update(user1);
              userServiceHibernate.getAll();

//            userServiceHibernate.add(usersHibernate);
            //productsServiceHibernate.add(productsHibernate);




//            System.out.println(sellerServiceHimernate.getAll());

//            UsersHibernate usersHibernate1 = new UsersHibernate();     //  получаю
//            usersHibernate1.getProducts();                            //  массив
//            System.out.println(usersHibernate1);                     //  продуктов
//            userServiceHibernate.getAll();                          //  из tb user

//            UsersHibernate user1 = userServiceHibernate.getId(11);
//            List<ProductsHibernate> products1 = new ArrayList<>();
//            products1.add(productsServiceHibernate.getId(1));
//            products1.add(productsServiceHibernate.getId(2));
//            System.out.println(products1);
//            user1.setProducts(products1);
//            userServiceHibernate.update(user1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
