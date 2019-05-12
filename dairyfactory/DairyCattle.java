package dairyfactory;

import dairyvisitor.*;

public class DairyCattle extends Cattle {

	public FoodProduct createProduct(String productname) {
		if (productname.equals("Carbon")) {
			return new Corn(15.00);
		}
		if (productname.equals("Protein")) {
			return new Soybean(23.00);
		} else
			return null;

	}
	public DairyCattle() {} //non-parameterized Constructor
	
	//CONSTRUCTOR
	public DairyCattle(String name,int id, Boolean vaccinationState, Boolean earTag) {
		super(name,id,vaccinationState,earTag);
		
	}
	
	public void Accept(Visitor visitor) {
		visitor.Visit(this);
		}

}