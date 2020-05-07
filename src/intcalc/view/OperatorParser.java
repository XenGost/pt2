package intcalc.view;

import intcalc.model.OperatorEnum;


import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

public class OperatorParser {
    private Map<String, OperatorEnum> operatorMap = new
            HashMap<>();
    public OperatorParser() {
        operatorMap.put("+",
                OperatorEnum.OPERATOR_ADDITION);
        operatorMap.put("-",
                OperatorEnum.OPERATOR_SUBTRACTION);
    }
    public OperatorEnum parseOperator(String token)
            throws ParseException {
        OperatorEnum operator = operatorMap.get(token);
        if (operator == null) {
            throw new
                    ParseException(String.format("Error! Unexpected token: %s", token), 0);
        }
        return operator;
    }
}
