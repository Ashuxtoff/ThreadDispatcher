package packet;

public class MonitorPacket {

	public long id;
	public long time;
	public String name;	
	
	public MonitorPacket(long id, String name, long time) {
		this.id = id;
		this.time = time;
		this.name = name;
	}
}
