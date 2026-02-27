package application;

import entities.*;

import java.sql.SQLOutput;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws ParseException {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat modifDate = new SimpleDateFormat("dd/MM/yyyy");


        System.out.println("Informe os dados do cliente:");
        System.out.println("Nome: ");
        String name = sc.nextLine();
        System.out.println("E-mail: ");
        String email = sc.nextLine();
        System.out.println("Data de aniversário (dd/MM/yyyy): ");
        Date birthDate = modifDate.parse(sc.next());

        Client client = new Client(name, email, birthDate);

        System.out.println("Informe os dados do pedido:");
        System.out.println("Status: ");
        OrderStatus status = OrderStatus.valueOf(sc.next());
        System.out.println("Quantos itens o pedido possui: ");
        int n = sc.nextInt();

        Order order = new Order(new Date(), status, client);

        for(int i = 0; i < n; i++){
            System.out.println("Informe #" + i + " dados do item:");
            System.out.println("Nome do produto: ");
            sc.nextLine();
            String productName = sc.nextLine();
            System.out.println("Preço do produto: ");
            double productPrice = sc.nextDouble();
            System.out.println("Quantidade: ");
            int quantity = sc.nextInt();

            Product product = new Product(productName, productPrice);

            OrderItem it = new OrderItem(quantity, productPrice, product);

            order.addItem(it);
        }

        System.out.println();
        System.out.println(order);
    }
}