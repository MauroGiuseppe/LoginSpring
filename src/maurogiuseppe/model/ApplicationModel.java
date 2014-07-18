package maurogiuseppe.model;

/**
 * This model class is used mainly to send the data into a single object which contains all the details
 * that is needed to be displayed on the jsp pages.
 *  
 * @author mauro
 *
 */

public class ApplicationModel {
	private LoginModel loginModel;

	/**
	 * 
	 * @return
	 */
	public LoginModel getLoginModel() {
		return loginModel;
	}

	/**
	 * 
	 * @param loginModel
	 */
	public void setLoginModel(LoginModel loginModel) {
		this.loginModel = loginModel;
	}
	
	
	
	
	
	

}
