package livestockvisitor;

public class Ministry implements Visitor {

	@Override
	public void Visit(DairyCattle animal) {
		if (animal.getEarTag() == false) {
			System.out.println("it seems that the dairy cattle " + animal.getName() + " doesn't have an id tag.");
			animal.setEarTag(true);
			System.out.println("Id " + animal.getId() + " 's ear tag is now: " + animal.getEarTag());
		} else if (animal.getEarTag() == true) {
			System.out.println("the dairy cattle " + animal.getName() + " already has an id tag.");
		}
	}

	@Override
	public void Visit(BeefCattle animal) {
		if (animal.getEarTag() == false) {
			System.out.println("it seems that the beef cattle " + animal.getName() + " doesn't have an id tag.");
			animal.setEarTag(true);
			System.out.println("Id " + animal.getId() + " 's ear tag is now: " + animal.getEarTag());
		} else if (animal.getEarTag() == true) {
			System.out.println("the beef cattle " + animal.getName() + " already has an id tag.");
		}
	}
}