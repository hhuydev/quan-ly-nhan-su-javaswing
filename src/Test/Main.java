/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Test;

import UI.LoginFrame;

public class Main {

	public static LoginFrame frmLogin;// static vaiable to call later

	/**
	 * @param args the command line arguments
	 */

	public static void main(String[] args) {

		frmLogin = new LoginFrame();
		frmLogin.setVisible(true);
	}

}
