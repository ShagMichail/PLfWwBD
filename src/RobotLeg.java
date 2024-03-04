class RobotLeg implements Runnable {
    private String legName;
    public RobotLeg(String legName) {
        this.legName = legName;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println(legName + " takes a step.");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}