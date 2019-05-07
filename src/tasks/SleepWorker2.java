package tasks;

import observingInterfaces.Observer;
import threaded.Threaded;

public class SleepWorker2 extends Threaded{

	@Override
	public void execute() {
		try {
			Thread.sleep(10000);
		} 
		catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void notifyObserver(Observer observer) {
		observer.handleEvent(Thread.currentThread().getId(), Thread.currentThread().getName());		
	}

}
