import dairyadapter.*;
import dairyfactory.*;
import dairyobserver.*;

public class FakeTesting {
	public static void main(String[] args) {

		
		System.out.println("time to start testing factory pattern!");
		//testing factory pattern
		   Cattle DairyCattle = new DairyCattle();
		   Cattle BeefCattle = new BeefCattle();

		   FeedCattle Feed = new FeedCattle();
		   System.out.println("Buying Dairy Cattle Food");
		   Feed.createDefense(DairyCattle);
		   Feed.displayProducts();
		   
		   System.out.println("Buying Beef Cattle Food");
		   Feed.createDefense(BeefCattle);
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

		   
		   
		   
		}

}
