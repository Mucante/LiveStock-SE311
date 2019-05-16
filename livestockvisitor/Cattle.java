package livestockvisitor;

import livestockobserver.TrackingDevice;

//the skeleton of concrete elements
public abstract class Cattle implements Element{
	public Cattle(String newName, int ID, Boolean vaccinationState, Boolean newEarTag, TrackingDevice trackingdevice) { 
		name=newName;
		id=ID;
		vacState=vaccinationState;
		earTag=newEarTag;
		//placing observer's tracker to a cattle
		tracker=trackingdevice;
	}
	
	public TrackingDevice getTracker(){
		return tracker;
	}
	public void setTracker(TrackingDevice newtracker){
		tracker=newtracker;
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
	private TrackingDevice tracker;
}
