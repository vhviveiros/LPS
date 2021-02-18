package repository;

import model.Model;

import java.util.ArrayList;

public abstract class Repository<T extends Model> {
    protected ArrayList<T> data = new ArrayList<>();

    public void addItem(T item) {
        data.add(item);
    }

    public void removeItem(T item) {
        data.remove(item);
    }

    public ArrayList<T> retrieveData() {
        return (ArrayList<T>) data.clone();
    }

    public int count() {
        return data.size();
    }

    public T getValueAt(int pos) {
        return data.get(pos);
    }

    public abstract T findItem(String [] args);
}
