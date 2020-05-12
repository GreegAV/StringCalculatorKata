
import java.util.ArrayList;
import java.util.List;

public class StringCalculatorKata {

    public int add(String input) {
        if (input.isEmpty()) {
            return 0;
        }

        String[] numbers = input.split(",|\n");
//        String[] numbers = input.split("\\D");

        int result = 0;
        List<String> negatives = new ArrayList<>();
        for (String number : numbers) {
            if (Integer.parseInt(number) < 0) {
                negatives.add(number);
            }
            result += Integer.parseInt(number);
        }
        if (negatives.isEmpty()){
            return result;
        }
        String message = "Negatives: "+String.join(" ",negatives);
        throw new NegativeNumberException(message);
    }

}
