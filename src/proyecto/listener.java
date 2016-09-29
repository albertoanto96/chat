package proyecto;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

public class listener extends Thread {
    Socket socketcliente;
    BufferedReader in;
    String InputLine;
    public listener (Socket socketcliente){
        this.socketcliente=socketcliente;
    }
    public void run(){
        try {
            in =new BufferedReader(new InputStreamReader(socketcliente.getInputStream()));
            while((InputLine=in.readLine())!=null)
            {
                System.out.println("Servidor:"+InputLine);
            }
        } catch (Exception e) {

            e.printStackTrace();
        }

    }
}
