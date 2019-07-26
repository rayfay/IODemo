package tbio2;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TimeServer {

	public static void main(String[] args) {
		ServerSocket server = null;
		try {
			server = new ServerSocket(9999);
			MyThreadPool pool = new MyThreadPool(10, 5);
			while(true){
				//��������,���ܿͻ��˵�����(����)
				Socket socket = server.accept();
				System.out.println("���յ�:"+socket.getPort()+"������");
//				new Thread(new MyRunnable(socket)).start();
				pool.execute(new MyRunnable(socket));
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
