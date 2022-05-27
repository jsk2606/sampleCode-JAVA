import java.net.*;
import java.io.*;

public class UDPEchoServer {
    public UDPEchoServer(int port) {

        try {
            //1. 데이터 송수신 준비
            DatagramSocket ds = new DatagramSocket(port);   //데이터를 송수신할 소켓 생성
            
            while (true) {

                //2. 데이터 수신 준비
                System.out.println("ready");
                byte buffer[]       = new byte[512];    //수신받을 패킷데이터의 크기 지정
                DatagramPacket dp   = new DatagramPacket(buffer,buffer.length); //서버가 수신받을 패킷 생성
                ds.receive(dp);     //서버 수신대기 상태

                //3. 데이터 전송 준비
                String str          = new String(dp.getData()); //클라이언트의 데이터를 String으로 변환
                System.out.println("수신된 데이터 : " + str);

                InetAddress ia      = dp.getAddress();          //클라이언트 IP
                port = dp.getPort();                            //클라이언트 포트

                System.out.println("client ip : " + ia + " , client port : " + port);

                //4. 데이터 전송
                dp = new DatagramPacket(dp.getData(),dp.getData().length, ia,port); //수신받은 정보로 패킷 생성
                ds.send(dp);    //클라이언트로 데이터 전송

            }   //end while
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        new UDPEchoServer(3000);
    }
}

/** code by : https://coding-factory.tistory.com/271 */
