package threadDispatcher;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import packet.MonitorPacket;
import observingInterfaces.Observer;
import tasks.ThreadMonitor;
import threaded.Threaded;

public class ThreadDispatcher implements Observer{

	public static final ThreadDispatcher instance = new ThreadDispatcher();
	
	private ThreadMonitor monitor = new ThreadMonitor();	
	
	private ThreadDispatcher() {
		add(monitor);
	}	
	
	@Override
	public void handleEvent(long id, String name) {
		monitor.update("remove", id, name);
	}
	
	public void add(Threaded threaded) {
		Thread newThread = new Thread(threaded);
		newThread.start();
		monitor.update("add", newThread.getId(), newThread.getName());
	}	
	
	public ArrayList<MonitorPacket> getActiveThreads(){
		return monitor.getInfo();
	}
	
//	public void stopMonitor() {
//		monitor.stop();
//	}
}
