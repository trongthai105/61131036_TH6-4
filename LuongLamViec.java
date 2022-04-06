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
	void guifile(String tenFile)throws IOException{
		FileReader fr = new FileReader(tenFile);
		BufferedReader buffR = new BufferedReader(fr);
		OutputStream osToClient = socketClient.getOutputStream();
		OutputStreamWriter write2client = new OutputStreamWriter(osToClient);
		BufferedWriter buffW = new BufferedWriter(write2client);
		String line;
		while((line=buffR.readLine()) != null) {
			buffW.write(line);
			buffW.flush();
		}
		fr.close();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.print(socketClient.getInetAddress().getHostAddress());
		System.out.print(id); 
		System.out.print("\n");
		try {
			OutputStream osToClient = socketClient.getOutputStream();
			OutputStreamWriter write2Client = new OutputStreamWriter(osToClient);
			BufferedWriter buffWrite = new BufferedWriter(write2Client);
			
			InputStream in = socketClient.getInputStream();
			InputStreamReader inReader = new InputStreamReader(in);
			BufferedReader buffRead = new BufferedReader(inReader);
			
			while (true) {
				//Nhan du lieu
				String chuoiNhan = buffRead.readLine();
				
				if(chuoiNhan.equals("1")) {
					guifile("D:\\1.txt");
				}
				
			}				

		} catch (Exception e) {
			// TODO: handle exception
			System.err.println(e.getMessage());
		}
		
	}
	
}