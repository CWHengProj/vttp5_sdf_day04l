

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class clientMain {
    public static void main(String[] args) throws IOException {
        //0 port, filename, filesize
        Integer port = Integer.parseInt(args[0]);
        String fileName = args[1];
        //Integer fileSize = Integer.parseInt(args[2]);
        //server creates socket to connect to server
        Socket sock = new Socket(fileName,port);
        System.out.println("Connected to server.");
        //server performs output (write)
        for (int i=1; i<args.length; i++){
            //server edits the file information
            OutputStream os = sock.getOutputStream();
            BufferedOutputStream bos = new BufferedOutputStream(os);
            DataOutputStream dos = new DataOutputStream(bos);
            String words = args[i];
            //perform writing
            dos.writeUTF(words);
            //dos.writeLong(words);
            //dos.write(words);
            dos.flush();
            
        }
        sock.close();

        
    }
}
