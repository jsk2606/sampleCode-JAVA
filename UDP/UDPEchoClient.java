import java.net.*;
import java.io.*;

public class UDPEchoClient{

    private String str;                     //서버에 전송할 데이터
    private BufferedReader file;            //str에 저장될 값을 입력받기 위해
    private static int SERVERPORT=3000;     //전송할 서버의 포트
    public UDPEchoClient(String ip,int port){
        try{
            //1. 데이터 전송 준비
            InetAddress ia      = InetAddress.getByName(ip);    //전송할 서버의 주소
            DatagramSocket ds   = new DatagramSocket(port);     //전송 및 수신 처리를 할 포트로 소켓 생성

            System.out.print("message : ");

            //2. 서버에 데이터 전송
            file    = new BufferedReader(new InputStreamReader(System.in)); //요청할 text 를 입력 받음
            str     = file.readLine();              //입력받은 text를 String으로 변환
            byte buffer[]       = str.getBytes();   //변환한 string을 바이트배열로 변환
            DatagramPacket dp   =
                    new DatagramPacket(buffer,buffer.length,ia,SERVERPORT); //서버에 전송할 패킷 생성
            ds.send(dp);                //서버에 패킷 전송

            //3. 데이터 수신 준비
            buffer  = new byte[512];    //수신받을 패킷데이터의 크기 지정
            dp      = new DatagramPacket(buffer,buffer.length);             //클라이언트가 수신받을 패킷 생성
            ds.receive(dp);             //클라이언트 수신대기 상태
            /** ds.setSoTimeout(int 밀리세컨드); 해당 메서드로 최대 수신대기 시간을 설정할수있다 */

            System.out.println("server ip : "+dp.getAddress() + " , server port : "+dp.getPort());
            System.out.println("수신된 데이터 : "+ new String(dp.getData()).trim());

        }catch(IOException ioe){
            ioe.printStackTrace();
        }
    }
    public static void main(String[] args){
        //arg는 데이터를 전송할 (서버주소, 서버포트) 이다
        new UDPEchoClient("localhost",2000);
    }
}