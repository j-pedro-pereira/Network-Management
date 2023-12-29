package networkmanagement;

public class Main {
    public static void main(String[] args) {
        // Create an array of routers using the method from the Router class
        Router[] routers = Router.createRoutersArrayFromUserInput();

        // Display information for each router in the array
        for (Router router : routers) {
            System.out.println();  // For better readability
            router.displayRouterInfo();
        }
    }
}