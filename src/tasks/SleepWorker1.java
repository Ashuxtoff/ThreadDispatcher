package tasks;

import observingInterfaces.Observer;
import threaded.Threaded;

public class SleepWorker1 extends Threaded{

	@Override
	public void execute() {
		try {
			Thread.sleep(7000);
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
