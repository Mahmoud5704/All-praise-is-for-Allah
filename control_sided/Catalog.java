package control_sided;

public class Catalog {
    public boolean current;       // True if a game is in progress
    public boolean allModesExist; // True if all difficulties exist

    public Catalog(boolean current, boolean allModesExist) {
        this.current = current;
        this.allModesExist = allModesExist;
    }
}
