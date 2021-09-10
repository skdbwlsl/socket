package tcp;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

//tcp: 신뢰할 수 있는 방식, 보통 사용하는 방식이 tcp
//udp :신뢰할 수 없는 방식이지만, 속도는 빠르다(데이터 신뢰가 없어도 되는 곳에서 쓴다.IPTV경우, 빠른게 더 낫기 때문에) -> 실시간 전송 같은것

//제공받는 컴
public class Client01 {
	public static void main(String[] args) throws IOException {
		//여기서 접속기능 만든다
		//서버와 접속(연결) 시도(접속하고자 하는 서버ip, port)
		Socket sock = new Socket("localhost",12345);  //()안에 서버에 대한 정보를 넣어준다. 여기는 집이기에 자기 자신인 localhost써줌
		
		//sock을 이용해 데이터 보낼 수 있는 연결통로 만들기
		//OutputStream : 출력을 위한 스트림
		OutputStream out = sock.getOutputStream();  //서버와 연결돼 있는 sock을 이용해 스트림을 얻어온다
		
		System.out.println("수 입력");
		int num = new Scanner(System.in).nextInt();
		out.write(num);
		
		out.close();
		sock.close();

		
	}//특정아이파210.222이런식으로 
//여기서 실행하면 서버의 accept와 만난다
}
