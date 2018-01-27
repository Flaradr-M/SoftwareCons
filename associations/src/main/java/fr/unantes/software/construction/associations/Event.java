package fr.unantes.software.construction.associations;

/**
 * Created on 27/01/2018.
 *
 * @author sunye.
 */
public interface Event {

    Integer getId();

    String getName();

    void setName(String str);

    String getLocation();

    void setLocation(String str);

    boolean addAlarm(Integer i);

    Integer getAlarm(int i);

    Integer removeAlarm(int i);

    EventCalendarCursor calendar();

    EventTaskCursor task();

    EventContactCursor contacts();

}
