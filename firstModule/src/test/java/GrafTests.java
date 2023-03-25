import org.junit.jupiter.api.*;
import org.junit.jupiter.api.function.Executable;

import java.time.Duration;
import java.util.stream.Stream;

public class GrafTests {

    public static Graf sut;

    @BeforeAll
    public static void beforeAll() {
        int amountOfVertices = 6;
        sut = new Graf(amountOfVertices);
    }

    @BeforeEach
    public void initTest() {
        System.out.println("Running Test");
    }

    @AfterEach
    public void finalizeTest() {
        System.out.println("Test complete");
    }

    public static Stream<Object> sourseAddEdge() {
        return Stream.of(Arguments.of(0, 1), Arguments.of(1, 2), Arguments.of(3, 4));
    }

    public void testAddEdge() {
        testAddEdge(0, 0);
    }

    public void testAddEdge(int firstVertice, int secondVertice) {
        Duration expectedTimeOut = Duration.ofSeconds(60);

        Executable resultTimeOut = () -> sut.addEdge(firstVertice, secondVertice);

        Assertions.assertTimeout(expectedTimeOut, resultTimeOut);
    }

    @Test
    public void testCalcPaths() {
        int[] expectedResult = {2, 2, 2, 1, 1, 0};

        int[] result = sut.calcPaths(sut);

        Assertions.assertArrayEquals(expectedResult, result);
    }

    @Test
    public void testAddEdgeThrowsException() {
        int firstVertice = 7;
        int outOfVertices = 7;
        Class<RuntimeException> expectedException = RuntimeException.class;

        Executable resultException = () -> sut.addEdge(firstVertice, outOfVertices);

        Assertions.assertThrows(expectedException, resultException);
    }

    private static class Arguments {
        public static Object of(int i, int i1) {
            return null;
        }
    }
}