package networkmanagement;

public class Switch{
    private String ipAddress;
    private String modelName;
    private String macAddress;
    private int numberOfPorts;
    private double firmwareVersion;

    // Constructor
    public Switch(String ipAddress, String modelName, String macAddress, int numberOfPorts, boolean isWireless, double firmwareVersion) {
        this.ipAddress = ipAddress;
        this.modelName = modelName;
        this.macAddress = macAddress;
        this.numberOfPorts = numberOfPorts;
        this.firmwareVersion = firmwareVersion;
    }

    // Get methods
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

    public double getFirmwareVersion() {
        return firmwareVersion;
    }
    
    // Display router information
    public void displayRouterInfo() {
        System.out.println("Router Information:");
        System.out.println("IP Address: " + ipAddress);
        System.out.println("Model Name: " + modelName);
        System.out.println("MAC Address: " + macAddress);
        System.out.println("Number of Ports: " + numberOfPorts);
        System.out.println("Firmware Version: " + firmwareVersion);
    }
}

