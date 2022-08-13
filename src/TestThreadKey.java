
class SpeedAlert extends Thread {
	巴士 bus;

	SpeedAlert(巴士 bus) {
		this.bus = bus;
	}

	public void run() {
		synchronized (巴士.class) {
			System.out.println("Alert速度設限等待中");
			while (巴士.limitSpeed == 0) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException ex) {
				}
			}
			System.out.println("Alert等待速度設限完成,最高速=" + bus.limitSpeed);
			巴士.class.notifyAll();
		}
	}
}

class SpeedAlarm extends Thread {
	巴士 bus;

	SpeedAlarm(巴士 bus) {
		this.bus = bus;
	}

	public void run() {
		System.out.println("超速Alarm速度設限未完成");
		synchronized (巴士.class) {
			try {
				巴士.class.wait();
			} catch (InterruptedException ex) {
			}
		}
		System.out.println("超速Alarm速度設限完成可發車!");
	}
}

class 司機 extends Thread {
	巴士 bus;

	司機(巴士 bus) {
		this.bus = bus;
	}

	public void run() {
		synchronized (bus) {
			while (bus.開車時間 == 10) {
				System.out.println("司機等待開車中");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException ex) {
				}
			}
			System.out.println("司機開車====>");
			try {
				Thread.sleep(5000);
			} catch (InterruptedException ex) {
			}
			System.out.println("路途中=========>");
			try {
				Thread.sleep(5000);
			} catch (InterruptedException ex) {
			}
			System.out.println("-===================>");
			bus.notifyAll();
		}
	}
}

class 乘客 extends Thread {
	巴士 bus;
	String name;

	乘客(巴士 bus, String name) {
		this.bus = bus;
		this.name = name;
	}

	public void run() {
		synchronized (bus) {
			System.out.println("乘客:" + name + "搭車");
			try {
				bus.wait();
			} catch (InterruptedException ex) {
			}
			System.out.println("乘客:" + name + "被通知到站");
		}
	}
}

class 巴士 {
	static int limitSpeed = 0;
	String 目地;
	int 開車時間 = 10;

	void setBusMove(int 開車時間) {
		this.開車時間 = 開車時間;
	}

	void setLimitSpeed(int limitSpeed) {
		this.limitSpeed = limitSpeed;
	}
}

class TestThreadKey {
	public static void main(String[] args) {
		巴士 bus = new 巴士();
		乘客 customer1 = new 乘客(bus, "客一");
		乘客 customer2 = new 乘客(bus, "客二");
		乘客 customer3 = new 乘客(bus, "客三");
		司機 driver1 = new 司機(bus);
		SpeedAlarm speedAlarm = new SpeedAlarm(bus);
		SpeedAlert speedAlart = new SpeedAlert(bus);
		customer1.start();
		customer2.start();
		customer3.start();
		driver1.start();
		speedAlarm.start();
		speedAlart.start();

		for (int i = 0; i < 10; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException ex) {
			}
			System.out.println("等待:" + i + "秒");
		}
		bus.setLimitSpeed(100);
		for (int i = 0; i < 10; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException ex) {
			}
			System.out.println("等待:" + i + "秒");
		}
		bus.setBusMove(0);
		try {
			巴士.class.notifyAll();
			bus.notifyAll();
		} catch (Exception e) {
		}

	}
}
