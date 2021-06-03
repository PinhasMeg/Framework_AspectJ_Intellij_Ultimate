package sortingClean;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;
import javax.enterprise.inject.Produces;
import javax.inject.Qualifier;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

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
        @Qualifier
        @Retention(RUNTIME)
        @Target({FIELD, TYPE, METHOD})
        public @interface Quadratic {
        }

        @Qualifier
        @Retention(RUNTIME)
        @Target({FIELD, TYPE, METHOD})
        public @interface nlogn {
        }

        @Qualifier
        @Retention(RUNTIME)
        @Target({FIELD, TYPE, METHOD})
        public @interface NumberElements {
        }

        @Produces
        public @Quadratic SortingAlgorithm<Integer> QuadraticAlgorithm(){
                return container.select(BubbleSort.class).get();
        }
        @Produces
        public @nlogn SortingAlgorithm<Integer> nlognAlgorithm() {
                return container.select(QuickSort.class).get();
        }

        @Produces
        public @NumberElements int numberElements(){
                return 10000;
        }

}