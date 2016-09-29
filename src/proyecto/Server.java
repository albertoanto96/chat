package proyecto;
import java.lang.*;
import java.lang.Thread;
import java.net.*;
import java.io.*;

import static java.lang.System.out;

public class Server{
    public static void main(String[] args) throws IOException {
        int portNumber = 1234;
        Thread[] th = new Thread[100000000];
        int i=0;

        try {
            ServerSocket serverSocket = new ServerSocket(portNumber);

            while(true) {
                Socket clientSocket = serverSocket.accept();
                global.clientes.add(clientSocket);
                th[i] = new multithread(clientSocket);
                th[i].start();
                i++;
            }
        }
         catch (IOException e) {
            out.println("Error en el puerto "+ portNumber);

            out.println(e.getMessage());
        }
    }
}