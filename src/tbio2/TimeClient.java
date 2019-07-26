package tbio2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class TimeClient {

	public static void main(String[] args) {
		Socket socket = null;
		try {
			socket = new Socket(InetAddress.getLocalHost(), 9999);
			InputStream is = socket.getInputStream();
			OutputStream out = socket.getOutputStream();
			
			//װ����ģʽ��װis����,������ж�ȡ
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			//�ͻ��˺ͷ���˽��ж�д���������������Է��Ƿ���������뻥��ȴ���״��,ʹ��pw��Ĭ����ӻ���
			PrintWriter pw = new PrintWriter(out,true);
			
			Scanner sc = new Scanner(System.in);
			while(true){
				System.out.println("�ͻ���˵:");
				pw.println(sc.next());
				String response = br.readLine();
				System.out.println("�������Ӧ:"+response);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
