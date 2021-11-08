package shoppingSpree;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class SaveInfo {

    private Map<String, Person> peopleInfo;
    private Map<String, Product> productInfo;

    public SaveInfo() {
        this.peopleInfo = new LinkedHashMap<>();
        this.productInfo = new HashMap<>();
    }

    public Map<String, Person> getPeopleInfo() {
        return peopleInfo;
    }

    public Map<String, Product> getProductInfo() {
        return productInfo;
    }

    public void extractPerson(String[] input) {
        for (String element : input) {
            String[] productData = element.split("=");
            String name = productData[0];
            double money = Double.parseDouble(productData[1]);

            try {
                Person person = new Person(name, money);
                peopleInfo.put(name, person);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                return;
            }
        }
    }

    public void extractProduct(String[] input) {
        for (String element : input) {
            String[] productData = element.split("=");
            String name = productData[0];
            double cost = Double.parseDouble(productData[1]);

            try {
                Product product = new Product(name, cost);
                productInfo.put(name, product);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                return;
            }
        }
    }
}
