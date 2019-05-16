package livestockfactory;


public class DairyFactory extends CattleFoodFactory{
	
	public FoodProduct createProduct(String productname){
			if(productname.equals("Carbon")){
				return new Corn (15.00);
			}
			if(productname.equals("Protein")){
				return new Soybean(23.00);
			}
			else return null;
		
	}


}
