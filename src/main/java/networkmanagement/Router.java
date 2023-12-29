package networkmanagement;

import java.util.Scanner;

public class Router {
    private int id;
    private String ipAddress;
    private String modelName;
    private String macAddress;
    private int numberOfPorts;
    private boolean isWireless;
    private double firmwareVersion;

    // Constructor
    public Router(int id, String ipAddress, String modelName, String macAddress, int numberOfPorts, boolean isWireless, double firmwareVersion) {
        this.id = id;
        this.ipAddress = ipAddress;
        this.modelName = modelName;
        this.macAddress = macAddress;
        this.numberOfPorts = numberOfPorts;
        this.isWireless = isWireless;
        this.firmwareVersion = firmwareVersion;
    }

    // Getter methods
    public int getId() {
        return id;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public String getModelName() {
        return modelName;
    }

    public String getMacAddress() {
        return macAddress;
    }

    public int getNumberOfPorts() {
        return numberOfPorts;
    }

    public boolean isWireless() {
        return isWireless;
    }

    public double getFirmwareVersion() {
        return firmwareVersion;
    }
    
    // Method to display router information
    public void displayRouterInfo() {
        System.out.println("Router Information:");
        System.out.println("ID: " + id);
        System.out.println("IP Address: " + ipAddress);
        System.out.println("Model Name: " + modelName);
        System.out.println("MAC Address: " + macAddress);
        System.out.println("Number of Ports: " + numberOfPorts);
        System.out.println("Wireless: " + (isWireless ? "Yes" : "No"));
        System.out.println("Firmware Version: " + firmwareVersion);
    }
     // Method to create an array of routers based on user input
     public static Router[] createRoutersArrayFromUserInput() {
        Scanner scanner = new Scanner(System.in);

        // Get the number of routers from the user
        System.out.print("Enter the number of routers: ");
        int numRouters = scanner.nextInt();
        scanner.nextLine();  // Consume the newline character

        // Create an array of routers
        Router[] routers = new Router[numRouters];

        // Populate the array with router objects using user input
        for (int i = 0; i < numRouters; i++) {
            System.out.println("\nEnter details for Router " + (i + 1) + ":");
            System.out.print("Enter IP Address: ");
            String ipAddress = scanner.nextLine();
            System.out.print("Enter Model Name: ");
            String modelName = scanner.nextLine();
            System.out.print("Enter MAC Address: ");
            String macAddress = scanner.nextLine();
            System.out.print("Enter Number of Ports: ");
            int numberOfPorts = scanner.nextInt();
            System.out.print("Is Wireless (true/false): ");
            boolean isWireless = scanner.nextBoolean();
            System.out.print("Enter Firmware Version: ");
            double firmwareVersion = scanner.nextDouble();

            // Create a router object with user input
            routers[i] = new Router(i + 1, ipAddress, modelName, macAddress, numberOfPorts, isWireless, firmwareVersion);
            scanner.nextLine();  // Consume the newline character
        }

        // Close the scanner
        scanner.close();

        return routers;
    }
}

