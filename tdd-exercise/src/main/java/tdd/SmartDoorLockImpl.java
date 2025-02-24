package tdd;

import java.util.Optional;

public class SmartDoorLockImpl implements SmartDoorLock{

    public static final int MIN_FOUR_DIGITS = 1000;
    public static final int MAX_FOUR_DIGITS = 9999;
    private static final int MAX_ATTEMPTS = 4;
    private int failedAttempts;
    private Optional<Integer> pin;
    private State state;

    enum State {
        UNLOCKED, LOCKED, BLOCKED
    }

    @Override
    public void setPin(int pin) {
        if(hasPinFourDigits(pin)){
            this.pin = Optional.of(pin);
        }else{
            throw new IllegalArgumentException("pin should have 4 digits");
        }
    }

    private boolean hasPinFourDigits(int pin){
        return pin >= MIN_FOUR_DIGITS && pin <= MAX_FOUR_DIGITS;
    }

    @Override
    public void unlock(int pin) {
        if(pinIsCorrect(pin)){
            this.state = State.UNLOCKED;
        }else{
            this.failedAttempts++;
            this.checkBlocked();
        }
    }

    private boolean pinIsCorrect(int pin){
        return this.pin.stream().anyMatch(x -> x == pin);
    }
    private void checkBlocked(){
        if(this.failedAttempts >= this.getMaxAttempts()){
            this.state = State.BLOCKED;
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
        return this.state == State.BLOCKED;
    }

    @Override
    public int getMaxAttempts() {
        return MAX_ATTEMPTS;
    }

    @Override
    public int getFailedAttempts() {
        return this.failedAttempts;
    }

    @Override
    public void reset() {

    }
}
