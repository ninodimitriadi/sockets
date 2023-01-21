import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client implements Runnable{
    Scanner scan = new Scanner(System.in);
    String ip =  scan.nextLine();

    @Override
    public void run() {
        try {
            Socket s = new Socket(InetAddress.getByName(ip), 8080);

            while (true){
                System.out.println("Client: ");
                String send_msg = scan.nextLine();
                ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream());
                out.writeObject(send_msg);

                ObjectInputStream in = new ObjectInputStream(s.getInputStream());
                String m = (String) in.readObject();
                System.out.println("C -> " + m);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
