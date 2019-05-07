package main;

import threadDispatcher.ThreadDispatcher;

import java.util.ArrayList;

import packet.MonitorPacket;
import tasks.SleepWorker1;
import tasks.SleepWorker2;

public class Runner {

	public static void main(String[] args) {
		ThreadDispatcher dispatcher = ThreadDispatcher.instance;
		dispatcher.add(new SleepWorker1());
		try {
			Thread.sleep(2000);
		} 
		catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dispatcher.add(new SleepWorker2());
		try {
			Thread.sleep(2000);
		} 
		catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ArrayList<MonitorPacket> res = dispatcher.getActiveThreads();
		int a = 1;
	}

}
