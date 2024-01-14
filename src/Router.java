import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class Router extends Equipamento {

    public Router(int id, String ipAddress, String modelName, String macAddress, int numberOfPorts) {
        super(id, ipAddress, modelName, macAddress, numberOfPorts);
    }

    public void displayRouterInfo() {
        System.out.println("Router Information:");
        System.out.println("ID: " + id);
        System.out.println("IP Address: " + ipAddress);
        System.out.println("Model Name: " + modelName);
        System.out.println("MAC Address: " + macAddress);
        System.out.println("Number of Ports: " + numberOfPorts);
    }


    public int getId() {
        return id;
    }
}