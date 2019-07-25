package bio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class TimeServer {
	public static void main(String[] args) throws IOException {
		// 绑定接口(监听一个端口)
		ServerSocket server = new ServerSocket(9999);
		System.out.println("服务端创建....");
		// 监听客户端连接
		Socket socket = server.accept();
		System.out.println("客户端连接到服务端....");
		InputStream in = socket.getInputStream();
		
		// 装饰器模式
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		String str =null;
		while((str=br.readLine())!=null) {
			System.out.println(str);
			
		}
		
	}
}
