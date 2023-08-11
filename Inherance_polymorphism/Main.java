package Inherance_polymorphism;

import java.util.Scanner;
import java.util.Locale;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import Inherance_polymorphism_entities.ImportedProduct;
import Inherance_polymorphism_entities.Product;
import Inherance_polymorphism_entities.UsedProduct;

public class Main {

    public static void main(String[] args) throws ParseException {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        List<Product> list = new ArrayList<>();

        System.out.print("Enter the number of products: ");
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            System.out.print("Common, used or imported (c/u/i)?");
            char l = sc.next().charAt(0);

            sc.nextLine();
            System.out.println("Product #" + i + " data: ");
            System.out.print("Name: ");
            String name = sc.nextLine();
            System.out.print("Price: ");
            Double price = sc.nextDouble();

            if (l == 'c') {

                Product prod = new Product(name, price);
                list.add(prod);
            } else if (l == 'i') {
                sc.nextLine();
                System.out.print("Customs fee: ");
                Double customFee = sc.nextDouble();
                Product prod = new ImportedProduct(name, price, customFee);
                list.add(prod);
            } else if (l == 'u') {
                sc.nextLine();
                System.out.print("Manufacture date (DD/MM/YYYY): ");
                LocalDate manufactureDate = LocalDate.parse(sc.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                Product prod = new UsedProduct(name, price, manufactureDate);
                list.add(prod);
            }
        }

        System.out.println("\nPRICE TAGS:\n");
        
        for (Product prod : list) {
            System.out.println(prod.priceTag());
        }

        sc.close();
    }
}
