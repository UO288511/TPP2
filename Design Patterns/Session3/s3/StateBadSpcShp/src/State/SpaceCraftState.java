package State;

public interface SpaceCraftState {
    void advance();
    void abort();
    String status();
}