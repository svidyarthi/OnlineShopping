package webServices;

import java.io.InputStream;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;

import org.apache.log4j.Logger;

import com.paypal.core.rest.OAuthTokenCredential;
import com.paypal.core.rest.PayPalRESTException;
import com.paypal.core.rest.PayPalResource;

public class PayService {
	
		private static final long serialVersionUID = 1L;

		private static final Logger LOGGER = Logger
				.getLogger(PayService.class);

		public void init(ServletConfig servletConfig) throws ServletException {
			// ##Load Configuration
			// Load SDK configuration for
			// the resource. This intialization code can be
			// done as Init Servlet.
			InputStream is = PayService.class
					.getResourceAsStream("/sdk_config.properties");
			try {
				PayPalResource.initConfig(is);
			} catch (PayPalRESTException e) {
				LOGGER.fatal(e.getMessage());
			}
}
		
	public String getToken(){
		String accessToken="";
			try {
				OAuthTokenCredential tokenCredential = new OAuthTokenCredential("AWfvkRASRPuweNvnBCrU5pNn9VMOEK5s5Bj6cbtmlZepTB1QJy2zk7EIaoXU", "EH9oJRD3BqIdcXrNAgIsZsB_lmwxSF0cttykkzyCyuolZDX5rlf3YG4sno-L");
				 accessToken = tokenCredential.getAccessToken();
				System.out.println(accessToken);
				
			} catch (PayPalRESTException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
			return accessToken;
	}
	
	public static void main(String args[]){
		PayService p = new PayService();
		p.getToken();
	}
}
