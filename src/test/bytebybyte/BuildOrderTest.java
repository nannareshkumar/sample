//package test.bytebybyte;
//
//import java.io.FileNotFoundException;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.threads.Test;
//
//import static org.junit.jupiter.api.Assertions.assertThrows;
//import static org.junit.jupiter.api.Assertions.assertTrue;
//
//
//public class BuildOrderTest {
//
//    @BeforeAll
//    public static void commandFactory() {
//
//        assertThrows(FileNotFoundException.class, () -> ClientFactory.buildClient(args, commandFactory));
//    }
//
//    @threads.Test
//    public void buildClientWithNoArg_shouldCreateCLIClient() throws FileNotFoundException {
//        assertThrows(IllegalArgumentException.class, () -> {
//            Car car = new Car("KA01HQ5467", null);
//        });
//        assertEquals(car1, car2);
//        assertTrue(client instanceof CLIClient);
//    }
//}