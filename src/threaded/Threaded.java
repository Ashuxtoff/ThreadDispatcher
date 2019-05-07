package threaded;

import observingInterfaces.Observer;
import threadDispatcher.ThreadDispatcher;

public abstract class Threaded implements Runnable{
	
	public void run() {
		this.execute();
		this.notifyObserver(ThreadDispatcher.instance);
	}
	
	public abstract void execute();
		
	public abstract void notifyObserver(Observer observer);

}