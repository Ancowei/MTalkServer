import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;


public class ServerSocketThread extends Thread{
	private Socket socket;
	private DataInputStream din;
	private DataOutputStream dout;
	public ServerSocketThread(Socket s) throws IOException{
		socket=s;
		din=new DataInputStream(socket.getInputStream());
		dout=new DataOutputStream(socket.getOutputStream());
		start();
	}
	public void run(){
		String str;
		try{
			System.out.println("链接成功");
			System.out.println(".....................");
			System.out.println("等待用户信息");
			while(true){
				BufferedReader sin=new BufferedReader(new InputStreamReader(System.in));
				str=din.readUTF();
				System.out.println("从客户端的信息为："+str);
				if(str.trim().equals("bye")) break;
				System.out.println("input your message:");
				str=sin.readLine();
				dout.writeUTF(str);
				dout.flush();
				if(str.trim().equals("bye"))break;
			}
			din.close();
			dout.close();
			socket.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

}
