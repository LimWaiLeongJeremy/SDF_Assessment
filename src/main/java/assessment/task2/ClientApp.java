package assessment.task2;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;


public class ClientApp 
{
    public static void main( String[] args )
    {
        System.out.println("Client is up");
        String ip = "68.183.239.26";
        int port = 80;
        
        String name = "Lim Wai Leong, Jeremy";
        String eMail = "Jereremy19995@hotmail.sg"; 
       
        try {
            Socket socket = new Socket(ip , port);

            OutputStream out = socket.getOutputStream();
            ObjectOutputStream oOut = new ObjectOutputStream(out);


            InputStream in = socket.getInputStream();
            ObjectInputStream oIn = new ObjectInputStream(in);

            String resp = oIn.readUTF();
            String[] arr = resp.split(" ");
            String id = arr[0];
            String num = arr[1];
        
            int totalAmt = 0;
         

            String[] numArr = num.split(",");
            float divideWith = numArr.length;
            for (int i =0; i < numArr.length; i++) {
                // System.out.println(numArr[i] + " ");
                int numIntArr = Integer.parseInt(numArr[i]);
                totalAmt = numIntArr + totalAmt;
            }
            

            Float average = totalAmt/divideWith;
            Float roundOff = (float) (Math.round(average * 100.0) / 100.0);


            oOut.writeUTF(id);
            oOut.writeUTF(name);
            oOut.writeUTF(eMail);
            oOut.writeFloat(average);  

            // System.out.println(id);
            // System.out.println(divideWith);
            // System.out.println(); 
            // System.out.println(totalAmt);  
            // System.out.println();
            // System.out.println(roundOff); 

            boolean respBoo = oIn.readBoolean();
            System.out.println(respBoo);
            
            if (!respBoo){
                String resperr = oIn.readUTF();
                System.out.println(resperr);
            }else{
                System.out.println("SUCCESS");
            }

        oIn.close();
        in.close();
        oOut.flush();
        out.flush();
        oOut.close();
        out.close();
        socket.close();

        } catch (UnknownHostException e) {
            System.err.println(e);
        } catch (EOFException e) {
            System.err.println(e);
        } catch (IOException e) {
            System.err.println(e);
        }
    
        
    }
}
