import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) throws Exception {
        Letters letter = new Letters();
        ExecutorService ex = Executors.newFixedThreadPool(3);
        List<Callable<String>> callables = new ArrayList<>();
        callables.add(new Callable<String>() {
            @Override
            public String call() throws Exception {
                letter.printA();
                return "Done A";
            }
        });
        callables.add(new Callable<String>() {
            @Override
            public String call() throws Exception {
                letter.printB();
                return "Done B";
            }
        });
        callables.add(new Callable<String>() {
            @Override
            public String call() throws Exception {
                letter.printC();
                return "Done C";
            }
        });

        List<Future<String>> futures = ex.invokeAll(callables);

        for (Future<String> f  : futures) {
            System.out.println(f.get());
        }
        ex.shutdown();
    }
}
