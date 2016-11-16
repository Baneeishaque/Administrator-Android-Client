package administrator.data.wbservice;

import administrator.ui.pc.Power;

public class Callerpower extends Thread {

	public CallSoappower cs;
	public String action;

	public void run() {
		try {
			cs = new CallSoappower();
			String resp = cs.Call(action);
			Power.rslt = resp;
		} catch (Exception ex) {
			Power.rslt = ex.toString();
		}

	}
}
