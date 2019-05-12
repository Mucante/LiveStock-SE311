package dairyfactory;
import dairyvisitor.*;

public class BeefCattle extends Cattle {
	
	public FoodProduct createProduct(String productname){
		if(productname.equals("Carbon")){
			return new Wheat (18.00);
		}
		if(productname.equals("Protein")){
			return new Canola(45.00);
		}
		else return null;

}
	public BeefCattle() {} //non-parameterized Constructor
	
	//CONSTRUCTOR
	public BeefCattle(String name,int id, Boolean vaccinationState, Boolean earTag) {
		super(name,id,vaccinationState,earTag);
		
	}
	
	public void Accept(Visitor visitor) {
		visitor.Visit(this);
		}
}