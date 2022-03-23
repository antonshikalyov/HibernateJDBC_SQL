package Util;


import EntityHibernate.OrdersHibernate;
import EntityHibernate.ProductsHibernate;
import EntityHibernate.SellerHibernate;
import EntityHibernate.UsersHibernate;

import ServiseHibernate.OrdersServiceHibernate;
import ServiseHibernate.ProductsServiceHibernate;
import ServiseHibernate.SellerServiceHibernate;
import ServiseHibernate.UserServiceHibernate;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//        JavaHibernate.getSessionFactory();



        UserServiceHibernate userServiceHibernate = new UserServiceHibernate();
        ProductsServiceHibernate productsServiceHibernate = new ProductsServiceHibernate();
        SellerServiceHibernate sellerServiceHimernate = new SellerServiceHibernate();
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
            ArrayList<SellerHibernate> sellers = (ArrayList<SellerHibernate>) sellerServiceHimernate.getAll();
            SellerHibernate thisId = sellers.get(sellers.size()-1);
            System.out.println(thisId.getName());

//            System.out.println(sellerServiceHimernate.getId());

//            UsersHibernate user1 = userServiceHibernate.getId(34);
//            List<ProductsHibernate> productsList = productsServiceHibernate.getAll();
//            user1.setProducts(productsList);
//            userServiceHibernate.update(user1);
//            System.out.println(userServiceHibernate.getAll());
//            sellerServiceHimernate.getId(1);

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
