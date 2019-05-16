package livestockobserver;

import java.util.ArrayList;

//subject of observer pattern
abstract public class TrackingDevice {
	public TrackingDevice(String symbol, double range) {
		_symbol = symbol;
		_range = range;
	}

	// Register the Observers
	public void Attach(Farmer farmer) {
		Farmers.add(farmer);
	}

	// Unregister from the list of Observers.
	public void Detach(Farmer oldfarmer) {
		for (int i = 0; i < Farmers.size(); i++) {
			if (Farmers.get(i).getName() == oldfarmer.getName()) {
				Farmers.remove(i);
				return;
			}
		}
	}

	// Notify the Observers.
	public void Notify() {
		// set argument to something that helps
		// tell the Observers what happened
		for (int i = 0; i < Farmers.size(); i++) {
			Farmers.get(i).Update(this);
		}
	}

	public String getSymbol() {
		return _symbol;
	}

	void setSymbol(String value) {
		_symbol = value;
	}

	public double getRange() {
		return 0;
	}

	public abstract void setRange(double rangevalue);

	protected String _symbol; // Internal Subject state
	protected double _range;
	protected ArrayList<Farmer> Farmers = new ArrayList<Farmer>();
}
