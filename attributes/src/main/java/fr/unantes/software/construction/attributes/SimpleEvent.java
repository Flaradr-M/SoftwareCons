package fr.unantes.software.construction.attributes;

import java.util.Calendar;
/**
 * Created on 21/01/2018.
 *
 */
public class SimpleEvent implements Event {

    /**
     * Creates a new event. Throws a IllegalArgumentException if the arguments are not valid:
     * null name or a end date that precedes the start date.
     *
     * @param id this event unique identifier
     * @param name this event name
     * @param start this event start date
     * @param end this event end date
     */
    public SimpleEvent(Integer id, String name, Calendar start, Calendar end) {

    }

    @Override
    public Integer getId() {
        //TODO
        return null;
    }

    @Override
    public String getName() {
        //TODO
        return null;
    }

    @Override
    public void setName(String str) {
        //TODO

    }

    @Override
    public String getLocation() {
        //TODO
        return null;
    }

    @Override
    public void setLocation(String str) {
        //TODO
    }

    @Override
    public boolean addAlarm(Integer i) {
        return false;
        //TODO
    }

    @Override
    public Integer getAlarm(int i) {
        return null;
        //TODO
    }

    @Override
    public Integer removeAlarm(int i) {
        //TODO
        return null;
    }

    protected Calendar getStart() {
        //TODO
        return null;
    }

    protected void setStart(Calendar cal) {
        //TODO
    }

    protected Calendar getEnd() {
        //TODO
        return null;
    }

    protected void setEnd(Calendar cal) {
        //TODO
    }
}
