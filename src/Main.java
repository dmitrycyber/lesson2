import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import sun.nio.cs.ext.MacArabic;

import java.util.Arrays;

public class Main {
    public static void main (String[] args) {
        /*System.out.println(isPalindrome("йцууцй"));
        System.out.println(Arrays.toString(makeArrayWithRandomElements(10)));
        System.out.println(Arrays.toString(makeArrayWithRandomElements2(10)));
        System.out.println(countOfElement(3, makeArrayWithRandomElements(10)));
        System.out.println(Arrays.toString(indexesOfElement(4, makeArrayWithRandomElements(10))) );
        System.out.println(averageOfArrayElements(makeArrayWithRandomElements(10)));*/
        /*System.out.println(minElementInArray(makeArrayWithRandomElements(10)));
        System.out.println(maxElementInArray(makeArrayWithRandomElements(10)));*/
        //swapMinAndMaxElement(makeArrayWithRandomElements(10));
        /*System.out.println(countOfNegativeElementsInArray(makeArrayWithRandomElements(10)));*/
        /*System.out.println(Arrays.toString(arrayWithoutElement(2, makeArrayWithRandomElements(10))));*/
        //reverseArray(makeArrayWithRandomElements(11));
        /*int[] array = {1, 2, 3, 4, 5};
        System.out.println(isArraySortedAsc(array));*/
        randomSortingArray(makeArrayWithRandomElements(10));



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
            array[i] = (int) (Math.random() * 100);
            i++;
        }
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
        System.out.println(sumOfElements);
        System.out.println(givenArray.length);
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
        System.out.println("Before");
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
                maxElement = minElement;
                givenArray[i] = maxElement;
            }
        }
        System.out.println("After");
        System.out.println(Arrays.toString(givenArray));
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
        boolean isSortedAsc = false;
        for (int i = 0; i < givenArray.length - 1; i++) {
            if (givenArray[i] < givenArray[i+1]) {
                isSortedAsc = true;
            }
            else {
                isSortedAsc = false;
            }
        }
        return isSortedAsc;
    }

    public static void randomSortingArray (int[] givenArray) {
        System.out.println(Arrays.toString(givenArray));
        int[] array = new int[givenArray.length];
        boolean[] isIndexFull = new boolean[givenArray.length];
        isIndexFull[0] = true;
        int randomIndex = (int) (Math.random() * givenArray.length - 1);
        for (int i = 0; i < givenArray.length; i++) {
            while (isIndexFull[randomIndex] == true) {
                randomIndex = (int) (Math.random() * givenArray.length - 1);
                if
            }
            array[i] = givenArray[randomIndex];
            isIndexFull[randomIndex] = true;
        }
        System.out.println(Arrays.toString(array));
    }

}
