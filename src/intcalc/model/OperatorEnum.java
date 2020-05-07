package intcalc.model;

public enum OperatorEnum {
    OPERATOR_ADDITION, OPERATOR_SUBTRACTION,
    OPERATOR_MINIMUM, OPERATOR_MAXIMUM,
    OPERATOR_UNKNOWN;
    public static final String ERROR_UNKNOWN_OPERATOR =
            "Error! Unexpected operator!";

    public int[] process(int[] a, int[] b) {
        switch (this) {
            case OPERATOR_ADDITION:
                int length = a.length + b.length;
                int[] result = new int[length];
                System.arraycopy(a, 0, result, 0, a.length);
                System.arraycopy(b, 0, result, a.length, b.length);
                uniqueCount(result);
                commonNumber(result);
                return result;
            case OPERATOR_SUBTRACTION:
                int[] temp = new int[a.length];
                int numberOfZeros = 0;
                for (int i=0; i<a.length; i++) {
                    for (int j = 0; j < b.length; j++) {
                        if (a[i] != b[j]) {
                            temp[i - numberOfZeros] = a[i];
                        } else {
                            numberOfZeros++;
                        }
                    }
                }
                int[] result2 = new int[temp.length-numberOfZeros];
                System.arraycopy(temp, 0, result2, 0, result2.length);
                uniqueCount(result2);
                commonNumber(result2);
                return result2;
        }
        throw new
                RuntimeException(ERROR_UNKNOWN_OPERATOR);
    }
    static void uniqueCount(int[] array) {
        int result = 0;
        int countUnique = 0;
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            countUnique++;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] == array[i]) {
                    count++;
                    break;
                }
            }
        }
        result = countUnique - count;
        System.out.println("Number of different numbers: "+ result);
    }
    static void commonNumber(int[] array) {
        int num=0, fqr;
        int max_fqr=0;
        for(int i=0; i< array.length-1; i++){
            fqr=1;
            for(int k=i+1;k<array.length; k++){
               if (array[i]==array[k])
                        fqr+=1;
               if (fqr>max_fqr) {
                   max_fqr = fqr;
                   num = array[i];
               }
            }
        }
        if (max_fqr>1)
            System.out.println("Common number: "+ num);
        else System.out.println("All numbers are unique");
    }
}
