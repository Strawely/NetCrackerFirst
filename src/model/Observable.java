package model;

import view.Observer;

/**
 * Created by Админ on 28.12.2017.
 */
public interface Observable
{
    void registerObserver(Observer observer);
    void notifyAllObservers();
}
