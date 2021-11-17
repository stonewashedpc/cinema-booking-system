package mdeGen.commands;

import mdeGen.observation.Observable;
/**
 * A command targeted at an object of type @param <T> and returning a value of type @param <R>
 */
public abstract class ObjectCommand<T extends Observable, R> extends Command<R>{
	protected T receiver;
	public ObjectCommand(T receiver) {this.receiver = receiver;}
	public T getReceiver() {return receiver;}
}
