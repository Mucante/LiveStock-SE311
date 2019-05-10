package dairyfactory;

public class Wheat extends Carbon {
	double price;
	public Wheat(double p){
		price = p;
		System.out.println("\t Wheat is produced...");
	}
	public String displayName() { return new String("Wheat"); }
	public double getPrice(){ return price; }


}
