package studio9;

import java.util.LinkedList;

public class Polynomial {
	//commands under List to know for test: add, find specific item, index, remove
	private LinkedList<Double> list;

	/**
	 * Constructs a Polynomial with no terms yet.
	 */
	public Polynomial() {
		list = new LinkedList<Double>();
		//LinkedList list = new LinkedList ();
	}

	
	/**
	 * 
	 * @param coeff
	 * @return polynomial with added term
	 */
	public void addTerm(double coeff) {
		list.add(coeff);
	}
	
	/*
	 * Returns a String of the polynomial with the proper form:
	 * 
	 * Cx^N + Cx^N-1 + ... + Cx + C
	 */
	public String toString() {
		int len = list.size();
		String x = "";
		for (int i=0;i<len;i++) {
			x+=list.get(i)+"x^";
			int pow=len-1-i;
			x+=pow;
			
			if (i+1<len) {
				if(list.get(i+1)>=0) {
					x+="+";
				}
			}
		}
		//System.out.println(x);
		return x; 
	}
	
	/**
	 * 
	 * @param x
	 * @return value of polynomial at that x
	 */
	public double evaluate(double x) {
		int len = list.size();
		double y = 0;
		for (int i=0;i<len;i++) {
			int pow=len-1-i;
			double coef = list.get(i);
			double answ = Math.pow(x, pow);
			y+=answ*coef;
		}
		//System.out.println(y);
		return y;
	}

	
	public Polynomial derivative() {
		return null;//FIXME
	}
	

	/**
	 * This is the "equals" method that is called by
	 *    assertEquals(...) from your JUnit test code.
	 *    It must be prepared to compare this Polynomial
	 *    with any other kind of Object (obj).  Eclipse
	 *    automatically generated the code for this method,
	 *    after I told it to use the contained list as the basis
	 *    of equality testing.  I have annotated the code to show
	 *    what is going on.
	 */

	public boolean equals(Object obj) {
		// If the two objects are exactly the same object,
		//    we are required to return true.  The == operator
		//    tests whether they are exactly the same object.
		if (this == obj)
			return true;
		// "this" object cannot be null (or we would have
		//    experienced a null-pointer exception by now), but
		//    obj can be null.  We are required to say the two
		//    objects are not the same if obj is null.
		if (obj == null)
			return false;

		//  The two objects must be Polynomials (or better) to
		//     allow meaningful comparison.
		if (!(obj instanceof Polynomial))
			return false;

		// View the obj reference now as the Polynomial we know
		//   it to be.  This works even if obj is a BetterPolynomial.
		Polynomial other = (Polynomial) obj;

		//
		// If we get here, we have two Polynomial objects,
		//   this and other,
		//   and neither is null.  Eclipse generated code
		//   to make sure that the Polynomial's list references
		//   are non-null, but we can prove they are not null
		//   because the constructor sets them to some object.
		//   I cleaned up that code to make this read better.


		// A LinkedList object is programmed to compare itself
		//   against any other LinkedList object by checking
		//   that the elements in each list agree.

		return this.list.equals(other.list);
	}
	
	public static void main(String[] args) {
		Polynomial test = new Polynomial();
		test.addTerm(1);
		test.addTerm(0);
		test.addTerm(-4);
		test.toString();
		test.evaluate(1); 
	}

}