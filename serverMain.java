

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class serverMain {
    public static void main(String[] args) throws IOException{
        int port = 5000;
        ServerSocket server = new ServerSocket(port);
        //client waits for connection with server
        Socket conn = server.accept();
        System.out.println("Connected!");
        for (int i=0; i<args.length; i++)
        {//client makes use of user input (read)
            InputStream is = conn.getInputStream();
            BufferedInputStream bis = new BufferedInputStream(is);
            DataInputStream dis = new DataInputStream(bis);
            //perform reading
            dis.readUTF();
            //dis.readLong();
            //dis.read();
        }
        server.close();

    }


}   
