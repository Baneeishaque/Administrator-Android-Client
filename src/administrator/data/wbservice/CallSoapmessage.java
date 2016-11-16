package administrator.data.wbservice;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import android.androidVNC.Connect;

public class CallSoapmessage {
	public final String SOAP_ACTION = "http://tempuri.org/Message";

	public final String OPERATION_NAME = "Message";

	public final String WSDL_TARGET_NAMESPACE = "http://tempuri.org/";

	public final String SOAP_ADDRESS = "http://" + Connect.ip + "/administrator/WebService.asmx";

	public CallSoapmessage() {

	}

	public String Call(String subject, String message) {

		SoapObject request = new SoapObject(WSDL_TARGET_NAMESPACE, OPERATION_NAME);

		PropertyInfo pi = new PropertyInfo();
		pi.setName("subject");
		pi.setValue(subject);
		pi.setType(String.class);
		request.addProperty(pi);

		pi = new PropertyInfo();
		pi.setName("message");
		pi.setValue(message);
		pi.setType(String.class);
		request.addProperty(pi);

		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
		envelope.dotNet = true;

		envelope.setOutputSoapObject(request);

		HttpTransportSE httpTransport = new HttpTransportSE(SOAP_ADDRESS);
		Object response = null;
		try

		{

			httpTransport.call(SOAP_ACTION, envelope);

			response = envelope.getResponse();

		}

		catch (Exception exception)

		{

			response = exception.toString() + " transport error";

		}

		return response.toString();
	}

}
