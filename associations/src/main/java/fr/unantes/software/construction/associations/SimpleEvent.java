package fr.unantes.software.construction.associations;

/**
 * Created on 27/01/2018.
 *
 * @author sunye.
 */
public class SimpleEvent implements Event {

    public SimpleEvent(Integer id) {

    }

    @Override
    public Integer getId() {
        return null;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public void setName(String str) {

    }

    @Override
    public String getLocation() {
        return null;
    }

    @Override
    public void setLocation(String str) {

    }

    @Override
    public boolean addAlarm(Integer i) {
        return false;
    }

    @Override
    public Integer getAlarm(int i) {
        return null;
    }

    @Override
    public Integer removeAlarm(int i) {
        return null;
    }

    @Override
    public EventCalendarCursor calendar() {
        return null;
    }

    @Override
    public Opposite<Calendar> calendarOpposite() {
        return null;
    }

    @Override
    public EventTaskCursor task() {
        return null;
    }

    @Override
    public Opposite<Task> taskOpposite() {
        return null;
    }

    @Override
    public EventContactCursor invitees() {
        return null;
    }
}
