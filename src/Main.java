import java.util.Arrays;

public class Main {
    public static void main (String[] args) {
        /*System.out.println(isPalindrome("йцууцй"));
        System.out.println(Arrays.toString(makeArrayWithRandomElements(10)));
        System.out.println(Arrays.toString(makeArrayWithRandomElements2(10)));*//*
        System.out.println(countOfElement(3, makeArrayWithRandomElements(10)));*/
        int[] array = {4, 4, 4, 4, 4};
        System.out.println(Arrays.toString(indexesOfElement(4, array)));
        //System.out.println(Arrays.toString(indexesOfElement(4, makeArrayWithRandomElements(10))) );

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

}
