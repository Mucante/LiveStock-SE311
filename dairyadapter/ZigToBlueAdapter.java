package dairyadapter;

public class ZigToBlueAdapter implements BluetoothSignal{

	public double usingBluetoothSignal(double newrange) {
		// Possibly do some other work and then call
		// usingEURSocket from the European socket.
		double range = _adaptee.usingZigbeeSignal(newrange);
		return range;
	}
	
	public ZigToBlueAdapter (ZigbeeSignal adaptee) {
		_adaptee = adaptee;
	}
	private ZigbeeSignal _adaptee;
	
}
