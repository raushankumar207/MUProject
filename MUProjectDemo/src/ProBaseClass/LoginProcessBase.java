/**
 * 
 */
package ProBaseClass;

/**
 * @author Raushan
 *
 */
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;

public abstract class LoginProcessBase {

	/**
	 * @param args
	 */
	protected String UserName;
	protected String UserPassword;
	protected String SecuriyQuestion;
	protected String QuestionAnswer;
	protected PreparedStatement ps;
	protected ResultSet rs;
	protected Connection con;
}
