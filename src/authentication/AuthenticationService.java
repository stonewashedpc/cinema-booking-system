package authentication;

import java.security.SecureRandom;
import java.util.Base64;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

import generated.cinemaService.AuthenticationException;
import generated.cinemaService.CinemaService;
import generated.cinemaService.Role;
import generated.cinemaService.User;

public class AuthenticationService {
	
	private static AuthenticationService instance;
	private final HashMap<String, Session> authMap;
	private static final int AUTHTOKEN_EXPIRY_TIME_HOURS = 1;
	private static final int AUTHTOKEN_LENGTH_BYTES = 64;
	
	private AuthenticationService() {
		this.authMap = new HashMap<String, Session>();
	}
	
	public static AuthenticationService getInstance() {
		if(instance == null) instance = new AuthenticationService();
		return instance;
	}
	
	public String loginUser(String username, String password) throws AuthenticationException {
		User user = CinemaService.getInstance().getUserByUsername(username);
		if(user != null) {
			if (user.getPassword().checkPassword(password)) {
				String authToken = generateAuthToken();
				this.authMap.put(authToken, new Session(user, getExpiryDate()));
				return authToken;
			} else throw new AuthenticationException("Invalid password");
		} else throw new AuthenticationException("Username does not exist");
	}
	
	public void logoutUser(String authToken) throws AuthenticationException {
		if(this.authMap.containsKey(authToken)) {
			this.authMap.remove(authToken);
		} else throw new AuthenticationException("Logout failed");
	}
	
	private String generateAuthToken() {
		byte[] randomBytes = new byte[AUTHTOKEN_LENGTH_BYTES];
		SecureRandom sr = new SecureRandom();
		sr.nextBytes(randomBytes);
		return Base64.getEncoder().encodeToString(randomBytes);
	}
	
	private Date getExpiryDate() {
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		c.add(Calendar.HOUR_OF_DAY, AUTHTOKEN_EXPIRY_TIME_HOURS);
		return c.getTime();
	}
	
	public Role findRole(String authToken) throws AuthenticationException {
		Session session = this.authMap.get(authToken);
		if (session == null) throw new AuthenticationException("Invalid Authentication Token");
		if (session.hasExpired()) throw new AuthenticationException("Session key has expired");
		return session.getUser().getRole();
	}
}
