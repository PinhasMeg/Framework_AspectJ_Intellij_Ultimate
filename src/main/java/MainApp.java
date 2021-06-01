import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;
import javax.enterprise.inject.Produces;

// TODO: Add java classes (in separate files for annotations and aspects)
public class MainApp {

    public static WeldContainer container = new Weld().initialize();

    public static void main(String[] args) {
        // TODO: Change this line to initialize an injected AlgorithmRunner
        /**This lines of code are for the part one of the project
         AlgorithmRunner algorithmRunner = new AlgorithmRunner();
         algorithmRunner.runAlgorithms();
         */

        AlgorithmRunner algorithmRunner = container.select(AlgorithmRunner.class).get();
        algorithmRunner.runAlgorithms();
    }

     /** we used Producers for the injection */

    @Produces
    public @LowClass SortingAlgorithm<Integer> QuadraticAlgorithm(){
        return container.select(BubbleSort.class).get();
    }
    @Produces
    public @HighClass SortingAlgorithm<Integer> nlognAlgorithm() {
        return container.select(QuickSort.class).get();
    }
    @Produces
    public @HighClass int numberElements(){
        return 10000;
    }

}

