///////////// The test program:
import java.util.ArrayList;

import livestockadapter.*;
import livestockfactory.*;
import livestockobserver.*;
import livestockvisitor.*;
import livestocksingleton.*;

public class LiveStock {
	public static void main(String[] args) {
		ArrayList<TrackingDevice> trackers = new ArrayList<TrackingDevice>();
		
		//testing factory pattern
		   CattleFoodFactory DairyFactory = new DairyFactory();
		   CattleFoodFactory BeefFactory = new BeefFactory();

		   FeedCattle Feed = new FeedCattle();
		   System.out.println("Producing Dairy Cattle Food");
		   Feed.producefood(DairyFactory);
		   Feed.displayProducts();
		   
		   System.out.println("Producing Beef Cattle Food");
		   Feed.producefood(BeefFactory);
		   Feed.displayProducts();
		   
		   System.out.println("We got the food needed for the cattles");
		   System.out.println("");

		   
		   Cattles cattles = new Cattles();
		   //Set up  trackers
		   DairyTracker tracker1 = new DairyTracker("tracker1",300);
		   trackers.add(tracker1);
		   DairyTracker tracker2 = new DairyTracker("tracker2",450);
		   trackers.add(tracker2);
		   DairyTracker tracker3 = new DairyTracker("tracker3",670);
		   trackers.add(tracker3);
		   DairyTracker tracker4 = new DairyTracker("tracker4",220);
		   trackers.add(tracker4);
		   //put the trackers to singleton db
		   Database db = Database.GetDatabase(trackers);
		  
		   //Set up Cattles collection
		   cattles.Add(new BeefCattle("beef1", 13, false, false, db.getTrackingDevice(0)));
		   cattles.Add(new BeefCattle("beef2", 21, true, false, db.getTrackingDevice(1)));
		   cattles.Add(new DairyCattle("dairy1", 56, false, false, db.getTrackingDevice(2)));
		   cattles.Add(new DairyCattle("dairy2", 36, false, true, db.getTrackingDevice(3)));

		   //Cattles are visited.
		   System.out.println("Spring has arrived!");
		   System.out.println("Checking the visitors from Ministry: ");
		   cattles.Accept(new Ministry());
		   
		   System.out.println("");
		   System.out.println("Autumn has arrived!");
		   System.out.println("Checking the visitors from VeterinaryPhysician: ");
		   cattles.Accept(new VeterinaryPhysician());
		
		   // The range changes with signals and farmers get notified for any that goes beyond the range of the farm
		   System.out.println("");
		   System.out.println("Signal control: ");
		   BluetoothSignal signalforRange = new ZigToBlueAdapter(new ZigbeeSignal());			
		   Farmer farmer1 = new Farmer("ali");
		   Farmer farmer2 = new Farmer("veli");
		   Farmer farmer3 = new Farmer("can");
		   Farmer farmer4 = new Farmer("gizem");
		   Farmer farmer5 = new Farmer("batu");
		   
		   farmer1.setTrackingDevice(db.getTrackingDevice(0));
		   farmer2.setTrackingDevice(db.getTrackingDevice(0));
		   farmer3.setTrackingDevice(db.getTrackingDevice(1));
		   farmer4.setTrackingDevice(db.getTrackingDevice(1));
		   farmer5.setTrackingDevice(db.getTrackingDevice(2));
		   
		   db.getTrackingDevice(0).Attach(x);
		   db.getTrackingDevice(0).Attach(z);
		   db.getTrackingDevice(1).Attach(c);
		   db.getTrackingDevice(1).Attach(g);
		   db.getTrackingDevice(2).Attach(b);

		   db.getTrackingDevice(0).setRange(signalforRange.usingBluetoothSignal(655)); //if it is less than 1000 it won't notify the farmers
		   db.getTrackingDevice(0).setRange(signalforRange.usingBluetoothSignal(1225));
		   db.getTrackingDevice(1).setRange(signalforRange.usingBluetoothSignal(1138));
		   db.getTrackingDevice(1).setRange(signalforRange.usingBluetoothSignal(899));
		   db.getTrackingDevice(2).setRange(signalforRange.usingBluetoothSignal(1022));
		   
		}
}

///////////////////// Livestock Adapter pattern:

//first class:
package livestockadapter;

public interface BluetoothSignal {
	double usingBluetoothSignal(double range);
}

//second  class:
package livestockadapter;

public class ZigbeeSignal {
	public double usingZigbeeSignal(double range) {
		System.out.println("Signaled to range: "+range);
		return range;
	}
}

//third class:
package livestockadapter;

public class ZigToBlueAdapter implements BluetoothSignal{
	public double usingBluetoothSignal(double newrange) {
		double range = _adaptee.usingZigbeeSignal(newrange);
		return range;
	}
	public ZigToBlueAdapter (ZigbeeSignal adaptee) {
		_adaptee = adaptee;
		}
	private ZigbeeSignal _adaptee;	
}

///////////////////// Livestock Factory pattern:

//first class:
package livestockfactory;

//abstract factory
abstract public class CattleFoodFactory {
	abstract FoodProduct createProduct(String productname);
}

//second class:
package livestockfactory;

//concrete factory
public class BeefFactory extends CattleFoodFactory {
	public FoodProduct createProduct(String productname){
		if(productname.equals("Carbon")){
			return new Wheat (18.00);
		}
		if(productname.equals("Protein")){
			return new Canola(45.00);
		}
		else return null;
	}
}

//third class:
package livestockfactory;

//concrete factory
public class DairyFactory extends CattleFoodFactory{
	public FoodProduct createProduct(String productname){
			if(productname.equals("Carbon")){
				return new Corn (15.00);
			}
			if(productname.equals("Protein")){
				return new Soybean(23.00);
			}
			else return null;	
	}
}

//fourth class:
package livestockfactory;

abstract public class FoodProduct {
	abstract public String displayName();
	abstract public double getPrice();
}

//fifth class:
package livestockfactory;

public abstract class Carbon extends FoodProduct{
	abstract public String displayName();
}

//sixth class:
package livestockfactory;

public abstract class Protein extends FoodProduct{
	abstract public String displayName();
}

//seventh class:
package livestockfactory;

public class Wheat extends Carbon {
	double price;
	public Wheat(double p){
		price = p;
		System.out.println("\t Wheat is produced...");
	}
	public String displayName() { return new String("Wheat"); }
	public double getPrice(){ return price; }
}

//eighth class:
package livestockfactory;

public class Corn extends Carbon{
	double price;
	public Corn(double p){
		price = p;
		System.out.println("\t Corn is produced...");
	}
	public String displayName() { return new String("Corn"); }
	public double getPrice(){ return price; }
}

//ninth class:
package livestockfactory;

public class Canola extends Protein{
	double price;
	public Canola(double p){
		price = p;
		System.out.println("\t Canola is produced...");
	}
	public String displayName() { return new String("Canola"); }
	public double getPrice(){ return price; }
}

//tenth class:
package livestockfactory;

public class Soybean extends Protein{
	double price;
	public Soybean(double p){
		price = p;
		System.out.println("\t Soybean is produced...");
	}
	public String displayName() { return new String("Soybean"); }
	public double getPrice(){ return price; }
}

//eleventh class:
package livestockfactory;

import java.util.ArrayList;
//client of factory pattern
public class FeedCattle {
	public void producefood(CattleFoodFactory factory) {
		FoodProducts = new ArrayList<FoodProduct>();
		FoodProducts.add(factory.createProduct("Carbon"));
		FoodProducts.add(factory.createProduct("Protein"));
	}
	public void displayProducts() {
		System.out.println("\tListing Food Products \n\t-------------");
		FoodProducts.forEach(p -> System.out.println(p.displayName() +" with price: " + p.getPrice()));
	}
	private ArrayList<FoodProduct> FoodProducts;
}

///////////////////// Livestock Observer pattern:

//first class:
package livestockobserver;

//Concrete Subject of the observer pattern
public class DairyTracker extends TrackingDevice {
	public DairyTracker(String symbol, double range){
		super(symbol,range);
	}
	public double getRange(){return _range;} 
	public void setRange(double newRange){
		_range = newRange;
		//notify if a cow has changed position to a range bigger than 1000
		if(_range>1000){Notify();}
	}
}

//second class:
package livestockobserver;

//Concrete observer of the observer pattern
public class Farmer implements Observer{
	private TrackingDevice _trackingdevice;
	private String _farmer_name;
	private String _tracker_name;     // Internal Observer state
	private double _tracker_range;
	// Constructor
	public Farmer(String name) {
		_farmer_name = name;
	}
	public void Update(TrackingDevice currenttrackingdevice) {
		 _trackingdevice = currenttrackingdevice; 	 // Reference to Subject
		 _tracker_name = _trackingdevice.getSymbol();
		 _tracker_range = _trackingdevice.getRange();
		 System.out.println("Notified " + _farmer_name + " of " + _tracker_name +
				 "'s " + "going off the 1000 range limit of the farm to: "+ _tracker_range);
	}
	public TrackingDevice getTrackingDevice() { return _trackingdevice; }
	public void setTrackingDevice(TrackingDevice value) { _trackingdevice = value; }
	public String getName() { return _farmer_name; }
}

//third class:
package livestockobserver;

//Observer interface of the observer pattern
public interface Observer {
	public void Update(TrackingDevice x);
}

//fourth class:
package livestockobserver;

import java.util.ArrayList;

//subject of observer pattern
abstract public class TrackingDevice {
	public TrackingDevice(String symbol,double range) {
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
	public String getSymbol() {return _symbol;}
	void setSymbol(String value) {_symbol = value;}
	public double getRange(){return 0;}
	public abstract void setRange(double rangevalue);
	
	protected String _symbol; // Internal Subject state
	protected double _range;
	protected ArrayList<Farmer> Farmers = new ArrayList<Farmer>();
}

///////////////////// Livestock Singleton pattern:

//first class:
package livestocksingleton;
import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import livestockobserver.TrackingDevice;

public class Database {
	public static Database GetDatabase(ArrayList<TrackingDevice> newtrackers) {
		if (instance == null) {
			lock.lock();
			try {
				if (instance == null)
					instance = new Database(newtrackers);
			} finally {lock.unlock();}
		}
		return instance;
	}
	//gets the location of the cattle
	public TrackingDevice getTrackingDevice(int id) {	
				return trackers.get(id);
	}	
	// Constructor (private).
	private Database(ArrayList<TrackingDevice> currenttrackers) {
	      trackers = currenttrackers;
	}
	private static Database instance = null;
	private static final Lock lock = new ReentrantLock();
	private ArrayList<TrackingDevice> trackers;
}

///////////////////// Livestock Visitor pattern:

//first class:
package livestockvisitor;

public interface Element {
	public abstract void Accept(Visitor visitor);
}

//second class:
package livestockvisitor;

public interface Visitor {
	public void Visit(DairyCattle animal);
	public void Visit(BeefCattle animal);
}

//third class:
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
	public TrackingDevice getTracker(){return tracker;}
	public void setTracker(TrackingDevice newtracker){tracker=newtracker;}
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	public Boolean getVacState() {return vacState;}
	public void setVacState(Boolean vacState) {this.vacState = vacState;}
	public Boolean getEarTag() {return earTag;}
	public void setEarTag(Boolean earTag) {this.earTag = earTag;}
	public int getId() {return id;}
	public void setId(int id) {this.id = id;}

	private int id;
	private String name;
	private Boolean vacState;
	private Boolean earTag;
	private TrackingDevice tracker;
}

//fourth class:
package livestockvisitor;

import livestockobserver.TrackingDevice;

//concrete element
public class BeefCattle extends Cattle{
	//CONSTRUCTOR
		public BeefCattle(String name,int id, Boolean vaccinationState, Boolean earTag, TrackingDevice newtracker) {
			super(name,id,vaccinationState,earTag,newtracker);
		}
		public void Accept(Visitor visitor) {
			visitor.Visit(this);
			}
}

//fifth class:
package livestockvisitor;
import livestockobserver.TrackingDevice;

//concrete element
public class DairyCattle extends Cattle {
	//CONSTRUCTOR
	public DairyCattle(String name,int id, Boolean vaccinationState, Boolean earTag, TrackingDevice tracker) {
		super(name,id,vaccinationState,earTag,tracker);
	}
	public void Accept(Visitor visitor) {visitor.Visit(this);}
}

//sixth class:
package livestockvisitor;

import java.util.ArrayList;

//OBJECT STRUCTURE (CATTLES)
public class Cattles {
	public void Add(Cattle cattle){ cattles.add(cattle);}
	public void Remove(Cattle cat) {
		for (int i = 0; i< cattles.size(); i++) {
			if (cattles.get(i).getName() == cat.getName()) {
				cattles.remove(i);
				return;
			}
		}
	}
	public void Accept(Visitor visitor) {
		for (int i = 0; i < cattles.size(); i++) {
			cattles.get(i).Accept(visitor);}
	}
	private ArrayList<Cattle> cattles = new ArrayList<Cattle>();
}

//seventh class:
package livestockvisitor;

public class Ministry implements Visitor {

	@Override
	public void Visit(DairyCattle animal) {	
		if(animal.getEarTag()==false) {
			System.out.println("it seems that the dairy cattle "+animal.getName()+" doesn't have an id tag.");
			animal.setEarTag(true);			
			System.out.println("Id " + animal.getId() + " 's ear tag is now: " + animal.getEarTag());					
		}
		else if(animal.getEarTag()==true){
			System.out.println("the dairy cattle "+animal.getName()+" already has an id tag.");
		}
	}
	@Override
	public void Visit(BeefCattle animal) {
		if(animal.getEarTag()==false) {
			System.out.println("it seems that the beef cattle "+animal.getName()+" doesn't have an id tag.");
			animal.setEarTag(true);
			System.out.println("Id "+animal.getId() + " 's ear tag is now: " + animal.getEarTag());			
		}
		else if(animal.getEarTag()==true){
			System.out.println("the beef cattle "+animal.getName()+" already has an id tag.");
		}
	}
}

//eighth class:
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

///////////////////// END OF PROJECT!

