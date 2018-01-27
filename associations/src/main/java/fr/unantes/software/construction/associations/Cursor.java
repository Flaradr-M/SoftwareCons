package fr.unantes.software.construction.associations;

/**
 * Created on 27/01/2018.
 *
 * @author sunye.
 */
public interface Cursor<T> {

    /**
     * If valid() is true, the cursor is said to be valid and has a reference to an instance of
     * the target entity of the association. If the cursor is invalid, attempts to access the
     * target will result in an exception.
     * @return
     */
    boolean valid();

    /**
     * Advances the cursor so that the “next” target becomes current.
     * If there is none, the cursor becomes invalid.
     * In the case of to-1 relationships, the cursor becomes invalid by definition.
     */
    void next();

    /**
     * The remove() operation removes the current element.
     * If the cursor is not valid, it throws an exception.
     * Prior to the removal, remove advances the cursor as specified for next().
     */
    void remove();

    /**
     * The insert(t) operation inserts a link to the specified target element t.
     * The parameter t has the type of the interface corresponding to the target of the relationship.
     * In the case of a to-one association, insert first performs an implicit remove().
     * After the insert, the current target is t and the cursor is valid.
     * @param value
     */
    void insert(T value);
}
