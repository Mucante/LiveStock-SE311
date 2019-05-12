package dairyfactory;
import dairyvisitor.*;

abstract public class Cattle extends Animal{
	
	abstract FoodProduct createProduct(String productname); //factory method
	
	public Cattle() {}
	//CONSTRUCTOR
	public Cattle(String newName, int ID, Boolean vaccinationState, Boolean newEarTag) { 
		name=newName;
		id=ID;
		vacState=vaccinationState;
		earTag=newEarTag;
	}
	

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Boolean getVacState() {
		return vacState;
	}
	public void setVacState(Boolean vacState) {
		this.vacState = vacState;
	}

	public Boolean getEarTag() {
		return earTag;
	}
	public void setEarTag(Boolean earTag) {
		this.earTag = earTag;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	private int id;
	private String name;
	private Boolean vacState;
	private Boolean earTag;
}