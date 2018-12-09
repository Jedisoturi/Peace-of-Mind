package theryhma.sovellus.status;

import java.util.Date;

import theryhma.sovellus.Instruction.InstructionContainer;
import theryhma.sovellus.state.State;

public class Status {
    private State state;
    private Date date;
    private InstructionContainer instructions;
    private String freeText;


    public Status(State state, Date date, InstructionContainer instructions) {
        this.state = state;
        this.date = date;
        this.instructions = instructions;
        this.freeText = "";
    }
}
