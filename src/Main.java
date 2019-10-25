import java.util.Arrays;

public class Main {
    public static void main (String[] args) {
        //Задача1
        //System.out.println(isPalindrome("qweewq"));
        //Задача2
        //System.out.println(Arrays.toString(makeArrayWithRandomElements(10)));
        //Задача3
        //System.out.println(Arrays.toString(indexesOfElement(3, makeArrayWithRandomElements(10))));
        //Задача4
        //System.out.println(Arrays.toString(swapMinAndMaxElement(makeArrayWithRandomElements(10))));
        //Задача5
        //System.out.println(averageOfArrayElements(makeArrayWithRandomElements(10)));
        //Задача6
        //System.out.println(countOfNegativeElementsInArray(makeArrayWithRandomElements2(10)));
        //Задача7
        //System.out.println(Arrays.toString(arrayWithoutElement(0, makeArrayWithRandomElements(10))));
        //Задача8
        //System.out.println(Arrays.toString(reverseArray(makeArrayWithRandomElements(10))));
        //Задача9
        //System.out.println(isArraySortedAsc(makeArrayWithRandomElements(10)));
        //System.out.println(isArraySortedAsc(sortedArrayAsc(makeArrayWithRandomElements(10))));
        //Задача10
        //System.out.println(Arrays.toString(randomSortingArray(makeArrayWithRandomElements(10))));
        //Задача11
        //System.out.println(Arrays.toString(sortedArrayAsc(makeArrayWithRandomElements(10))));
        //Задача12
        //createTwoDemensionalArray(5);
        //Задача13
        //System.out.println(Arrays.toString(addNewElementToEndOfArray(99, makeArrayWithRandomElements(10))));
        //Задача14
        //sumOfElementsInArrayUsingRecursion(makeArrayWithRandomElements(10));


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


    public static boolean isPalindrome (String givenString) {
        int counter = givenString.length()-1;
        for (int i = 0; i < givenString.length()/2; i++) {
            if (givenString.charAt(i) != givenString.charAt(counter)) {
                return false;
            }
            counter--;
        }
        return true;
    }

    public static int[] makeArrayWithRandomElements (int amountOfElemets) {
        int[] array = new int[amountOfElemets];
        for (int i = 0; i < amountOfElemets; i++) {
            array[i] = (int) (Math.random() * 100);
        }
        return array;
    }

    public static int[] makeArrayWithRandomElements2 (int amountOfElements) {
        int[] array = new int[amountOfElements];
        int i = 0;
        while (i < amountOfElements) {
            array[i] = (int) (Math.random() * -100);
            i++;
        }
        System.out.println(Arrays.toString(array));
        return array;
    }

    public static int countOfElement(int element, int[] givenArray) {
        int countOfElement = 0;
        for (int i = 0; i < givenArray.length; i++) {
            if (givenArray[i] == element) {
                countOfElement ++;
            }
        }
        return countOfElement;
    }

    public static int[] indexesOfElement(int element, int[] givenArray) {
        System.out.println(Arrays.toString(givenArray));
        System.out.println("Элемент " + element);
        int countOfElement = countOfElement(element, givenArray);
        int[] indexes = new int[countOfElement];
        if (countOfElement == 0) {
            return new int[]{-1};
        }
        for (int i = 0; i < countOfElement; i++) {
            for (int j = 0; j < givenArray.length; j++) {
                if (givenArray[j] == element) {
                    indexes[i] = j;
                    i++;
                }
            }
        }
        return indexes;
    }

    public static float averageOfArrayElements (int[] givenArray) {
        System.out.println(Arrays.toString(givenArray));
        int sumOfElements = 0;
        int counterOfIterations = 0;
        while (counterOfIterations < givenArray.length) {
            sumOfElements += givenArray[counterOfIterations];
            counterOfIterations++;
        }
        System.out.println("Сумма элементов = " + sumOfElements);
        System.out.println("Количество элементов = " + givenArray.length);
        return (float) sumOfElements / givenArray.length;
    }

    public static int minElementInArray(int[] givenArray) {
        int minElement = givenArray[0];
        for (int i = 1; i < givenArray.length; i++) {
            if (givenArray[i] < minElement) {
                minElement = givenArray[i];
            }
        }
        return minElement;
    }

    public static int maxElementInArray (int[] givenArray) {
        int maxElement = givenArray[0];
        for (int i = 1; i < givenArray.length; i++) {
            if (givenArray[i] > maxElement) {
                maxElement = givenArray[i];
            }
        }
        return maxElement;
    }

    public static int[] swapMinAndMaxElement (int[] givenArray) {
        System.out.println(Arrays.toString(givenArray));
        int maxElement = maxElementInArray(givenArray);
        int minElement = minElementInArray(givenArray);
        System.out.println("Max " + maxElement);
        System.out.println("Min " + minElement);
        for (int i = 0; i < givenArray.length; i++) {
            if (givenArray[i] == minElement) {
                givenArray[i] = maxElement;
            }
            else if (givenArray[i] == maxElement) {
                givenArray[i] = minElement;
            }
        }
        return givenArray;
    }

    public static int countOfNegativeElementsInArray (int[] givenArray) {
        int count = 0;
        for (int i = 0; i < givenArray.length; i++) {
            if (givenArray[i] < 0) {
                count ++;
            }
        }
        return count;
    }

    public static int[] arrayWithoutElement (int indexOfElement, int[] givenArray) {
        System.out.println(Arrays.toString(givenArray));
        int[] array = new int[givenArray.length - 1];
        int indexOfElementInGivenArray = 0;
        int indexOfElementInArray = 0;
        while (indexOfElementInGivenArray < givenArray.length && indexOfElementInArray < array.length) {
            if (indexOfElementInGivenArray == indexOfElement) {
                indexOfElementInGivenArray++;
            }
            else {
                array[indexOfElementInArray] = givenArray[indexOfElementInGivenArray];
                indexOfElementInGivenArray++;
                indexOfElementInArray++;
            }
        }
        return array;
    }

    public static int[] reverseArray (int[] givenArray) {
        System.out.println(Arrays.toString(givenArray));
        int counter = givenArray.length - 1;
        int tmp;
        for (int i = 0; i < givenArray.length/2; i++) {
            tmp = givenArray[counter];
            givenArray[counter] = givenArray[i];
            givenArray[i] = tmp;
            counter--;
        }
        return givenArray;
    }

    public static boolean isArraySortedAsc (int[] givenArray) {
        System.out.println(Arrays.toString(givenArray));
        for (int i = 0; i < givenArray.length - 1; i++) {
            if (givenArray[i] > givenArray[i+1]) {
                return false;
            }
        }
        return true;
    }

    public static int[] randomSortingArray (int[] givenArray) {
        System.out.println(Arrays.toString(givenArray));
        int[] array = new int[givenArray.length];
        int[] isIndexFull = new int[givenArray.length];
        int randomIndex = (int) (Math.random() * givenArray.length);
        for (int i = 0; i < givenArray.length; i++) {
            while (Arrays.binarySearch(isIndexFull, 1) != -1) {
                if (isIndexFull[randomIndex] == 1) {
                    randomIndex = (int) (Math.random() * givenArray.length);
                    continue;
                }
                break;
            }
            array[i] = givenArray[randomIndex];
            isIndexFull[randomIndex] = 1;
        }
        return array;
    }

    public static void createTwoDemensionalArray (int lengthOfArray) {
        int[][] twoDemensionalArray = new int[lengthOfArray][lengthOfArray];
        for (int i = 0; i < lengthOfArray; i++) {
            for (int j = 0; j < lengthOfArray; j++) {
                twoDemensionalArray[i][j] = (int) (Math.random() * 100);
            }
        }
        for (int i = 0; i < twoDemensionalArray.length; i++) {
            for (int j = 0; j < twoDemensionalArray.length; j++) {
                System.out.print(twoDemensionalArray[i][j] + "\t");
            }
            System.out.println();
        }

    }

    public static int[] addNewElementToEndOfArray (int element, int[] givenArray) {
        System.out.println(Arrays.toString(givenArray));
        int[] newArrayWithElement = new int[givenArray.length + 1];
        for (int i = 0; i < givenArray.length; i++) {
            newArrayWithElement[i] = givenArray[i];
        }
        newArrayWithElement[newArrayWithElement.length-1] = element;
        return newArrayWithElement;
    }

    /*public static int sumOfElementsInArrayUsingRecursion(int[] givenArray) {
        int counter = 0;
        counter += incrementInt(counter);
        int sum = 0;
        int sum = sumOfElementsInArrayUsingRecursion(givenArray) + givenArray[counter];
        if (counter == givenArray.length-1){
            System.out.println(sum);
            return sum;
        }
        return sumOfElementsInArrayUsingRecursion(givenArray) + givenArray[counter];
    }

    public static int incrementInt(int counter) {
        counter++;
        return counter;
    }*/


}
