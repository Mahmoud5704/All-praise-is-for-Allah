package control_sided;

public class Catalog {
    private boolean current;       // True if a game is in progress
    private boolean allModesExist; // True if all difficulties exist

    public Catalog(boolean current, boolean allModesExist) {
        this.current = current;
        this.allModesExist = allModesExist;
    }

    public boolean isCurrent() {
        return current;
    }

    public void setCurrent(boolean current) {
        this.current = current;
    }

    public boolean is_AllLevels_Exist() {
        return allModesExist;
    }

    public void set_AllLevels_Exist(boolean allModesExist) {
        this.allModesExist = allModesExist;
    }
}
