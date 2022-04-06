import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class CTChinh {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		ServerSocket socketServer = new ServerSocket(9999);
		System.out.print("I'm listening ... \n");
		
		int id = 0;
		while (true) {
		   Socket s = socketServer.accept();
		   id ++; 
		   //new LuongLamViec(s, id++).start();
		   LuongLamViec luongTask = new LuongLamViec(s, id);
		   luongTask.start();
		
		}

	}
}
