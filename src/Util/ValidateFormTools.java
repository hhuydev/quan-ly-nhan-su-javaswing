/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class ValidateFormTools {

	public static boolean isFilledTextField(JTextField textfield, boolean trim) {
		if (trim) {
			textfield.setText(textfield.getText().trim());
		}
		String input = textfield.getText();
		return (input.compareTo("") != 0);
	}

	public static boolean isSamePassword(JPasswordField p1, JPasswordField p2) {
		String pass1 = new String(p1.getPassword());
		String pass2 = new String(p2.getPassword());

		return (pass1.compareTo(pass2) == 0);
	}

	public static Integer isInteger(String string) {
		try {
			return new Integer(string);
		} catch (NumberFormatException ex) {
			return null;
		}
	}

	public static Double isDouble(String string) {
		try {
			return new Double(string);
		} catch (NumberFormatException ex) {
			return null;
		}
	}
}
