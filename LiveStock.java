import java.util.ArrayList;

import livestockadapter.*;
import livestockfactory.*;
import livestockobserver.*;
import livestockvisitor.*;
import livestocksingleton.*;

public class LiveStock {
	public static void main(String[] args) {
		ArrayList<TrackingDevice> trackers = new ArrayList<TrackingDevice>();

		// testing factory pattern
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
		// Set up trackers
		DairyTracker tracker1 = new DairyTracker("tracker1", 300);
		trackers.add(tracker1);
		DairyTracker tracker2 = new DairyTracker("tracker2", 450);
		trackers.add(tracker2);
		DairyTracker tracker3 = new DairyTracker("tracker3", 670);
		trackers.add(tracker3);
		DairyTracker tracker4 = new DairyTracker("tracker4", 220);
		trackers.add(tracker4);
		// put the trackers to singleton db
		Database db = Database.GetDatabase(trackers);

		// Set up Cattles collection
		cattles.Add(new BeefCattle("beef1", 13, false, false, db.getTrackingDevice(0)));
		cattles.Add(new BeefCattle("beef2", 21, true, false, db.getTrackingDevice(1)));
		cattles.Add(new DairyCattle("dairy1", 56, false, false, db.getTrackingDevice(2)));
		cattles.Add(new DairyCattle("dairy2", 36, false, true, db.getTrackingDevice(3)));

		// Cattles are visited.
		System.out.println("Spring has arrived!");
		System.out.println("Checking the visitors from Ministry: ");
		cattles.Accept(new Ministry());

		System.out.println("");
		System.out.println("Autumn has arrived!");
		System.out.println("Checking the visitors from VeterinaryPhysician: ");
		cattles.Accept(new VeterinaryPhysician());

		// The range changes with signals and farmers get notified for any that
		// goes beyond the range of the farm
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

		db.getTrackingDevice(0).Attach(farmer1);
		db.getTrackingDevice(0).Attach(farmer2);
		db.getTrackingDevice(1).Attach(farmer3);
		db.getTrackingDevice(1).Attach(farmer4);
		db.getTrackingDevice(2).Attach(farmer5);

		db.getTrackingDevice(0).setRange(signalforRange.usingBluetoothSignal(655)); 
		// if it is less than 1000 it won't notify the farmers.
		db.getTrackingDevice(0).setRange(signalforRange.usingBluetoothSignal(1225));
		db.getTrackingDevice(1).setRange(signalforRange.usingBluetoothSignal(1138));
		db.getTrackingDevice(1).setRange(signalforRange.usingBluetoothSignal(899));
		db.getTrackingDevice(2).setRange(signalforRange.usingBluetoothSignal(1022));

	}

}
