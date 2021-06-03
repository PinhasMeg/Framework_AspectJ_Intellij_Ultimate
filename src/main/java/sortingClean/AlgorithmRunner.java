package sortingClean;

import javax.inject.Inject;
import java.util.Random;

// TODO: Add dependency injection and annotations to this file

public class AlgorithmRunner {
    @Inject
    @MainApp.Quadratic
    SortingAlgorithm<Integer> quadraticAlgorithm;
    @Inject
    @MainApp.nlogn
    SortingAlgorithm<Integer> nlognAlgorithm;
    @Inject
    @MainApp.NumberElements
    int numberOfElements;

    /**
     * This lines of code are for the part one of the project
     * SortingAlgorithm<Integer> quadraticAlgorithm =new BubbleSort();
     * SortingAlgorithm<Integer> nlognAlgorithm =new QuickSort();
     * int numberOfElements=10 ;
     */

    public void runAlgorithms() {
        Random rand = new Random();
        Integer[] ints = rand.ints(1, Integer.MAX_VALUE)
                .distinct()
                .limit(numberOfElements)
                .boxed()
                .toArray(Integer[]::new);
        Integer[] intsClone = ints.clone();
        quadraticAlgorithm.sort(intsClone);
        intsClone = ints.clone();
        nlognAlgorithm.sort(intsClone);
    }
}