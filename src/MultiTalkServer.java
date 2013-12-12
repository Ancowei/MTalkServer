import java.net.ServerSocket;
import java.net.Socket;


public class MultiTalkServer {
	public static void main(String[] args) {
		try{
			ServerSocket server=new ServerSocket(2000);
			System.out.println("waiting.....");
			Socket socket;
			while(true){
				socket = server.accept();
				new ServerSocketThread(socket);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
