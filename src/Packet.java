import java.util.ArrayList;
import java.util.Scanner;
public class Packet {
    private int packetId;
    private String sourceIp;
    private String destIp;
    private int protocol;
    private String data;

    public Packet(int packetId, String sourceIp, String destIp, int protocol, String data) {
        this.packetId = packetId;
        this.sourceIp = sourceIp;
        this.destIp = destIp;
        this.protocol = protocol;
        this.data = data;
    }

    public void displayPacketInfo() {
        System.out.println("Informaçao sobre o pacote:");
        System.out.println("ID do pacote: " + packetId);
        System.out.println("Origem do pacote: " + sourceIp);
        System.out.println("Destino do pacote: " + destIp);
        System.out.println("Protocolo: " + protocol);
        System.out.println("Data: " + data);
    }

    public String getSourceIp() {
        return sourceIp;
    }

    public void setSourceIp(String sourceIp) {
        this.sourceIp = sourceIp;
    }

    public String getDestIp() {
        return destIp;
    }

    public void setDestIp(String destIp) {
        this.destIp = destIp;
    }

    public int getProtocol() {
        return protocol;
    }

    public void setProtocol(int protocol) {
        this.protocol = protocol;
    }

    public int getPacketId(){
        return packetId;
    }
}
