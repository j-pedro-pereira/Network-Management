import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Switch extends Equipamento {
    private List<Equipamento> connectedEquipamentos;

    public Switch(int id, String modelName, String macAddress, int numberOfPorts) {
        super(id, null, modelName, macAddress, numberOfPorts);
        this.connectedEquipamentos = new ArrayList<>();
    }

    public void displaySwitchInfo() {
        System.out.println("Switch Information:");
        System.out.println("ID: " + id);
        System.out.println("MAC Address: " + macAddress);
        System.out.println("Model Name: " + modelName);
        System.out.println("Number of Ports: " + numberOfPorts);
    }



    public int getId() {
        return id;
    }
}

