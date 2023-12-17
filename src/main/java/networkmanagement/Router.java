package networkmanagement;

public class Router {
    private String ipAddress;
    private String modelName;
    private String macAddress;
    private int numberOfPorts;
    private boolean isWireless;
    private double firmwareVersion;

    // Constructor
    public Router(String ipAddress, String modelName, String macAddress, int numberOfPorts, boolean isWireless, double firmwareVersion) {
        this.ipAddress = ipAddress;
        this.modelName = modelName;
        this.macAddress = macAddress;
        this.numberOfPorts = numberOfPorts;
        this.isWireless = isWireless;
        this.firmwareVersion = firmwareVersion;
    }

    // Getter methods
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

    // Method to upgrade firmware
    public void upgradeFirmware(double newVersion) {
        this.firmwareVersion = newVersion;
        System.out.println("Firmware upgraded to version " + newVersion);
    }

    // Method to display router information
    public void displayRouterInfo() {
        System.out.println("Router Information:");
        System.out.println("IP Address: " + ipAddress);
        System.out.println("Model Name: " + modelName);
        System.out.println("MAC Address: " + macAddress);
        System.out.println("Number of Ports: " + numberOfPorts);
        System.out.println("Wireless: " + (isWireless ? "Yes" : "No"));
        System.out.println("Firmware Version: " + firmwareVersion);
    }
}

