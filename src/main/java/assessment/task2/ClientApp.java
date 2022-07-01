package assessment.task2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Hello world!
 *
 */
public class ClientApp 
{
    public static void main( String[] args ) throws UnknownHostException, IOException
    {
        System.out.println("Client is up");
        String ip = "68.183.239.26";
        int port = 80;

        Socket socket = new Socket(ip , port);

        OutputStream out = socket.getOutputStream();
        DataOutputStream dOut = new DataOutputStream(out);

        // String req = dOut.writeUTF("hello");

        InputStream in = socket.getInputStream();
        DataInputStream dIn = new DataInputStream(in);

        String resp = dIn.readUTF();
        String[] arr = resp.split(" ");

        System.out.println(arr.toString());
        
        socket.close();

    }
}
