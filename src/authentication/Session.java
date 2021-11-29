package authentication;

import java.util.Date;

import generated.cinemaService.User;

public class Session {
	private final User user;
	private final Date expiryDate;
	
	public Session(User user, Date expiryDate) {
		this.user = user;
		this.expiryDate = expiryDate;
	}

	public User getUser() {
		return user;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}
	
	public boolean hasExpired() {
		return new Date().after(expiryDate);
	}
}
