import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server extends Thread{

    public void run(){
        Scanner scan = new Scanner(System.in);
        String ip = scan.nextLine();

        try {
            ServerSocket ss = new ServerSocket(8080);
            Socket s = ss.accept();

            while (true){
                ObjectInputStream in = new ObjectInputStream(s.getInputStream());
                String massage = (String) in.readObject();
                System.out.println("S -> " + massage);

                if (massage.equals("bye")){
                    System.exit(0);
                }

                System.out.println("Server:" + " ");
                ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream());
                String send_massage = scan.nextLine();
                out.writeObject(send_massage);

            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
