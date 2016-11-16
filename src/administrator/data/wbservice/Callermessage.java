package administrator.data.wbservice;

import administrator.ui.pc.Notifications;

public class Callermessage extends Thread {

	public CallSoapmessage cs;

	public String subject, message;

	public void run() {
		try {
			cs = new CallSoapmessage();
			String resp = cs.Call(subject, message);
			Notifications.rslt = resp;
		} catch (Exception ex) {
			Notifications.rslt = ex.toString();
		}

	}
}
