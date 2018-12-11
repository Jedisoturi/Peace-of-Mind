package theryhma.sovellus.status;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import androidx.annotation.Nullable;
import theryhma.sovellus.Instruction.InstructionContainer;
import theryhma.sovellus.state.State;
import theryhma.sovellus.state.StateTools;

/** This classes purpose is to set Status and it's parameters.
 * This class also includes methods to return parameters which has been called.
 * This class also includes methods needed for calendar functionality.*/
public class Status {
    private State state;
    private Calendar calendar;
    private InstructionContainer instructions;
    private String freeText;
    private int entries = 0;

    /** This constructor sets the parameters for Status.*/
    public Status(Date date, State state, InstructionContainer instructions) {
        this.state = state;
        this.calendar = Calendar.getInstance();
        calendar.setTime(date);
        this.instructions = instructions;
        this.freeText = "";
        if (state.size() != 0) {
            entries++;
        }
    }

    /** This contructor copies the Status given and creates a copy of it.*/
    public Status(Status reference) {
        this.state = reference.state;
        this.calendar = reference.calendar;
        this.instructions = reference.instructions;
        this.freeText = reference.freeText;
        this.entries = reference.entries;
    }

    /** This methods purpose is to compare Status's date to calendar and return boolean true or false depending
     * whether the date matches or not.*/
    public boolean isDate(int year, int month, int dayOfMonth) {
        if (calendar.get(Calendar.YEAR) == year && calendar.get(Calendar.MONTH) == month && calendar.get(Calendar.DAY_OF_MONTH) == dayOfMonth) {
            return true;
        } else {
            return false;
        }
    }

    /** This method sets parameter freeText to text.*/
    public void setText(String text) {
        this.freeText = text;
    }

    /** This method returns parameter freeText.*/
    public String getText() {
        return freeText;
    }

    /** This method updates the Instructions state with the new state.*/
    public void update(State newState) {
        combineState(newState);
        instructions.update(newState);
        entries++;
    }

    private void combineState(State newState) {
        ArrayList<State> states = new ArrayList<>();
        states.add(new State(getState()));
        states.add(new State(newState));
        StateTools.createMeanState(states);
        this.state = StateTools.createMeanState(states);
    }

    /** This method returns entries.*/
    public int getEntries() {
        return entries;
    }

    /** This method returns the calendar which has been called.*/
    public Calendar getCalendar() {
        return calendar;
    }

    /** This method returns the state which has been called.*/
    public State getState() {
        return state;
    }

    /** This method returns the instructions, which has been called.*/
    public InstructionContainer getInstructions() {
        return instructions;
    }

    /** This toString method returns parameters calendat, state & instructions.*/
    public String toString() {
        return this.calendar.toString() + "\n" + this.state.toString() + "\n" + this.instructions.toString() + "----\n";
    }
}
