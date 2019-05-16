package livestockfactory;

import java.util.ArrayList;


public class FeedCattle {
	public void producefood(CattleFoodFactory factory) {
		FoodProducts = new ArrayList<FoodProduct>();
		FoodProducts.add(factory.createProduct("Carbon"));
		FoodProducts.add(factory.createProduct("Protein"));
	}
	public void displayProducts() {
		System.out.println("\tListing Food Products \n\t-------------");
		FoodProducts.forEach(p -> System.out.println(p.displayName() +" with price: " + p.getPrice()));
	}
	private ArrayList<FoodProduct> FoodProducts;
}
