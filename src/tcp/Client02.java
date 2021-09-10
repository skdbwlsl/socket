package tcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client02 {
	public static void main(String[] args) throws IOException {
		Socket sock = new Socket("127.0.0.1",12345); //127.0.0.1->자기자신
		
		OutputStream os = sock.getOutputStream();
		DataOutputStream dos= new DataOutputStream(os);
		
		System.out.println("전송 데이터 입력");
		String s= new Scanner(System.in).next();
		
		//DataOutputStream쓰면 그냥 ouputstream보다 다양한 데이터를 처리할 수 있어서 써준다
		dos.writeUTF(s);
		
		System.out.println("전송 완료");
		
		
		//서버에서 보냈던 데이터를 받을 때 
		InputStream is = sock.getInputStream();
		DataInputStream ids = new DataInputStream(is);
		
		System.out.println("수신데이터 : " + ids.readUTF());
		ids.close(); is.close();
		
		//닫아줘야 자원낭비가 안일어나고, 혹시 모를 오류 방지
		dos.close(); os.close(); sock.close();
	}

}
