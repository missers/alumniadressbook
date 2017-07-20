package team.aab.util;

/**
 * 自定义异常类
 * @author user
 *
 */
public class UserException extends Exception{

	public UserException() {
		super();
	
	}

	public UserException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		
	}

	public UserException(String arg0) {
		super(arg0);
		
	}

	public UserException(Throwable arg0) {
		super(arg0);
	
	}
     
}
