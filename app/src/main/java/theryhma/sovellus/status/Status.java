package theryhma.sovellus.status;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import androidx.annotation.Nullable;
import theryhma.sovellus.Instruction.InstructionContainer;
import theryhma.sovellus.state.State;
import theryhma.sovellus.state.StateTools;

public class Status {
    private State state;
    private Calendar calendar;
    private InstructionContainer instructions;
    private String freeText;
    private int entries = 0;

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

    public Status(Status reference) {
        this.state = reference.state;
        this.calendar = reference.calendar;
        this.instructions = reference.instructions;
        this.freeText = reference.freeText;
        this.entries = reference.entries;
    }

    public boolean isDate(int year, int month, int dayOfMonth) {
        if (calendar.get(Calendar.YEAR) == year && calendar.get(Calendar.MONTH) == month && calendar.get(Calendar.DAY_OF_MONTH) == dayOfMonth) {
            return true;
        } else {
            return false;
        }
    }

    public void setText(String text) {
        this.freeText = text;
    }
    public String getText() {
        return freeText;
    }

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

    public int getEntries() {
        return entries;
    }

    public Calendar getCalendar() {
        return calendar;
    }

    public State getState() {
        return state;
    }

    public InstructionContainer getInstructions() {
        return instructions;
    }

    public String toString() {
        return this.calendar.toString() + "\n" + this.state.toString() + "\n" + this.instructions.toString() + "----\n";
    }
}
