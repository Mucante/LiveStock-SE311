package livestockobserver;

//Concrete observer of the observer pattern
public class Farmer implements Observer {
	private TrackingDevice _trackingdevice;
	private String _farmer_name;
	private String _tracker_name; // Internal Observer state
	private double _tracker_range;

	// Constructor
	public Farmer(String name) {
		_farmer_name = name;
	}

	public void Update(TrackingDevice currenttrackingdevice) {
		_trackingdevice = currenttrackingdevice; // Reference to Subject
		_tracker_name = _trackingdevice.getSymbol();
		_tracker_range = _trackingdevice.getRange();
		System.out.println("Notified " + _farmer_name + " of " + _tracker_name + "'s "
				+ "going off the 1000 range limit of the farm to: " + _tracker_range);
	}

	public TrackingDevice getTrackingDevice() {
		return _trackingdevice;
	}

	public void setTrackingDevice(TrackingDevice value) {
		_trackingdevice = value;
	}

	public String getName() {
		return _farmer_name;
	}
}
