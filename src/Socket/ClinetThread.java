package Socket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetSocketAddress;
import java.net.Socket;

public class ClinetThread extends Thread {
	
	private String serverReturn = null;

	public ClinetThread(String ipAdderss, int port, String message) {
		Socket socket = new Socket();
		InetSocketAddress isa = new InetSocketAddress(ipAdderss, port);
		try {
			socket.connect(isa, 10000);
			PrintStream writer = new PrintStream(socket.getOutputStream());
			writer.println(message);
			writer.flush();
			BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			this.serverReturn = reader.readLine();
			socket.close();
			socket = null;
		} catch (Exception e) {
			System.err.println("Socket contacting was fail.");
			System.err.println(e.getMessage());
		}
	}
	
	public String getServerMessage() {
		return this.serverReturn;
	}
}
