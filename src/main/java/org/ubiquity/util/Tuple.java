/**
 * 
 */
package org.ubiquity.util;

/**
 * Utility class, serving as keys for maps
 * @author François LAROCHE
 */
public class Tuple<T, U> {

	public final T tObject;
	public final U uObject;
	private final int hashcode;
	
	public Tuple(T tObject, U uObject) {
//		if(tObject == null || uObject == null) {
//			throw new IllegalStateException("Provided classes musn't be null !");
//		}
		this.tObject = tObject;
		this.uObject = uObject;

		// cache hashcode since class is immutable
        int calculatedHashcode = 0;
        if(this.tObject != null) {
            calculatedHashcode = 31 * (31 * + tObject.hashCode());
        }
        if(this.uObject != null) {
            calculatedHashcode += uObject.hashCode();
        }
		this.hashcode = calculatedHashcode;
	}

	@Override
	public int hashCode() {
		return hashcode;
	}

    @Override
	public boolean equals(Object obj) {
		if (this == obj) {return true;}
		if (obj == null) {return false;}
		if (!(obj instanceof Tuple)) {return false;}
		Tuple<?,?> other = (Tuple<?,?>) obj;
		return this.tObject == other.tObject && this.uObject == other.uObject;
	}
	
}
