package livestockvisitor;

import java.util.ArrayList;

//OBJECT STRUCTURE (CATTLES)

public class Cattles {
	public void Add(Cattle cattle){ cattles.add(cattle);}
	
	public void Remove(Cattle cat) {
		for (int i = 0; i< cattles.size(); i++) {
			if (cattles.get(i).getName() == cat.getName()) {
				cattles.remove(i);
				return;
			}
		}
	}
	public void Accept(Visitor visitor) {
		// set argument to something that helps
		// tell the Observers what happened
		for (int i = 0; i < cattles.size(); i++) {
			cattles.get(i).Accept(visitor);		}
	}
	private ArrayList<Cattle> cattles = new ArrayList<Cattle>();
};