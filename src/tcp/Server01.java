package tcp;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

//제공하는 컴
public class Server01 {
	public static void main(String[] args) throws IOException {
		//서버 : 서비스를 제공하는 컴퓨터
		//클라이언트 : 서비스를 제공받는 컴퓨터
		
		//port 번호: 2byte 크기를 가지고 있으며, 특정 프로그램(어플리케이션)을 구분 지어준다 -> 아이디를 부여하는 느낌이라 보면됨.아무것나 지정해도된다. sql디벨로퍼 사용할 떄 포트번호와 같은 것
		//2byte : 0~ 65535까지가능
		//bit(8개 모이면 byte) -> byte(1024개 모이면 kbyte) -> kbyte(1024) ->mbyte(1024) -> GB -> TB
		
		//자기자신을 서버로 (등록하는)만들어주는 명령어
		//자기자신의 아이피와 port(12345)로 서버로 구동해 준다
		ServerSocket server = new ServerSocket(12345); //포트번호는 내가 원하는 것으로 지정해도 상관없다
		System.out.println("접속 대기합니다");  //이건 뜨고
		//접속(연결) 대기 기능
		Socket sock = server.accept(); //sock :접속을 시도한 사용자를 구분하는 변수로 사용자 정보가 들어온다, 사람이 많을수록 이 코드가 많아야한다. 즉, 한번에 한번씩만 넣을 수 있다
		System.out.println("접속 되었습니다");  //이건 뜨지 않는다
		System.out.println(sock.getInetAddress());//접속한 사용자에 대한 정보
		
		//클라이언트(sock) 정보로부터 데이터를 받을 수 있는 기능
		InputStream input = sock.getInputStream();
		int readData = input.read(); //클라이언트에서 10을 보냈기 때문에 숫자 int로 받아준것
		System.out.println("수신 데이터 : " + readData);
		
		input.close(); sock.close();
	}

}
