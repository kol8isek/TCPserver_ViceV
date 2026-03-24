import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("TCP server spuštěn");
        ServerSocket serverSocket = new ServerSocket(5555);

        while(true){
            Socket socketKlienta = serverSocket.accept();
            TCPserver server = new TCPserver(socketKlienta);
            Thread vlaknoKlienta = new Thread(server);
            vlaknoKlienta.start();

        }
    }
}