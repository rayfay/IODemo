package mybio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class MyClient {
	
	public static void main(String[] args) throws UnknownHostException, IOException {
		Scanner sc = new Scanner(System.in);
		Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
		PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);
		BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		while(true) {
			String str = sc.next();
			if("88".equals(str))
				break;
			// 把输入内容发送到服务端
			pw.println(str);
			String resp= br.readLine();
			System.out.println("Server------>:"+resp);
		}
		
	}

}
