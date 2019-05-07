package tasks;

import java.io.FileWriter;
import packet.MonitorPacket;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

import observingInterfaces.Observer;
import threaded.Threaded;

public class ThreadMonitor extends Threaded {
	
	private ConcurrentHashMap<Long, String> activeThreads = new ConcurrentHashMap<Long, String>();
	private ConcurrentHashMap<Long, Long> timesThreads = new ConcurrentHashMap<Long, Long>();
	
	public void update(String type, long id, String name) {
		if (type.equals("add")) {
			activeThreads.put(id, name);
			timesThreads.put(id, System.currentTimeMillis());
		}
		if (type.equals("remove")) {
			activeThreads.remove(id);
			timesThreads.remove(id);		
		}
	}
	
	public ArrayList<MonitorPacket> getInfo() {
		ArrayList<MonitorPacket> result = new ArrayList<MonitorPacket>();
		for (long id: activeThreads.keySet()) 
			result.add(new MonitorPacket(id, activeThreads.get(id), System.currentTimeMillis() - timesThreads.get(id)));			
		return result;
	}

	@Override
	public void notifyObserver(Observer observer) {	}

	@Override
	public void execute() {
		while (true) {
			
		}
	}
	
//	public void stop() {
//		this.stop();
//	}
}


