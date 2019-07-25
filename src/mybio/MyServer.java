package mybio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class MyServer {

	public static void main(String[] args) throws UnknownHostException, IOException {
		//绑定一个端口
		ServerSocket server = new ServerSocket(9999);
		String str=null;
		//对服务器连接进行监听 放在循环内 保持监听状态
		Socket socket = server.accept();
		// 获取到连接信息
		System.out.println(socket.getPort()+"建立连接----->");
		InputStream in = socket.getInputStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		OutputStream out = socket.getOutputStream();
		PrintWriter pw = new PrintWriter(out, true);
		Scanner sc = new Scanner(System.in);
		while(true) {
			str=br.readLine();
			System.out.println("客户端:"+str);
			String resp = "客户端回复:----> "+sc.next();
			pw.println(resp);
//			br.close();
		}
	}
}
