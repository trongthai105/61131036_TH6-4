import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class Thai {
	public static void main(String[] args) {
		try {
			
			Socket socket = new Socket("localhost",9999);
			System.out.print("Đã kết nối");
			InputStream in = socket.getInputStream();
			InputStreamReader inReader = new InputStreamReader(in);
			BufferedReader buffRead = new BufferedReader(inReader);
			OutputStream osToClient = socket.getOutputStream();	
			OutputStreamWriter writetoClient = new OutputStreamWriter(osToClient);
			BufferedWriter buffWrite = new BufferedWriter(writetoClient);
			Scanner banPhim = new Scanner(System.in);
			while(true) {
				System.out.print("\nClient:");
				String chuoiGui = banPhim.nextLine();
				buffWrite.write(chuoiGui+"\n");
				buffWrite.flush();
				String chuoiNhan = buffRead.readLine();
				System.out.print("Server: "+ chuoiNhan);
				if(chuoiGui.equals("Bye")) break;
			}
			socket.close();			
		}catch(Exception e) {
			System.out.print(e.getMessage());
		}
	}

}