package model;

import java.util.HashSet;

public interface ServiceInterface<T> {
    HashSet<T> getElements();
    void setElements(HashSet<T> elements);
    void removeElement(T element);
    void addElement(T element);
}
