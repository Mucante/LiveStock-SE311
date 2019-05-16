package livestockvisitor;

public class VeterinaryPhysician implements Visitor {

	@Override
	public void Visit(DairyCattle animal) {
		if(animal.getVacState()==false) {
			System.out.println("it seems that the dairy cattle "+animal.getName()+" doesn't have the proper vaccination.");
			animal.setVacState(true);
			System.out.println("Id "+animal.getId() + " 's new state of vaccination is: " + animal.getVacState());
		}
		else if(animal.getVacState()==true){
			System.out.println("the dairy cattle "+animal.getName()+" already was vaccinated.");
		}
	}

	@Override
	public void Visit(BeefCattle animal) {
		if(animal.getVacState()==false) {
			System.out.println("it seems that the beef cattle "+animal.getName()+" doesn't have the proper vaccination.");
			animal.setVacState(true);
			System.out.println("Id " +animal.getId() + " 's new state of vaccination is: " + animal.getVacState());			
		}
		else if(animal.getVacState()==true){
			System.out.println("the beef cattle "+animal.getName()+" already was vaccinated.");
		}
	}


}