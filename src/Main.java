import java.util.Arrays;

public class Main {
    public static void main (String[] args) {
//        int[] array = {1,1,1,2,2};
        int[] array = new int[10];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 100);
        }
        System.out.println(Arrays.toString(array));

//        System.out.println(minValueInArray(array));
        System.out.println(countOfMinValueInArray(array));
//        System.out.println(Arrays.toString(indexesOfMinValueInArray(array)));
//        System.out.println(Arrays.toString(arrayWithoutMinValues(array)));
//        System.out.println(Arrays.toString(addingMinValuesToNewArray(array)));
        System.out.println(Arrays.toString(sortedArrayAsc(array)));
    }

    public static int minValueInArray (int[] givenArray) {
        int minValue = givenArray[0];
        for (int i = 0; i < givenArray.length; i++) {
            if (givenArray[i] < minValue) {
                minValue = givenArray[i];
            }
        }
        return minValue;

    }

    public static int countOfMinValueInArray(int[] givenArray) {
        int minValue = minValueInArray(givenArray);
        int countOfValues = 0;
        for (int i = 0; i < givenArray.length; i++) {
            if (givenArray[i] == minValue) {
                countOfValues ++;
            }
        }
        return countOfValues;

    }

    public static int[] indexesOfMinValueInArray (int[] givenArray) {
        int countOfValues = countOfMinValueInArray(givenArray);
        int minValue = minValueInArray(givenArray);
        int[] indexes = new int[countOfValues];
        for (int i = 0; i < indexes.length; i++) {
            for (int j = 0; j < givenArray.length; j++) {
                if (givenArray[j] == minValue) {
                    indexes[i] = j;
                    i++;
                }

            }

        }
        return indexes;

    }

    public static int[] arrayWithoutMinValues (int[] givenArray) {
        int[] arrayWithoutMinValues = new int[givenArray.length-countOfMinValueInArray(givenArray)];
        int minValue = minValueInArray(givenArray);
        for (int i = 0; i < arrayWithoutMinValues.length; i++) {
            for (int j = 0; j < givenArray.length; j++) {
                if (givenArray[j] != minValue){
                    arrayWithoutMinValues[i] = givenArray[j];
                    i++;

                }

            }

        }
        return arrayWithoutMinValues;
    }

    public static int[] addingMinValuesToNewArray (int[] givenArray) {
        int [] arrayWithMinValues = new int[givenArray.length];
        int minValue = minValueInArray(givenArray);
        int countOfValues = countOfMinValueInArray(givenArray);
        for (int i = 0; i < countOfValues; i++) {
            arrayWithMinValues[i] = minValue;

        }
        return arrayWithMinValues;

    }

    public static int[] sortedArrayAsc (int[] givenArray) {
        int[] sortedArrayAsc = new int[givenArray.length];
        for (int j = 0; j < sortedArrayAsc.length; j++) {
            if (countOfMinValueInArray(givenArray) != 1) {
                for (int i = 0; i < countOfMinValueInArray(givenArray) - 1; i++) {
                    sortedArrayAsc[j] = minValueInArray(givenArray);
                    j++;
                }
            }
            sortedArrayAsc[j] = minValueInArray(givenArray);
            givenArray = arrayWithoutMinValues(givenArray);
        }

        return sortedArrayAsc;
    }


}
