package observation;

import java.util.ArrayList;
import java.util.Collection;

import commands.Command;

public abstract class Observable {
	private Collection<Observer> observers;
	public Observable() {this.observers = new ArrayList<>();}
	public void addObserver(Observer o) {this.observers.add(o);}
	public boolean removeObserver(Observer o) {return this.observers.remove(o);}
	public void notifyObservers(Command command) {
		this.observers.forEach(o->o.update(command));
	}
}