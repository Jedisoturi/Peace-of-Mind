package theryhma.sovellus.Instruction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import theryhma.sovellus.attribute.AttributeType;
/**Set's Instructions */
public class InstructionConstants {
    private static final Map<String, Instruction> instructions = new HashMap<String, Instruction>() {
        {
            put("asdfsaf", new Instruction("NUKU", AttributeType.ENERGY, 0, 0.5));
            put("adsfasdf", new Instruction("Mene urheilemaan", AttributeType.ENERGY, 0.5, 1));
            put("sdasdfssd", new Instruction("Syö", AttributeType.NUTRITION, 0, 0.5));
            put("sfsdfs", new Instruction("Jatka syömistä samaan tapaan", AttributeType.NUTRITION, 0.5, 1));
            put("sdssssd", new Instruction("Olet hyvällä tuulella", AttributeType.MOOD, 0.5, 1));
            put("sdssssassd", new Instruction("Olet huonolla tuulella", AttributeType.MOOD, 0, 0.5));
        }
    };

    /**Return's instruction */
    public Instruction get(String key) {
        return new Instruction(instructions.get(key));
    }

    /**Create's a new Arraylist and retuns it*/
    public static ArrayList<Instruction> createArrayList() {
        ArrayList<Instruction> array = new ArrayList<>();
        for (Map.Entry<String, Instruction> entry : instructions.entrySet())
        {
            array.add(entry.getValue());
        }
        return array;
    }
}
