package myThreadbio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerThread2 extends Thread{
	Socket socket;

	public ServerThread2(Socket socket) {
		super();
		this.socket = socket;
	}

	@Override
	public void run() {
		InputStream is = null;
		OutputStream os = null;
		BufferedReader br = null;
		PrintWriter pw = null;
		String getMsg=null;
		String sendMsg = null;
		try {
			is = socket.getInputStream();
			os = socket.getOutputStream();
			br = new BufferedReader(new InputStreamReader(is));
			pw = new PrintWriter(os,true);
		} catch (IOException e) {
			e.printStackTrace();
		}
		while(true) {
			try {
				getMsg = br.readLine();
				System.out.println("Client------>"+getMsg);
				sendMsg = "response Clinet"+socket.getPort()+getMsg;
				pw.println(sendMsg);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
	}
	
	
	
	
	
}
