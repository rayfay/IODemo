package myThreadbio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[] args) throws IOException {
		ServerSocket server = new ServerSocket(9999);
		System.out.println(Runtime.getRuntime().getRuntime().availableProcessors());
		ServerThreadPool pool = new ServerThreadPool(13,5);
		while(true) {
			Socket socket = server.accept();
			System.out.println(socket.getPort()+"connect to Server");
//			new ServerThread2(socket).start();
			pool.execute(new ServerThread2(socket));
		}
		
	}
}
