package proyecto;
import java.net.*;
import java.io.*;

public class Server {

    public static void main(String[] args) throws IOException {


        int portNumber = 1234;
        Thread[] th = new Thread[1000000];
        int i = 0;

        try {
            ServerSocket serverSocket = new ServerSocket(portNumber);

            while (true) {

                Socket clientSocket = serverSocket.accept();
                Global.socketClientes.add(clientSocket);
                th[i] = new Multithread(clientSocket);
                th[i].start();
                i++;
            }

        }
        catch (IOException e) {
            System.out.println("Error con el puerto " + portNumber);

            System.out.println(e.getMessage());
        }
    }
}