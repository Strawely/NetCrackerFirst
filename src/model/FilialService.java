package model;

import model.filial.Filial;
import model.filial.Filials;

import java.util.HashSet;

public class FilialService {
    HashSet<Filials> filials;

    public FilialService() {
        filials = new HashSet<>();
        for (int i = 0; i < 10; i++)
            filials.add(new Filial("Filial" + i));
    }

    public FilialService(HashSet<Filials> filials) {
        this.filials = filials;
    }

    public HashSet<Filials> getElements() {
        return filials;
    }

    public void removeElement(Filials filial) {
        filials.remove(filial);
    }

    public void addElement(Filials filial) {
        filials.add(filial);
    }
}
