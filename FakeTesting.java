import livestockadapter.*;
import livestockfactory.*;
import livestockobserver.*;
import livestockvisitor.*;

public class FakeTesting {
	public static void main(String[] args) {

		
		System.out.println("time to start testing factory pattern!");
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
		   
		
		   System.out.println("it seems that testing factory is over!");
	       System.out.println("time to start testing observer and adapter pattern!");
		   //testing observer pattern AND adapter pattern
		   BluetoothSignal signalforRange = new ZigToBlueAdapter (new ZigbeeSignal());			
		   Farmer x = new Farmer("ali");
		   Farmer z = new Farmer("veli");
		   DairyTracker test = new DairyTracker("hope",324);
		   x.setTrackingDevice(test);
		   z.setTrackingDevice(test);
		   test.Attach(x);
		   test.Attach(z);
		   test.setRange(signalforRange.usingBluetoothSignal(655)); //1000 den azsa notifylamıyacak farmerları
		   test.setRange(signalforRange.usingBluetoothSignal(1225));
		   test.setRange(signalforRange.usingBluetoothSignal(853));
		   test.setRange(signalforRange.usingBluetoothSignal(1473));

		   System.out.println("time to start testing visitor pattern!");
		   //testing visitor pattern
		   Cattles cattles = new Cattles();
		   //Set up Cattles collection
		   cattles.Add(new BeefCattle("Beef Cattle", 13, false,false));
		   cattles.Add(new BeefCattle("Beef Cattle", 21, true,false));
		   cattles.Add(new BeefCattle("Beef Cattle", 17, false,true));
		   cattles.Add(new BeefCattle("Beef Cattle", 23, true,true));
		   cattles.Add(new DairyCattle("Dairy Cattle", 56, false,false));
		   cattles.Add(new DairyCattle("Dairy Cattle", 64, true,false));
		   cattles.Add(new DairyCattle("Dairy Cattle", 36, false,true));
		   cattles.Add(new DairyCattle("Dairy Cattle", 51, true,true));
		   
		   //Cattles are visited.
		   cattles.Accept(new Ministry());
		   cattles.Accept(new VeterinaryPhysician());
		   
		   
		   
		}

}
