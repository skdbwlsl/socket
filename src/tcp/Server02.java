package tcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server02 {
	public static void main(String[] args) throws IOException {
		ServerSocket server = new ServerSocket(12345);
		System.out.println("서버 실행 ...");
		Socket sock = server.accept(); //일시정지
		
		InputStream is = sock.getInputStream();
		//문자열 받기위해 보조스트림을 썼다(다양한 기능을 쓸수 있기 때문에 쓴다)
		DataInputStream di = new DataInputStream(is);
		
		System.out.println("수신대기...");
		String readData = di.readUTF(); //readUTF(); :String받을 떄 쓰는것. 다양한 문자열 처리가 가능
		System.out.println("수신 데이터 : " + readData);
		
		//수신했던 데이터를 다시 전송할 때 
		System.out.println("서버에서 전송할 데이터 입력");
		String s= new Scanner(System.in).next();
		
		OutputStream os = sock.getOutputStream();
		DataOutputStream dos = new DataOutputStream(os);
		dos.writeUTF(s);

		dos.close(); os.close();
		
		//모든 값 닫아주기
		di.close();is.close();sock.close();server.close();
	}

}
