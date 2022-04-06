import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class LuongLamViec extends Thread{
	Socket socketClient;
	int id;
	
	public LuongLamViec(Socket socketClient, int id) {
		super();
		this.socketClient = socketClient;
		this.id = id;
	}
	void GuiFile(String tenFile)throws IOException{
		FileReader FileReader = new FileReader(tenFile);
		BufferedReader buffR = new BufferedReader(FileReader);
		OutputStream osToClient = socketClient.getOutputStream();
		OutputStreamWriter write2client = new OutputStreamWriter(osToClient);
		BufferedWriter buffW = new BufferedWriter(write2client);
		String line;
		while((line=buffR.readLine()) != null) {
			buffW.write(line);
			buffW.flush();
		}
		FileReader.close();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.print(socketClient.getInetAddress().getHostAddress());
		System.out.print(id); 
		System.out.print("\n");
		try {
			OutputStream osToClient = socketClient.getOutputStream();
			OutputStreamWriter writetoClient = new OutputStreamWriter(osToClient);
			BufferedWriter buffWrite = new BufferedWriter(writetoClient);
			
			InputStream in = socketClient.getInputStream();
			InputStreamReader inReader = new InputStreamReader(in);
			BufferedReader buffRead = new BufferedReader(inReader);
			
			while (true) {
				//Nhan du lieu
				String chuoiNhan = buffRead.readLine();
				System.out.print("\n"+chuoiNhan);
				
				if(chuoiNhan.equals("1")) {
					GuiFile("D:\HK6\Lap trinh mang\TH 6.4\1.txt");
				}
				
			}				

		} catch (Exception e) {
			// TODO: handle exception
			System.err.println(e.getMessage());
		}
		
	}
	
}