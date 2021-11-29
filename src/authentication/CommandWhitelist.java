package authentication;

import java.util.HashSet;
import java.util.Set;

import commands.Command;

public abstract class CommandWhitelist {
	
	private Set<Class<?>> whiteList;
	
	public CommandWhitelist() {
		this.setWhiteList(new HashSet<Class<?>>());
	}

	public Set<Class<?>> getWhiteList() {
		return whiteList;
	}

	public void setWhiteList(Set<Class<?>> whiteList) {
		this.whiteList = whiteList;
	}
	
	public boolean isWhitelisted(Class<? extends Command> class1) {
		return this.whiteList.contains(class1);
	}
	
	public void includeWhiteList(CommandWhitelist whitelist) {
		this.whiteList.addAll(whitelist.getWhiteList());
	}
}
