package livestockfactory;

public class Soybean extends Protein {
	double price;

	public Soybean(double p) {
		price = p;
		System.out.println("\t Soybean is produced...");
	}

	public String displayName() {
		return new String("Soybean");
	}

	public double getPrice() {
		return price;
	}
}
