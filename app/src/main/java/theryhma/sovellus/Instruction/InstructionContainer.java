package theryhma.sovellus.Instruction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import theryhma.sovellus.attribute.Attribute;
import theryhma.sovellus.attribute.AttributeType;
import theryhma.sovellus.state.State;
import theryhma.sovellus.tools.Maths;
import theryhma.sovellus.tools.Tools;

import static theryhma.sovellus.Instruction.InstructionTools.getRandomInstruction;

public class InstructionContainer {
    private Map<AttributeType, Instruction> instructions;

    public InstructionContainer(State state) {
        this.instructions = createInstructions(state);
    }

    public InstructionContainer() {
        this.instructions = new HashMap<>();
    }

    public void update(State newState) {
        Map<AttributeType, ArrayList<Instruction>> possibleInstructions = createPossibleInstructions(newState);
        for (Map.Entry<AttributeType, ArrayList<Instruction>> entry : possibleInstructions.entrySet())
        {
            AttributeType key = entry.getKey();
            ArrayList<Instruction> list = entry.getValue();
            if (instructions.containsKey(key)) {
                if (instructions.get(key).isInRange(newState.getAttribute(key).getValue())) {
                    // do nothing
                } else {
                    instructions.put(key, new Instruction(getRandomInstruction(list)));
                }
            } else {
                instructions.put(key, new Instruction(getRandomInstruction(list)));
            }
        }
    }

    private static Map<AttributeType, Instruction> createInstructions(State state) {
        Map<AttributeType, ArrayList<Instruction>> possibleInstructions = createPossibleInstructions(state);
        Map<AttributeType, Instruction> result = new HashMap<>();
        for (Map.Entry<AttributeType, ArrayList<Instruction>> entry : possibleInstructions.entrySet())
        {
            result.put(entry.getKey(), new Instruction(getRandomInstruction(entry.getValue())));
        }
        return result;
    }

    private static Instruction getRandomInstruction(ArrayList<Instruction> list) {
        Instruction i = list.get(Maths.getRandomIntegerBetweenRange(0, list.size() - 1));
        return i;
    }

    private static Map<AttributeType, ArrayList<Instruction>> createPossibleInstructions(State state) {
        ArrayList<Instruction> instructions = InstructionConstants.createArrayList();
        Map<AttributeType, ArrayList<Instruction>> result = new HashMap<>();
        for (Instruction i : instructions) {
            AttributeType instructionType = i.getAttributeType();
            if (state.containsAttribute(instructionType)) {
                if (i.isInRange(state.getAttribute(instructionType).getValue())) {
                    if (result.containsKey(instructionType)) {
                        result.get(instructionType).add(i);
                    } else {
                        ArrayList<Instruction> array = new ArrayList<>();
                        array.add(i);
                        result.put(instructionType, array);
                    }
                }
            }
        }
        return result;
    }

    public ArrayList<Instruction> createArray() {
        ArrayList<Instruction> array = new ArrayList<>();
        for (Map.Entry<AttributeType, Instruction> entry : instructions.entrySet())
        {
            array.add(entry.getValue());
        }
        return array;
    }

    @Override
    public String toString() {
        String s = "Ohjeet: ";
        for (Map.Entry<AttributeType, Instruction> entry : this.instructions.entrySet())
        {
            s = s + entry.getKey().toFinnish() + ": " + entry.getValue().getText() + "\n";
        }
        return s;
    }
}
