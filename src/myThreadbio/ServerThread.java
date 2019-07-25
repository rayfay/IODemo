package myThreadbio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerThread extends Thread {
	ServerSocket server;
	Socket socket;
	BufferedReader br;
	PrintWriter pw;
	@Override
	public void run() {
		try {
			this.getMsg();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void getMsg() throws IOException {
		
		while(true) {
			//监听端口
			socket = server.accept();
			System.out.println(socket.getPort()+"-------> 接入成功!");
			InputStream in = socket.getInputStream();
			br = new BufferedReader(new InputStreamReader(in));
			OutputStream out = socket.getOutputStream();
			pw = new PrintWriter(new OutputStreamWriter(out));
			String msg=null;
			msg = br.readLine();
			pw.println("server:---->hello");
			if(msg!=null) {
				System.out.println(socket.getPort()+"发来消息------->:\n"+msg);
			}
			System.out.println("发送消息");
				
		}
		
	}
	
	public void sendMsg(Socket s) throws IOException {
		
		System.out.println("请输入要发送消息");
		OutputStream out = s.getOutputStream();
		pw = new PrintWriter(new OutputStreamWriter(out));
//		br = new BufferedReader(new InputStreamReader(System.in)); 
		String msg="hello";
		if(msg!=null) {
			System.out.println("Client----->:"+msg);
			pw.println(msg);
		}
		
		
	}

	public ServerThread() throws IOException {
		// 创建后就初始化 server,绑定端口
		server=new ServerSocket(9999);
	}
	

	public static void main(String[] args) throws IOException {
		ServerThread st =new ServerThread();
		st.start();
	}
}
