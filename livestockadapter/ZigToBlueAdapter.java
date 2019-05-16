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
