import org.junit.jupiter.params.provider.Arguments;
import java.util.stream.Stream;

public class DataProvider {

    private static Stream<Arguments> dataSource(){
        return Stream.of(Arguments.of("Renata"),
                Arguments.of("Ola"),
                Arguments.of("Dariusz"),
                Arguments.of("Jakub")
        );
    }
}
