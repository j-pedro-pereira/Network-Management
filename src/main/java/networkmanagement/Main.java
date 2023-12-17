package networkmanagement;

public class Main {
    public static void main(String[] args) {
        // Create a router object
        Router myRouter = new Router("192.168.1.1", "Linksys", "00:1A:2B:3C:4D:5E", 4, true, 2.0);

        // Display router information
        myRouter.displayRouterInfo();
    }
}