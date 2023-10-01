import java.util.Random;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class MainProgram {
    public static void main(String[] args) {
    	Scanner scanner = new Scanner(System.in);
    	
    	System.out.print("Enter the number of devices you want to create (between 1 and 20): ");
        int numDevices = scanner.nextInt();
        
        if (numDevices < 1 || numDevices > 20) {
            System.out.println("Invalid input.");
            return;
        }

        Random rand = new Random();
        ArrayList<Device> devices = new ArrayList<>();

        for (int i = 0; i < numDevices; i++) {
            String type = getRandomDeviceType(rand);
            double price = rand.nextDouble() * 1000; // Random price between 0 and 1000 USD
            double weight = rand.nextDouble() * 2000; // Random weight between 0 and 2000 grams

            switch (type) {
                case "Smartphone":
                    double screenSize = rand.nextDouble() * 10; // Random screenSize
                    int cameraResolution = rand.nextInt(100); // Random cameraResolution
                    devices.add(new Smartphone(type, price, weight, screenSize, cameraResolution));
                    break;
                case "Laptop":
                    String processor = "Random Processor"; // Random processor
                    int ramSize = rand.nextInt(32); // Random ramSize
                    devices.add(new Laptop(type, price, weight, processor, ramSize));
                    break;
                case "Tablet":
                    String operatingSystem = "Random OS"; // Random operatingSystem
                    devices.add(new Tablet(type, price, weight, operatingSystem));
                    break;
                default:
                    System.out.println("Invalid device type.");
            }
        }

        HashSet<String> distinctDeviceTypes = new HashSet<>();
        double totalPrice = 0;
        double totalWeight = 0;

        for (Device device : devices) {
            distinctDeviceTypes.add(device.getType());
            totalPrice += device.getPrice();
            totalWeight += device.getWeight();
        }

        System.out.println("Number of distinct device types: " + distinctDeviceTypes.size());
        System.out.println("Total price of all devices: $" + totalPrice);
        System.out.println("Total weight of all devices: " + totalWeight + " grams");
    }

    private static String getRandomDeviceType(Random rand) {
        String[] deviceTypes = {"Smartphone", "Laptop", "Tablet"};
        return deviceTypes[rand.nextInt(deviceTypes.length)];
    }
}


