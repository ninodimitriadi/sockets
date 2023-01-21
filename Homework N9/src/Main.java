public class Main {
    public static void main(String[] args) {
        Server s = new Server();
        s.start();

        Client c = new Client();
        Thread t = new Thread(c);
        t.start();
    }
}