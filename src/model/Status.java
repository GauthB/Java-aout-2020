/**
 * 
 */
package model;

/**
 * @author gauthierbohyn
 *
 */
public class Status {

	 private static String status ;

	/**
	 * @return the status
	 */
	public String getStatus() {
		System.out.println(status);
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		System.out.println(this.status);
		this.status = status;
		System.out.println(status);
	}
	
	
	
	
}
