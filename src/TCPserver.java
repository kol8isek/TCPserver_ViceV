import java.io.IOException;
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

        try (
                Scanner dataKlienta = new Scanner(socketOdKlienta.getInputStream());
                PrintWriter dataPosilanaTCPklientovi = new PrintWriter(socketOdKlienta.getOutputStream(), true)
        ) {
            // pošleme zprávu klientovi
            dataPosilanaTCPklientovi.println("Připojení navázáno");

            // čteme data od klienta
            while (dataKlienta.hasNextLine()) {
                String zprava = dataKlienta.nextLine();
                System.out.println("Klient: " + zprava);

                // echo zpět klientovi
                dataPosilanaTCPklientovi.println("Server přijal: " + zprava);
            }

        } catch (IOException e) {
            System.out.println("Chyba komunikace: " + e.getMessage());
        } finally {
            try {
                socketOdKlienta.close();
            } catch (IOException e) {
                System.out.println("Chyba při zavírání socketu");
            }
        }

        System.out.println("Klient se odpojil..");
    }
}