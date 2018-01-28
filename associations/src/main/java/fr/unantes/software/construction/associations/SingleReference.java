package fr.unantes.software.construction.associations;

/**
 * Created on 28/01/2018.
 *
 * @author sunye.
 */
public interface SingleReference<T> {

    void set(T newValue);

    T get();

    void unset();

    void basicSet(T newValue);

    boolean isSet();

}
