package dairyvisitor;

import dairyfactory.BeefCattle;
import dairyfactory.DairyCattle;

public class VeterinaryPhysician implements Visitor {

	@Override
	public void Visit(DairyCattle animal) {
		
		if(animal.getVacState()==false) {
			animal.setVacState(true);
			System.out.println("Id "+animal.getId() + " 's new state of vaccination is: " + animal.getVacState());
		}
		

	}

	@Override
	public void Visit(BeefCattle animal) {
		if(animal.getVacState()==false) {
			animal.setVacState(true);

			System.out.println("Id " +animal.getId() + " 's new state of vaccination is: " + animal.getVacState());
			
		}
	
	}


}
