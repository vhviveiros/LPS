package model;

public abstract class Model {
    private final int id;

    protected Model(int id) {
        this.id = id;
    }

    protected Model() {
        this.id = -1;
    }

    public int getId() {
        return id;
    }
}
