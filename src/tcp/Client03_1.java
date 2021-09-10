package tcp;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client03_1 {
	public static void main(String[] args) throws IOException {
		Socket sock = new Socket("127.0.0.1",12345);
		
		OutputStream os = sock.getOutputStream();
		DataOutputStream dos= new DataOutputStream(os);
		
		System.out.println("전송 데이터 입력");
		String s= new Scanner(System.in).next();
		
		//DataOutputStream쓰면 그냥 ouputstream보다 다양한 데이터를 처리할 수 있어서 써준다
		dos.writeUTF(s);
		
		System.out.println("전송 완료");
		
		dos.close(); os.close(); sock.close();
	}
	}

