import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class Main {
    private static ArrayList<Equipamento> equipamentos = new ArrayList<>();

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int escolha;
        try (Scanner scanner = new Scanner(System.in)) {
            do {
                menu();
                System.out.print("!!Bem-vindo Escolha uma opção:!! ");
                escolha = scanner.nextInt();

                switch (escolha) {
                    case 1:
                        System.out.print("!!Escolha um tipo de equipamento: (Router - '1', Switch: '2')!!: ");
                        int escolha2 = scanner.nextInt();
                        switch (escolha2) {
                            case 1:
                                Equipamento newRouter = criarRouter();
                                if (newRouter != null) {
                                    equipamentos.add(newRouter);
                                }
                                break;
                            case 2:
                                Equipamento newSwitch = criarSwitch();
                                if (newSwitch != null) {
                                    equipamentos.add(newSwitch);
                                }
                                break;
                        }
                        break;
                    case 2:
                        System.out.print("!!Lista de Routers existentes na rede:!! ");
                        listarRouters();
                        System.out.print("!!Lista de Switches existentes na rede:!! ");
                        listarSwitches();
                        break;
                    case 3:
                        enviarPacote();
                        break;
                    case 4:
                        realizarPing();
                        break;
                    //case 5:
                        //String mensagem = obterMensagem();
                        //enviarStringEmPDUs(mensagem);
                        //break;
                    case 0:
                        System.out.println("!!Adeus!!");
                        break;
                    default:
                        System.out.println("!!Opção inválida!!");
                        break;
                }

            } while (escolha != 0);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
    private static void menu () {
        System.out.println("\n--------------------------------Menu---------------------------------------- ");
        System.out.println("---------------- 1: Adicionar novo equipamento de rede ---------------------- ");
        System.out.println("---------------- 2: Listar equipamentos de rede ----------------------------- ");
        System.out.println("---------------- 3: Enviar um pacote aleatório ------------------------------ ");
        System.out.println("---------------- 4: Efetuar teste de conexão com pings (ICMP) --------------- ");
        System.out.println("---------------- 5: Enviar string em formato PDU ---------------------------- ");
        System.out.println("------------------------------- 0: Sair ------------------------------------- ");
    }

    // Funçao para criar um Router do tipo Equipamento
    private static Equipamento criarRouter () {
        Scanner scanner = new Scanner(System.in);

        System.out.print("IP do Router: ");
        String ipAddress = scanner.nextLine();

        if (!isValidIPAddress(ipAddress)) {
            System.out.println("!!Endereço IP inválido. Deve estar no formato X.X.X.X..");
            return null;
        }

        System.out.print("Modelo do Router: ");
        String modelName = scanner.nextLine();

        if (!isValidModelName(modelName)) {
            System.out.println("!!Modelo não suportado..");
            return null;
        }

        System.out.print("MAC do Router: ");
        String macAddress = scanner.nextLine();

        System.out.print("Quantas portas? ");
        int numberOfPorts = scanner.nextInt();

        if (numberOfPorts < 1 || numberOfPorts > 12) {
            System.out.println("Número de portas inválido, deve ser no máximo 12..");
            return null;
        }

        System.out.print("ID do Router: ");
        int id = scanner.nextInt();

        Router routerCriado = new Router(id, ipAddress, modelName, macAddress, numberOfPorts);
        System.out.println("!!Router adicionado com sucesso!!");
        return routerCriado;
    }

    private static Equipamento criarSwitch () { // Funçao para criar um Switch do tipo Equipamento
        Scanner scanner = new Scanner(System.in);

        System.out.print("Modelo do Switch: ");
        String modelName = scanner.nextLine();

        if (!isValidModelName(modelName)) {
            System.out.println("!!Modelo não suportado..!!");
            return null;
        }

        System.out.print("MAC do Switch: ");
        String macAddress = scanner.nextLine();

        System.out.print("Quantas portas? ");
        int numberOfPorts = scanner.nextInt();

        if (numberOfPorts < 1 || numberOfPorts > 12) {
            System.out.println("!!Número de portas inválido, deve ser no máximo 12..");
            return null;
        }

        System.out.print("ID do Switch: ");
        int id = scanner.nextInt();


        Switch switchCriado = new Switch(id, modelName, macAddress, numberOfPorts);
        System.out.println("!!Switch adicionado com sucesso!!");
        return switchCriado;
    }

    private static void listarRouters() {
        for (Equipamento equipamento : equipamentos) {
            if (equipamento instanceof Router router) {
                router.displayRouterInfo();
            }
        }
    }

    private static void listarSwitches() {
        for (Equipamento equipamento : equipamentos) {
            if (equipamento instanceof Switch aSwitch) {
                aSwitch.displaySwitchInfo();
            }
        }
    }

    private static void enviarPacote() {
        if (equipamentos.size() < 2) {
            System.out.println("!!Não tem equipamentos suficientes para enviar um pacote!!");
            return;
        }

        System.out.println("Equipamento de origem?? (1-" + equipamentos.size() + "): ");
        int origemIndex = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Equipamento de destino?? (1-" + equipamentos.size() + "): ");
        int destinoIndex = scanner.nextInt();
        scanner.nextLine();

        if (origemIndex < 1 || origemIndex > equipamentos.size() || destinoIndex < 1 || destinoIndex > equipamentos.size()) {
            System.out.println("!!Índices inválidos. Tente novamente..!!");
            return;
        }

        Equipamento origem = equipamentos.get(origemIndex - 1);
        Equipamento destino = equipamentos.get(destinoIndex - 1);

        Packet pacote;

        // 20% de chance de erro
        if (Math.random() < 0.2) {
            System.out.println("!!O pacote foi perdido!!");
            pacote = origem.gerarPacoteAleatorio(destino.getIpAddress());
        } else {
            pacote = origem.gerarPacoteAleatorio(destino.getIpAddress());
            origem.enviarPacote(pacote, origem, destino);
            destino.receberPacote(pacote, destino);
            System.out.println("!!Pacote enviado com sucesso!!");
        }
    }

    private static boolean isValidIPAddress(String ipAddress) {
        String ipRegex = "\\b(?:\\d{1,3}\\.){3}\\d{1,3}\\b";
        // Ip está no formato X.X.X.X ?
        return ipAddress.matches(ipRegex);
    }

    private static boolean isValidModelName(String modelName) { // Modelo é valido??
        return modelName.equalsIgnoreCase("cisco") || modelName.equalsIgnoreCase("TP-LINK") || modelName.equalsIgnoreCase("Netgear") || modelName.equalsIgnoreCase("Fortigate")
                || modelName.equalsIgnoreCase("paloalto") || modelName.equalsIgnoreCase("ASUS");
    }

    private static void realizarPing() {   // Fazer um ping X vezes itnroduzidos pelo user
        if (equipamentos.size() < 2) {
            System.out.println("Não há equipamentos suficientes para realizar um ping. Adicione mais equipamentos.");
            return;
        }

        System.out.println("Selecione o Equipamento de origem (1-" + equipamentos.size() + "): ");
        int origemIndex = scanner.nextInt();
        scanner.nextLine(); // Consumir a quebra de linha

        System.out.println("Selecione o Equipamento de destino (1-" + equipamentos.size() + "): ");
        int destinoIndex = scanner.nextInt();
        scanner.nextLine(); // Consumir a quebra de linha

        if (origemIndex < 1 || origemIndex > equipamentos.size() || destinoIndex < 1 || destinoIndex > equipamentos.size()) {
            System.out.println("Índices de Equipamento inválidos. Tente novamente.");
            return;
        }

        Equipamento origem = equipamentos.get(origemIndex - 1);
        Equipamento destino = equipamentos.get(destinoIndex - 1);

        if (origem == null || destino == null) {
            System.out.println("!!Equipamento não encontrado. Certifique-se de que os equipamentos foram adicionados corretamente.");
            return;
        }

        System.out.print("Quantidade de pacotes: ");
        int quantidadePacotes = scanner.nextInt();

        for (int i = 0; i < quantidadePacotes; i++) {
            Packet pacote = origem.gerarPacotePing(destino.getIpAddress());
            origem.enviarPacote(pacote, origem, destino);
            destino.receberPacote(pacote, destino);
        }
    }

    /*private static String obterMensagem() {  // Obter msg
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduza a msg que quer enviar em PDU: ");
        return scanner.nextLine();
    }*/

    /*private static void enviarStringEmPDUs(String mensagem) {
        int tamanhoPDU = 2;  // Adjust this as needed

        // Iterate over the mensagem and send PDUs
        for (int i = 0; i < mensagem.length(); i += tamanhoPDU) {
            String pdu = mensagem.substring(i, Math.min(i + tamanhoPDU, mensagem.length()));
            System.out.println("Enviando PDU: " + pdu);

            // Assuming you have a destination router (adjust this based on your application)
            Equipamento destino = obterEquipamentoDestino();  // Implement this method

            // Check if the destination is a Router
            if (destino instanceof Router) {
                ((Router) destino).receberPDU(pdu);
            } else {
                System.out.println("Erro!! O destino deve ser um Router para receber PDUs.");
                // Handle the error as needed
            }
        }
    }*/

}