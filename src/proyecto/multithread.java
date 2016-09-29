package proyecto;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class multithread extends Thread {

    Socket cliente;
    PrintWriter out;
    BufferedReader in;

    public multithread(Socket cliente) throws IOException {
        this.cliente = cliente;
    }

    public void run() {
        try {
            in = new BufferedReader(new InputStreamReader(this.cliente.getInputStream()));
            String inputLine;
            while ((inputLine = in.readLine())!= null) {
                inputLine = inputLine.toUpperCase();
                for(int i=0;i<global.clientes.size();i++) {
                    if(global.clientes.get(i)!=this.cliente) {
                        out= new PrintWriter(global.clientes.get(i).getOutputStream(),true);
                        out.println(inputLine);
                    }

                }

        }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
