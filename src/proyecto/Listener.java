package proyecto;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;


public class Listener extends Thread {
    Socket cliente;
    BufferedReader in;
    String inputLine, nombre;
    PrintWriter out;

    public Listener(Socket cliente, String nombre, PrintWriter out){
        this.cliente = cliente;
        this. nombre = nombre;
        this.out = out;
    }
    public void run(){
        try {
            in = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
            while ((inputLine = in.readLine()) != null) {
                System.out.println(inputLine); //Se muestra lo que es enviado por el servidor
            }
        } catch (Exception e) {

            e.printStackTrace();
        }

    }
}
