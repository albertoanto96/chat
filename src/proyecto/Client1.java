package proyecto;
import java.io.*;
import java.net.*;
import java.util.Objects;

public class Client1  {
    public static void main(String[] args)throws  IOException {
        String hostIP = "127.0.0.1";
        int portNumber = 1234;
        Thread listen;
        String userInput, nombre, sala;
        try {
            BufferedReader stdIN = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Dime tu nombre:");
            nombre = stdIN.readLine();
            Socket echoSocket = new Socket(hostIP, portNumber);
            PrintWriter out = new PrintWriter(echoSocket.getOutputStream(), true);
            listen = new Listener(echoSocket, nombre, out);
            listen.start(); //Se inicia el thread por donde se escuchara lo que envia el servidor
            System.out.println("Escribe la sala donde te quieres unir:");
            sala = stdIN.readLine();
            out.println("CONNECT " + sala + " " + nombre);
            String texto = null;

            while (true) {
                texto = stdIN.readLine();
                if (Objects.equals("EXIT", texto)) {
                    out.println("EXIT "+ sala + " "+nombre); //Mensaje para hacer saber a los demas quien se va
                    System.exit(2);
                }
                else {
                    out.println("TEXT " + sala + " " + texto); //Se envia el texto al servidor
                }
            }
        }

        catch (UnknownHostException e) {
            System.err.println("No se conoce IP : " + hostIP);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Imposible conectarse a : " + hostIP);

            System.exit(1);
        }
    }
}
