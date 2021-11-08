package shoppingSpree;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        SaveInfo saveInfo = new SaveInfo();

        String[] people = sc.nextLine().split(";");
        saveInfo.extractPerson(people);

        String[] products = sc.nextLine().split(";");
        saveInfo.extractProduct(products);

        String buyers = sc.nextLine();
        PlaceInfo placeInfo = new PlaceInfo();
        placeInfo.info(buyers, saveInfo, sc);

        for (Person person : saveInfo.getPeopleInfo().values()) {
            System.out.print(person.getName() + " - ");
            if (person.getProducts().isEmpty()) {
                System.out.println("Nothing bought");
            } else {
                System.out.println(person.getProducts().stream().map(Product::getName)
                        .collect(Collectors.joining(", ")));
            }
        }
    }
}