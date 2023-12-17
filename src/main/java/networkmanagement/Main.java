package networkmanagement;

public class Main {
    public static void main(String[] args) {
        // Create a router object
        Router myRouter = new Router("192.168.1.1", "Linksys", "00:1A:2B:3C:4D:5E", 4, true, 2.0);

        // Accessing object properties
        System.out.println("IP Address: " + myRouter.getIpAddress());
        System.out.println("Model Name: " + myRouter.getModelName());
        System.out.println("MAC Address: " + myRouter.getMacAddress());
        System.out.println("Number of Ports: " + myRouter.getNumberOfPorts());
        System.out.println("Wireless: " + (myRouter.isWireless() ? "Yes" : "No"));
        System.out.println("Firmware Version: " + myRouter.getFirmwareVersion());

        // Upgrade firmware
        myRouter.upgradeFirmware(2.1);

        // Display router information
        myRouter.displayRouterInfo();
    }
}