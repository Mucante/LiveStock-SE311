package dairyfactory;

public class Corn extends Carbon{
	double price;
	public Corn(double p){
		price = p;
		System.out.println("\t Corn is produced...");
	}
	public String displayName() { return new String("Corn"); }
	public double getPrice(){ return price; }


}
