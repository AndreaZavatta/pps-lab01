package tdd;

import java.util.Optional;

public class SmartDoorLockImpl implements SmartDoorLock{

    public static final int MIN_FOUR_DIGITS = 1000;
    public static final int MAX_FOUR_DIGITS = 9999;
    private Optional<Integer> pin;
    private State state;

    enum State {
        UNLOCKED, LOCKED, BLOCKED
    }

    private boolean pinIsCorrect(int pin){
        return this.pin.stream().anyMatch(x -> x == pin);
    }

    private boolean hasPinFourDigits(int pin){
        return pin >= MIN_FOUR_DIGITS && pin <= MAX_FOUR_DIGITS;
    }
    @Override
    public void setPin(int pin) {
        if(hasPinFourDigits(pin)){
            this.pin = Optional.of(pin);
        }else{
            throw new IllegalArgumentException("pin should have 4 digits");
        }
    }

    @Override
    public void unlock(int pin) {
        if(pinIsCorrect(pin)){
            this.state = State.UNLOCKED;
        }
    }

    @Override
    public void lock() {

    }

    @Override
    public boolean isLocked() {
        return this.state == State.LOCKED;
    }

    @Override
    public boolean isBlocked() {
        return false;
    }

    @Override
    public int getMaxAttempts() {
        return 0;
    }

    @Override
    public int getFailedAttempts() {
        return 0;
    }

    @Override
    public void reset() {

    }
}
