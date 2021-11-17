package relationManagement;
/**
 * An element of a binary relation (which maybe n-ary if T is (n-1)-ary)
 * @param <S> the first projection 
 * @param <T> the second projection
 */
public class RelElement<S,T> {
	private final S p1;
	private final T p2;
	public RelElement(S p1, T p2) {
		this.p1 = p1;
		this.p2 = p2;
	}
	public S getFirstProjection() {
		return this.p1;
	}
	public T getSecondProjection() {
		return this.p2;
	}	
}
