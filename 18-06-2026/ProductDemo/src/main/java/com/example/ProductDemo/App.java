package com.example.ProductDemo;
import java.util.List;
public class App {
    public static void main(String[] args) {
        ProductDAO dao = new ProductDAO();
        // CREATE
        Product p = new Product();
        p.setId(1);
        p.setName("Laptop");
        p.setPrice(50000);
        dao.save(p);
        System.out.println("Product Inserted");
        // READ BY ID
        Product product = dao.getProduct(1);
        if(product != null) {
            System.out.println(product.getId() + " " + product.getName() + " " + product.getPrice());
        }
        // UPDATE
        product.setPrice(60000);
        dao.updateProduct(product);
        System.out.println("Product Updated");
        // READ ALL
        List<Product> products = dao.getAllProducts();
        System.out.println("\nAll Products:");
        for(Product pr : products) {
            System.out.println(pr.getId() + " " + pr.getName() + " " + pr.getPrice());
        }
        // DELETE
        dao.deleteProduct(1);
        System.out.println("Product Deleted");
        Utility.closeSessionFactory();
    }
}