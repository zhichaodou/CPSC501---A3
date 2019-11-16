package reflect;
import java.io.Serializable;

@SuppressWarnings("serial")
public class ObjectMaker implements Serializable {
	
	boolean boolprimitive = true;
	int intprimitive = 3;
	char charprimitive = 'P';
	float floatprimitive = 1.6f;
	float reffloat = 6.0f;
	
	ObjectMakerRef makeRef = new ObjectMakerRef(reffloat);
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
		this.reffloat = reffloat;
	}
	
	
	public void setboolprimitive(boolean boolprimitive) {
		this.boolprimitive = boolprimitive;
	}

	public void setintprimitive(int intprimitive) {
		this.intprimitive = intprimitive;
	}
	
	public void setcharprimitive(char charprimitive) {
		this.charprimitive = charprimitive;
	}
	
	public void setfloatprimitive(float floatprimitive) {
		this.floatprimitive = floatprimitive;
	}
	
	public boolean getboolprimitive() {
		return boolprimitive;
	}
	
	public int getintprimitive() {
		return intprimitive;
	}
	
	public char getcharprimitive() {
		return charprimitive;
	}
	
	public float getfloatprimitive() {
		return floatprimitive;
	}
	
	
}
