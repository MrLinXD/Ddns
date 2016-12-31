package exceptions;
/**
 * 
 * @author Axoford12
 *
 */

public class InvalidMethodNameException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Construction.
	public InvalidMethodNameException(String msg){
		super(msg);
		// super with message
	}
	
}
