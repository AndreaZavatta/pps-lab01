package tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SmartDoorLockTest {
    private static final int PIN = 1234;
    private static final int INVALID_PIN = 123;
    private static final int WRONG_PIN = 1235;
    public static final int BIAS_FOR_RIGHT_NUMBER_ATTEMPTS = 1;
    public static final int NUMBER_FAILED_ATTEMPTS = 2;
    public static final int INIT_FAILED_ATTEMPTS = 0;
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

    @Test
    public void TestTooManyFailedAttempts(){
        smartDoorLock.setPin(PIN);
        for(int i = 0; i < smartDoorLock.getMaxAttempts(); i++){
            smartDoorLock.unlock(WRONG_PIN);
        }
        assertTrue(smartDoorLock.isBlocked());
    }

    @Test
    public void TestNotBlocked(){
        smartDoorLock.setPin(PIN);
        for(int i = 0; i < smartDoorLock.getMaxAttempts() - BIAS_FOR_RIGHT_NUMBER_ATTEMPTS; i++){
            smartDoorLock.unlock(WRONG_PIN);
        }
        assertFalse(smartDoorLock.isBlocked());
    }

    @Test
    public void CheckNumberOfFailedAttempts(){
        smartDoorLock.setPin(PIN);
        smartDoorLock.unlock(WRONG_PIN);
        smartDoorLock.unlock(WRONG_PIN);
        assertEquals(NUMBER_FAILED_ATTEMPTS, smartDoorLock.getFailedAttempts());
    }

    @Test
    public void shouldThrowExceptionIfSetLockWithoutSetPin(){
        assertThrows(IllegalStateException.class, () -> smartDoorLock.lock());
    }

    @Test
    public void testSetLock(){
        smartDoorLock.setPin(PIN);
        smartDoorLock.lock();
        assertTrue(smartDoorLock.isLocked());
    }

    @Test
    public void testReset(){
        smartDoorLock.setPin(PIN);
        for(int i = 0; i < smartDoorLock.getMaxAttempts(); i++){
            smartDoorLock.unlock(WRONG_PIN);
        }
        assertTrue(smartDoorLock.isBlocked());
        smartDoorLock.reset();
        assertEquals(INIT_FAILED_ATTEMPTS, smartDoorLock.getFailedAttempts());
        assertFalse(smartDoorLock.isBlocked());
    }
}
