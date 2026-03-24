import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class TCPserver implements Runnable {
    private Socket socketOdKlienta;

    public TCPserver(Socket socketOdKlienta) {
        this.socketOdKlienta = socketOdKlienta;
    }

    @Override
    public void run() {
        System.out.println("Připojil se klient");
        Scanner dataKlienta = new Scanner(socketOdKlienta.getInputStream());
        PrintWriter dataPosilanaTCPklientovi
    }
}
