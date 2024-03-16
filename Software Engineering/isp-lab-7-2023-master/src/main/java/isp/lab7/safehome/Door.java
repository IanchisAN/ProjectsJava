package isp.lab7.safehome;

public class Door {

    private final Long id;
    private DoorStatus status;
    private static Long currentId = 0L;

    public Door() {
        this.id = currentId++;
    }

    public Door(DoorStatus status) {
        this.id = currentId++;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public DoorStatus getStatus() {
        return status;
    }

    public void lockDoor() {
        this.status = DoorStatus.CLOSED;
        System.out.println("Door locked successfully!");
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void  unlockDoor() {
        this.status = DoorStatus.OPEN;
        System.out.println("Door unlocked successfully!");
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
