package dairyfactory;

public class Canola extends Protein{
	double price;
	public Canola(double p){
		price = p;
		System.out.println("\t Canola is produced...");
	}
	public String displayName() { return new String("Canola"); }
	public double getPrice(){ return price; }

}