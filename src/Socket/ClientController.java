package Socket;


public class ClientController {
	private ClinetThread client = null;
	
	@SuppressWarnings("deprecation")
	public boolean sentMessage(String ipAddress, int port, String message) {
		try {
			this.client = new ClinetThread(ipAddress, port, message);
			this.client.start();
			this.client.stop();
			if (this.client.getServerMessage().equals("Check")) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
	}
}
