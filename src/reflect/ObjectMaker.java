package reflect;
import java.io.Serializable;

@SuppressWarnings("serial")
public class ObjectMaker implements Serializable {
	
	boolean boolPrimitive = true;
	int intPrimitive = 3;
	char charPrimitive = 'P';
	float floatPrimitive = 1.6f;
	float refFloat = 6.0f;
	
	ObjectMakerRef makeRef = new ObjectMakerRef(refFloat);
	char[] array = {'1','3','5','7','9'};
	
	ObjectMakerRef[] makeRefArray = new ObjectMakerRef[3];
	
	
	public ObjectMaker() {
		makeRefArray[0] = new ObjectMakerRef(0.01f);
		makeRefArray[1] = new ObjectMakerRef(0.02f);
		makeRefArray[2] = new ObjectMakerRef(0.03f);
	}
	
	
	
	public void setarray(char[] array) {
		this.array = array;
	}
	
	public void setreffloat( float reffloat) {
		this.refFloat = reffloat;
	}
	
	
	public void setboolprimitive(boolean boolprimitive) {
		this.boolPrimitive = boolprimitive;
	}

	public void setintprimitive(int intprimitive) {
		this.intPrimitive = intprimitive;
	}
	
	public void setcharprimitive(char charprimitive) {
		this.charPrimitive = charprimitive;
	}
	
	public void setfloatprimitive(float floatprimitive) {
		this.floatPrimitive = floatprimitive;
	}
	
	public boolean getboolprimitive() {
		return boolPrimitive;
	}
	
	public int getintprimitive() {
		return intPrimitive;
	}
	
	public char getcharprimitive() {
		return charPrimitive;
	}
	
	public float getfloatprimitive() {
		return floatPrimitive;
	}
	
	
}
