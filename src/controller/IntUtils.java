/**
 * 
 */
package controller;

import java.time.LocalDate;

/**
 * @author gauthierbohyn
 *
 */
public interface IntUtils {

	/**
	 * 
	 * @return the current date
	 */
	public LocalDate GetDate();
	
	/**
	 * 
	 * @param str
	 * @return boolean if the variable is numeric
	 */
	public  boolean isNumeric(String str);
	
}
