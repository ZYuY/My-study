package udp;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.*;

public class Client  {
    public static void main(String[] args) throws IOException {
        DatagramSocket udpclientsocket = new DatagramSocket();
        String message="收到";
        byte[]sengbuffer=message.getBytes("UTF-8");
        byte[]serverip=new byte[4];
        serverip[0]=127;
        serverip[1]=0;
        serverip[2]=0;
        serverip[3]=1;
        InetAddress serveraddress=InetAddress.getByAddress(serverip);
        DatagramPacket sendpacket=new DatagramPacket(
                sengbuffer,
                sengbuffer.length,
                serveraddress,
                9898);
        udpclientsocket.send(sendpacket);
        udpclientsocket.close();

    }
}
