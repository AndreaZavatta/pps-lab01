package tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SmartDoorLockTest {
    public static final int PIN = 1234;
    public static final int INVALID_PIN = 123;
    SmartDoorLock smartDoorLock;


    @BeforeEach
    public void setSmartDoorLock(){
        smartDoorLock = new SmartDoorLockImpl();
    }

    @Test
    public void shouldThrowExceptionIfSetPinInvalid(){
        assertThrows(IllegalArgumentException.class, () -> smartDoorLock.setPin(INVALID_PIN));
    }

    @Test
    public void shouldUnlock(){
        smartDoorLock.setPin(PIN);
        smartDoorLock.unlock(PIN);
        assertFalse(smartDoorLock.isLocked());
    }

}
