package dairyobserver;

//Concrete Subject of the observer pattern
public class DairyTracker extends TrackingDevice {
	
	public DairyTracker(String symbol, double range){
		super(symbol,range);
	}
	public double getRange(){return _range;} 

	public void setRange(double newRange){
		_range = newRange;
		
		//notify if a cow has changed position to a range bigger than 1000
		if(_range>1000){
			Notify();
		}
	}
}
