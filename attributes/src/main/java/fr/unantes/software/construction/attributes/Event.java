package fr.unantes.software.construction.attributes;

import java.util.Date;
import java.util.Objects;

/**
 * Created on 21/01/2018.
 *
 */
public interface Event {

    Integer getId();

    String getName();

    void setName(String str);

    String getLocation();

    void setLocation(String str);

    /**
     * Adds a new alarm number to this Event, until the limit of 5.
     * @param i the new alarm number
     * @return true if the alarm is added, false if the limit is exceeded.
     */
    public boolean addAlarm(Integer i);

    public Integer getAlarm(int i);

    public Integer removeAlarm(int i);

}
