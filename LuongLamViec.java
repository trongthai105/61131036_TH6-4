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
					GuiFile("D:\\HK6\\Lap trinh mang\\TH 6.4\\1.txt");
					buffWrite.flush();
				}else if(chuoiNhan.equals("2")) {
					GuiFile("D:\\HK6\\Lap trinh mang\\TH 6.4\\2.txt");
					buffWrite.flush();
				}else if(chuoiNhan.equals("3")) {
					GuiFile("D:\\HK6\\Lap trinh mang\\TH 6.4\\3.txt");
					buffWrite.flush();
				}else if(chuoiNhan.equals("4")) {
					GuiFile("D:\\HK6\\Lap trinh mang\\TH 6.4\\4.txt");
					buffWrite.flush();
				}else if(chuoiNhan.equals("5")) {
					GuiFile("D:\\HK6\\Lap trinh mang\\TH 6.4\\5.txt");
					buffWrite.flush();
				}else if(chuoiNhan.equals("6")) {
					GuiFile("D:\\HK6\\Lap trinh mang\\TH 6.4\\6.txt");
					buffWrite.flush();
				}else if(chuoiNhan.equals("7")) {
					GuiFile("D:\\HK6\\Lap trinh mang\\TH 6.4\\7.txt");
					buffWrite.flush();
				}else if(chuoiNhan.equals("8")) {
					GuiFile("D:\\HK6\\Lap trinh mang\\TH 6.4\\8.txt");
					buffWrite.flush();
				}else if(chuoiNhan.equals("9")) {
					GuiFile("D:\\HK6\\Lap trinh mang\\TH 6.4\\9.txt");
					buffWrite.flush();
				}else if(chuoiNhan.equals("10")) {
					GuiFile("D:\\HK6\\Lap trinh mang\\TH 6.4\\10.txt");
					buffWrite.flush();
				}else if(chuoiNhan.equals("0")) {
					buffWrite.write("Kết thúc"+"\n");
					buffWrite.flush();
					break;
				}
				
			}				

		} catch (Exception e) {
			// TODO: handle exception
			System.err.println(e.getMessage());
		}
		
	}
	
}