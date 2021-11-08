package shoppingSpree;

import java.util.Scanner;

public class PlaceInfo {



    public void info(String buyers, SaveInfo saveInfo, Scanner sc) {

        while (!buyers.equals("END")) {

            String[] splitBuyers = buyers.split("\\s+");
            String buyer = splitBuyers[0];
            String wantToBuy = splitBuyers[1];

            try {
                Person person = saveInfo.getPeopleInfo().get(buyer);
                Product product = saveInfo.getProductInfo().get(wantToBuy);
                person.buyProduct(product);

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

            buyers = sc.nextLine();
        }

    }
}
