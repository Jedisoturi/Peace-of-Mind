package theryhma.sovellus.Instruction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import theryhma.sovellus.attribute.AttributeType;

public class InstructionConstants {
    private static final Map<String, Instruction> instructions = new HashMap<String, Instruction>() {
        {
            put("asdfsaf", new Instruction("NUKU", AttributeType.ENERGY, 0, 0.5));
            put("sdsd", new Instruction("Mene urheilemaan", AttributeType.ENERGY, 0.5, 1));
        }
    };

    public Instruction get(String key) {
        return instructions.get(key);
    }

    public static ArrayList<Instruction> createArrayList() {
        ArrayList<Instruction> array = new ArrayList<>();
        for (Map.Entry<String, Instruction> entry : instructions.entrySet())
        {
            array.add(entry.getValue());
        }
        return array;
    }
}
