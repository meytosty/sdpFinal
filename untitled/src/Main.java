import java.util.Scanner;
import factory.*;
import observer.*;
import adapter.*;
import strategy.*;
import util.*;
import decorator.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CarFactory carFactory = new CarFactory();
        RentalManager rentalManager = RentalManager.getInstance();
        PaymentService paymentService = new PaymentAdapter(new ThirdPartyPaymentService());
        rentalManager.events.subscribe("rent", new EmailNotificationListener("bakhtiyar@gmail.com"));

        // Creating observers
        CarObserver carObserver1 = new CarStatusObserver("Observer1");
        CarObserver carObserver2 = new CarStatusObserver("Observer2");

        // Creating subject (car)
        Car sedan = carFactory.createCar("sedan");
        CarSubject carSubject = new CarSubject(sedan.getDescription());

        // Attaching observers to the subject
        carSubject.attach(carObserver1);
        carSubject.attach(carObserver2);

        // Changing car status (assuming sedan's status has changed)
        carSubject.updateCarStatus("Unavailable");

        while (true) {
            System.out.println("Choose an option:");
            System.out.println("1. View available cars");
            System.out.println("2. Rent a car");
            System.out.println("3. Add optional features to the rental");
            System.out.println("4. Calculate rental price");
            System.out.println("5. Complete payment");
            System.out.println("6. Receive notifications");
            System.out.println("7. Return a car");
            System.out.println("8. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.println("Available Cars for Rent: Sedan");
                    break;
                case 2:
                    // Rent a car
                    System.out.println("Enter car type (sedan/coupe): ");
                    String carType = scanner.nextLine();
                    Car rentedCar = carFactory.createCar(carType);
                    rentalManager.rentCar(carSubject, 100.0); // Sample price, change as needed
//                    rentedCar.addObserver(carObserver1); // Observer pattern to monitor car status
                    break;
                case 3:
                    System.out.println("1. Add Sunroof");
                    System.out.println("2. Add Spoiler");
                    int featureChoice = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    switch (featureChoice) {
                        case 1:
                            System.out.println("Sunroof added to the car.");
                            break;
                        case 2:
                            System.out.println("Spoiler added to the car.");
                            break;
                        default:
                            System.out.println("Invalid choice. Please choose again.");
                            break;
                        }
                    break;
                case 4:
                    // Calculate rental price using Strategy pattern
                    System.out.println("Enter duration (in days) for rental:");
                    int duration = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    System.out.println("Choose pricing strategy:");
                    System.out.println("1. Daily");
                    System.out.println("2. Weekly");
                    int pricingStrategyChoice = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    PricingStrategy pricingStrategy;
                    switch (pricingStrategyChoice) {
                        case 1:
                            pricingStrategy = new DailyPricingStrategy();
                            break;
                        case 2:
                            pricingStrategy = new WeeklyPricingStrategy();
                            break;
                        default:
                            System.out.println("Invalid pricing strategy choice.");
                            continue;
                    }

                    double rentalPrice = pricingStrategy.calculatePrice(duration);
                    System.out.println("Rental price: $" + rentalPrice);
                    break;
                case 5:
                    // Complete payment using Adapter pattern
                    System.out.println("Enter payment amount:");
                    double amount = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline

                    paymentService.makePayment(amount);
                    System.out.println("Payment completed successfully.");
                    break;
                case 6:
                    // Receive notifications using Observer pattern
                    // Since observers are already attached, changes in car status would automatically notify the observers
                    // For example, assuming the car status changed:
                    carSubject.updateCarStatus("Unavailable");
                    break;
                case 7:
                    // Return a car
                    System.out.println("Enter the ID of the car to return:");
                    String carId = scanner.nextLine();
                    rentalManager.returnCar(carId);
                    break;
                case 8:
                    System.out.println("Exiting...");
                    scanner.close(); // Close scanner before exiting
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please choose again.");
                    break;
            }
        }
    }
}
