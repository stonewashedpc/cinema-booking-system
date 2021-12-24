package client.controllers;

public abstract class Controller<M, V> {
	
	protected M model;
	protected V view;
	
	public Controller(M model, V view) {
		this.model = model;
		this.view = view;
		init();
	}

	protected abstract void init();
}
