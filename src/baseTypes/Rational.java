package baseTypes;
import java.math.BigInteger;

public class Rational {
	private BigInteger enumerator;
	private BigInteger denominator;
	public Rational(BigInteger enumerator, BigInteger denominator){
		this.enumerator = enumerator;
		this.denominator = denominator;
	}
/**
 * Several constructors 
 */
	public Rational(Integer enumerator, Integer denominator){
		this(new BigInteger(enumerator.toString()),new BigInteger(denominator.toString()));
	}
	public Rational(Long enumerator, Long denominator){
		this(new BigInteger(enumerator.toString()),new BigInteger(denominator.toString()));
	}
	public Rational(Integer x){
		this(Integer.toUnsignedLong(x),Integer.toUnsignedLong(1));
	}
/**
 * Creates a rational from a string which must be of the form enum/denom with enum, denom successfully convertible to a BigInteger via BigInteger's constructor	
 */
	public Rational(String s) throws NumberFormatException{
		if(s==null) s = "0/1";  // Default 
		String[] decomp = s.split("/");
		if(!(decomp.length==2)) throw new NumberFormatException(s + " is no a valid Rational representation!");
		this.enumerator = new BigInteger(decomp[0]);
		this.denominator = new BigInteger(decomp[1]);
	}
	
	public BigInteger getEnumerator() {
		return this.enumerator;
	}
	public BigInteger getDenominator() {
		return this.denominator;
	}
/**
 * Kürzen!	
 */
	public void cancelDown(){
		BigInteger gcd = this.enumerator.gcd(this.denominator);
		this.enumerator = this.enumerator.divide(gcd);
		this.denominator = this.denominator.divide(gcd);
	}
	
	public String toString(){
		return this.enumerator + "/" + this.denominator;
	}
	public boolean equals(Object o){
		if(!o.getClass().equals(this.getClass())) return false;
		Rational other = (Rational)o;
		return this.enumerator.multiply(other.denominator).equals(this.denominator.multiply(other.enumerator));
	}
	public String representAsFloat(){
		return "Not implemented yet";
	}
	
// ============== Private part ===================== //	
	private Rational getReciprocalValue(){
		return new Rational(this.denominator, this.enumerator);
	}
/*==================== Static area (for binary operations) ================== */
	public static Rational add(Rational x, Rational y){
		Rational r = new Rational(x.enumerator.multiply(y.denominator).add(x.denominator.multiply(y.enumerator)), x.denominator.multiply(y.denominator));
		r.cancelDown();
		return r;
	}
	public static Rational sub(Rational x, Rational y){    // x - y !
		return Rational.add(x, Rational.mult(new Rational(-1), y));
	}
	
	public static Rational mult(Rational x, Rational y){
		Rational r = new Rational(x.enumerator.multiply(y.enumerator), x.denominator.multiply(y.denominator));
		r.cancelDown();
		return r;
	}
	public static Rational divide(Rational x, Rational y){
		return mult(x,y.getReciprocalValue());
	}
}
