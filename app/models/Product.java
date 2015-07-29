package models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by linux on 30/7/15.
 */
public class Product {
    public String ean;
    public String name;
    public String description;


    private static List<Product> products;
    static {
        products = new ArrayList<Product>();
        products.add(new Product("1111111111111","paperclips 1",
                "Paperclips description 1"));
        products.add(new Product("2222222222222","paperclips 2",
                "Paperclips description "));
        products.add(new Product("3333333333333","paperclips 3",
                "Paperclips description 3"));
        products.add(new Product("4444444444444","paperclips 4",
                "Paperclips description 4"));
        products.add(new Product("5555555555555","paperclips 5",
                "Paperclips description 5"));
    }

    public Product(){}

    public Product(String ean,String name,String description){
        this.ean = ean;
        this.name = name;
        this.description = description;
    }

    public String toString(){
        return String.format("%s - %s",ean,name);
    }

    public static List<Product> findProducts(){
        return new ArrayList<Product>(products);
    }
    public static Product findByean(String ean){
        for(Product product : products){
            if(product.ean.equals(ean)){
                return product;
            }
        }
        return null;
    }

    public static List<Product> findByName(String term){
        final List<Product> results = new ArrayList<Product>();
        for (Product product : products){
            if(product.name.toLowerCase().contains(term.toLowerCase())){
                results.add(product);
            }
        }
        return results;
    }

    public static boolean remove (Product product){
        return products.remove(product);
    }
    public void save(){
        products.remove(findByean(this.ean));
        products.add(this);
    }
}
