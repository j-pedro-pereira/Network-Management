import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
public class Equipamento {
    protected int id;
    protected String ipAddress;
    protected String modelName;
    protected String macAddress;
    protected int numberOfPorts;

    public Equipamento(int id, String ipAddress, String modelName, String macAddress, int numberOfPorts) {
        this.id = id;
        this.ipAddress = ipAddress;
        this.modelName = modelName;
        this.macAddress = macAddress;
        this.numberOfPorts = numberOfPorts;

    }

    public int getId() {
        return id;
    }

    public String getIpAddress(){
        return ipAddress;
    }

    public String getMacAddress(){
        return macAddress;
    }

    public void displayEquipamentoInfo() {
        System.out.println("Informaçao sobre equipamento");
        System.out.println("ID: " + id);
        System.out.println("IP Address: " + ipAddress);
        System.out.println("Model Name: " + modelName);
        System.out.println("MAC Address: " + macAddress);
        System.out.println("Number of Ports: " + numberOfPorts);
    }

    public void displayBasicInfo() {
        System.out.println("IP Address: " + ipAddress);
        System.out.println("MAC Address: " + macAddress);
    }

    public Packet gerarPacoteAleatorio(String destIp) {
        Random random = new Random();
        int packetId = random.nextInt(1000);
        String sourceIp = getIpAddress();
        int protocolOptions[] = {1, 6, 17};
        int randomIndex = random.nextInt(protocolOptions.length);
        int protocol = protocolOptions[randomIndex];
        String data = "8238363545\n" +
                "4428361241\n" +
                "1755110806\n" +
                "2380926563\n" +
                "7041845689";

        return new Packet(packetId, sourceIp, destIp, protocol, data);
    }

    public Packet gerarPacotePing(String destIpAddress) {
        Random random = new Random();
        int packetId = random.nextInt(1000);
        String sourceIp = getIpAddress();
        int protocol = 1; // Protocolo ICMP para ping
        String data = "Ping - Origem: " + sourceIp + ", Destino: " + destIpAddress;

        return new Packet(packetId, sourceIp, destIpAddress, protocol, data);
    }

    public void enviarPacote(Packet packet, Equipamento origem, Equipamento destino) {
        if (!(origem instanceof Router) || !(destino instanceof Router)) {
            System.out.println("Erro!! Os dois equipamentos tem que ser routers..");
            return;
        }

        System.out.println("Pacote " + packet.getPacketId() + " saiu da origem Router " + origem.getId() + " para o Router " + destino.getId());
    }

    public void receberPacote(Packet packet, Equipamento destino) {
        if (!(destino instanceof Router)) {
            System.out.println("Erro!! O destino deve ser um Router para receber pacotes.");
            return;
        }

        System.out.print("O Router " + destino.getId() + " recebeu o pacote " + packet.getPacketId() +
                " do protocolo: " + packet.getProtocol());
        if (packet.getProtocol() == 1) {
            System.out.println(" (ICMP)");
        } else if (packet.getProtocol() == 6) {
            System.out.println(" (TCP)");
        } else if (packet.getProtocol() == 17) {
            System.out.println(" (UDP)");
        } else {
            System.out.println(" (Protocolo desconhecido)");
        }
    }

}
