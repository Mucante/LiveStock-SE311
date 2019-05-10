package dairyfactory;

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

}
