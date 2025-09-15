package murach.data;

import java.io.*;
import java.util.*;
import murach.business.Product;

public class ProductIO {

    public static Product getProduct(String code, String filepath) {
        try (BufferedReader in = new BufferedReader(new FileReader(filepath))) {
            String line;
            while ((line = in.readLine()) != null) {
                StringTokenizer t = new StringTokenizer(line, "|");
                String productCode = t.nextToken();
                if (code.equalsIgnoreCase(productCode)) {
                    String description = t.nextToken();
                    double price = Double.parseDouble(t.nextToken());
                    Product p = new Product();
                    p.setCode(code);
                    p.setDescription(description);
                    p.setPrice(price);
                    return p;
                }
            }
            return null;
        } catch (IOException e) {
            System.err.println(e);
            return null;
        }
    }

    public static ArrayList<Product> getProducts(String filepath) {
        ArrayList<Product> products = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new FileReader(filepath))) {
            String line;
            while ((line = in.readLine()) != null) {
                StringTokenizer t = new StringTokenizer(line, "|");
                String code = t.nextToken();
                String description = t.nextToken();
                double price = Double.parseDouble(t.nextToken());

                Product p = new Product();
                p.setCode(code);
                p.setDescription(description);
                p.setPrice(price);
                products.add(p);
            }
        } catch (IOException e) {
            System.err.println(e);
        }
        return products;
    }
}
