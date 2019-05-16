import java.util.ArrayList;

import livestockadapter.*;
import livestockfactory.*;
import livestockobserver.*;
import livestockvisitor.*;
import livestocksingleton.*;

public class FakeTesting {
	public static void main(String[] args) {
///// ONEMLI  HER FARMER TÜM CATTLELARI MI GORSUN???
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
		   System.out.println("Checking the visitors from Ministry: ");
		   cattles.Accept(new Ministry());
		   
		   System.out.println("");
		   System.out.println("Checking the visitors from VeterinaryPhysician: ");
		   cattles.Accept(new VeterinaryPhysician());
		
		   System.out.println("");
		   System.out.println("Signal control: ");
		   BluetoothSignal signalforRange = new ZigToBlueAdapter(new ZigbeeSignal());			
		   Farmer x = new Farmer("ali");
		   Farmer z = new Farmer("veli");
		   Farmer c = new Farmer("can");
		   Farmer g = new Farmer("gizem");
		   Farmer b = new Farmer("batu");
		   
		   x.setTrackingDevice(db.getTrackingDevice(0));
		   z.setTrackingDevice(db.getTrackingDevice(0));
		   c.setTrackingDevice(db.getTrackingDevice(1));
		   g.setTrackingDevice(db.getTrackingDevice(1));
		   b.setTrackingDevice(db.getTrackingDevice(2));
		   
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
