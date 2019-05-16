package livestockvisitor;

import livestockobserver.TrackingDevice;

//concrete element
public class DairyCattle extends Cattle {
	// CONSTRUCTOR
	public DairyCattle(String name, int id, Boolean vaccinationState, Boolean earTag, TrackingDevice tracker) {
		super(name, id, vaccinationState, earTag, tracker);
	}

	public void Accept(Visitor visitor) {
		visitor.Visit(this);
	}
}
