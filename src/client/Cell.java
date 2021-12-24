package client;

public abstract class Cell<T> {
	
	protected final T object;
	
	public Cell(T object) {
		this.object = object;
	}
	
	public T getObject() {
		return object;
	}

	public abstract Cell<T> initialize(Client client) throws Exception;
}