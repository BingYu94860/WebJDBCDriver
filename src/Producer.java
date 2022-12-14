public class Producer implements Runnable {
  private SyncStack theStack;
  private int num;
  private static int counter = 1;

  public Producer (SyncStack s) {
    theStack = s;
    num = counter++;
  }

  public void run() {
    char c;

    for (int i = 0; i < 200; i++) {
      c = (char)(Math.random() * 26 +'A');//Math.random()隨機產生一個0.0~1.0數字*26->0.0~25.0+'A' ->65.0~90.0
      theStack.push(c);
      System.out.println("Producer" + num + ": " + c);
      try {
        Thread.sleep((int)(Math.random() * 300));
      } catch (InterruptedException e) {
        // ignore it
      }
    }
  } // END run method

} // END Producer class
