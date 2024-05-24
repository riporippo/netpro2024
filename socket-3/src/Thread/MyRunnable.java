package Thread;

class MyRunnable implements Runnable {
    private int threadNum;

    public MyRunnable(int threadNum) {
        this.threadNum = threadNum;
    }
    @Override
    public void run() {
        for (int j = 1; j <= 10; j++) {
            System.out.println("Thread " + threadNum + ": " + j);
            try {
                Thread.sleep(100); // 100ミリ秒待機
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}