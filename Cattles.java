package dairyvisitor;

import java.util.ArrayList;

import dairyfactory.Cattle;

//OBJECT STRUCTURE (CATTLES)
public class Cattles {
	public void Add(Cattle cattle){ cattles.add(cattle);};
	public void Remove(Cattle employee) {
		for (int i = 0; i< cattles.size(); i++) {
			if (cattles.get(i).getName() == employee.getName()) {
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
