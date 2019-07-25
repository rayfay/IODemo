package bio;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class TimeClient {
	public static void main(String[] args) throws UnknownHostException, IOException {
		// 创建客户端对象连接服务端
		Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
		// 获取输出流 写数据到服务端
		String str="hello";
		OutputStream out = socket.getOutputStream();
		System.out.println("客户端说:"+str);
		out.write(str.getBytes());
		out.close();
	}
}
