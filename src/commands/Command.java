package commands;
import java.io.Serializable;
/**
 * An arbitrary command to call an operation, which returns a value of type R or an exception
 * @param <R>
 */
public abstract class Command<R> implements Serializable{
	protected R result;
	protected Exception e;
	protected String authToken;
	public abstract void execute();
	public R getResult() throws Exception{
		if(this.e!=null) throw e;
		return this.result;
	}
	
/** Auxiliary method to simplify command execution and result retrieval */
	public static <R,C extends Command<R>> R execute(C c) throws Exception{
		c.execute();
		return c.getResult();
	}
	public void setE(Exception e) {
		this.e = e;
	}
	public String getAuthToken() {
		return authToken;
	}
	public void setAuthToken(String authToken) {
		this.authToken = authToken;
	}
}
