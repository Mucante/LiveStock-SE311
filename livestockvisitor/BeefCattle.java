package livestockvisitor;

import livestockobserver.TrackingDevice;

//concrete element
public class BeefCattle extends Cattle {
	// CONSTRUCTOR
	public BeefCattle(String name, int id, Boolean vaccinationState, Boolean earTag, TrackingDevice newtracker) {
		super(name, id, vaccinationState, earTag, newtracker);
	}

	public void Accept(Visitor visitor) {
		visitor.Visit(this);
	}
}
