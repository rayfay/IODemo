package tbio2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class MyRunnable implements Runnable {

	private Socket socket;
	
	public MyRunnable(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		try {
			InputStream is = socket.getInputStream();
			OutputStream out = socket.getOutputStream();
			
			//װ����ģʽ��װis����,������ж�ȡ
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			//�ͻ��˺ͷ���˽��ж�д���������������Է��Ƿ���������뻥��ȴ���״��,ʹ��pw��Ĭ����ӻ���
			PrintWriter pw = new PrintWriter(out,true);
			
			while(true){
				String request = br.readLine();
				if(request == null){
					break;
				}
				System.out.println("client:"+request);
				pw.println("hi");
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
