import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();

        System.out.print("Enter from (1-20): ");
        int numDevices = scanner.nextInt();

        if (numDevices < 1 || numDevices > 20) {
            System.out.println("Invalid number. Please enter between 1 and 20.");
            return;
        }

        HashSet<String> distinctDeviceTypes = new HashSet<>();
        double totalPrice = 0;
        double totalWeight = 0;

        for (int i = 1; i <= numDevices; i++) {
            int randomDeviceType = rand.nextInt(3); // 0 for Smartphone, 1 for Laptop, 2 for Tablet

            String type, processor, operatingSystem;
            double price, weight, screenSize;
            int cameraResolution, ramSize;
            boolean hasStylus;

            // Generate random attributes for the device
            switch (randomDeviceType) {
                case 0: // Smartphone
                    type = "Smartphone";
                    price = 100 + rand.nextDouble() * 900; // Random price between $100 and $999
                    weight = 100 + rand.nextDouble() * 400; // Random weight between 100g and 499g
                    screenSize = 4 + rand.nextDouble() * 5; // Random screen size between 4" and 8.9"
                    cameraResolution = 5 + rand.nextInt(16); // Random camera resolution between 5MP and 20MP
                    distinctDeviceTypes.add("Smartphone");

                    Smartphone smartphone = new Smartphone(type, price, weight, screenSize, cameraResolution);
                    totalWeight += weight;
                    totalPrice += price;
                    break;
                case 1: // Laptop
                    type = "Laptop";
                    price = 300 + rand.nextDouble() * 1700; // Random price between $300 and $1999
                    weight = 1000 + rand.nextDouble() * 3000; // Random weight between 1kg and 4kg
                    processor = "Intel i" + (3 + rand.nextInt(9)); // Random processor model
                    ramSize = 4 + rand.nextInt(13); // Random RAM size between 4GB and 16GB
                    distinctDeviceTypes.add("Laptop");

                    Laptop laptop = new Laptop(type, price, weight, processor, ramSize);
                    totalWeight += weight;
                    totalPrice += price;
                    break;
                case 2: // Tablet
                    type = "Tablet";
                    price = 150 + rand.nextDouble() * 850; // Random price between $150 and $999
                    weight = 300 + rand.nextDouble() * 700; // Random weight between 300g and 999g
                    operatingSystem = "Android"; // Default operating system
                    hasStylus = rand.nextBoolean(); // Randomly has a stylus or not
                    distinctDeviceTypes.add("Tablet");

                    Tablet tablet = new Tablet(type, price, weight, operatingSystem, hasStylus);
                    totalWeight += weight;
                    totalPrice += price;
                    break;
                default:
                    break;
            }
        }

        System.out.println("Number of distinct device types created: " + distinctDeviceTypes.size());
        System.out.println("Total price of all devices: $" + totalPrice);
        System.out.println("Total weight of all devices: " + totalWeight + " grams");
    }
}
