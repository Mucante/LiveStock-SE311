package dairyvisitor;

import dairyfactory.BeefCattle;
import dairyfactory.DairyCattle;

public class Ministry implements Visitor {

	@Override
	public void Visit(DairyCattle animal) {	
		if(animal.getEarTag()==false) {
			animal.setEarTag(true);
			
			System.out.println("Id " + animal.getId() + " 's ear tag is now: " + animal.getEarTag());
					
		}

	
		
	}

	@Override
	public void Visit(BeefCattle animal) {
		if(animal.getEarTag()==false) {
			animal.setEarTag(true);
			System.out.println("Id "+animal.getId() + " 's ear tag is now: " + animal.getEarTag());
					
		}
	
	
	}

}
