package livestocksingleton;
import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import livestockobserver.TrackingDevice;

public class Database {
	public static Database GetDatabase(ArrayList<TrackingDevice> newtrackers) {
		
		if (instance == null) {
			lock.lock();
			//System.out.println("Acquired lock");
			try {
				if (instance == null)
					instance = new Database(newtrackers);
			} finally {
				lock.unlock();
				//System.out.println("Released lock");
			}
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
