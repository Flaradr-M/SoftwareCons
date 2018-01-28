package fr.unantes.software.construction.associations;

/**
 * Created on 28/01/2018.
 *
 * @author sunye.
 */
public interface Opposite <T> {

    void insert(T value);

    void remove(T value);
}
