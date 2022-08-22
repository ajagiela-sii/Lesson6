import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.Car;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CarTest {

    WebDriver driver;

    @BeforeAll
    static void setDriver(){
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setUp(){
        driver = new ChromeDriver();
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }

    @ParameterizedTest
    @MethodSource("DataProvider#dataSource")
    @DisplayName("Checking title for Booking.com")
    @Order(6)
    @Tag("booking")
    @Tag("regression")
    void checkTitleForBookingCom(String title) {
        driver.get("https://www.booking.com");
        driver.manage().window().maximize();
        String actualTitle = driver.getTitle();
        assertThat(actualTitle).isEqualTo(title);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/testData.csv", numLinesToSkip = 1)
    @DisplayName("Checking title for Booking.com")
    @Order(6)
    @Tag("booking")
    @Tag("regression")
    void checkTitleForBookingCom2(String title) {
        driver.get("https://www.booking.com");
        driver.manage().window().maximize();
        String actualTitle = driver.getTitle();
        assertThat(actualTitle).isEqualTo(title);
    }

    @ParameterizedTest
    @ValueSource(strings={"Rozwiązania i usługi IT, inżynierii i BPO - Sii Polska"})
    @DisplayName("Checking title for Sii.pl")
    @Order(1)
    @Tag("sii")
    @Tag("regression")
    void checkTitleForSii(String expectedTitle) {
        driver.get("https://www.sii.pl");
        driver.manage().window().maximize();
        String actualTitle = driver.getTitle();
        assertThat(actualTitle).isEqualTo(expectedTitle);
    }

    @ParameterizedTest
    @ValueSource(ints = {2, 6, 8})
    @Order(2)
    @Tag("add")
    @Tag("regression")
    void add3(int firstInt, int secondInt, int result) {
        Car car = new Car();
        int actualResult = car.add(firstInt, secondInt);
        int expectedResult = result;
        assertThat(actualResult).isEqualTo(expectedResult);
    }
    @Test
    @Order(3)
    @Tag("add")
    @Tag("regression")
    void add4() {
        Car car = new Car();
        int actualResult = car.add(3, 5);
        int expectedResult = 8;
        assertThat(actualResult).isEqualTo(expectedResult);
    }
    @Test
    @Order(4)
    @Tag("add")
    @Tag("regression")
    void add5() {
        Car car = new Car();
        int actualResult = car.add(3, 4);
        int expectedResult = 7;
        assertThat(actualResult).isEqualTo(expectedResult);
    }
    @Test
    @Order(5)
    @Tag("add")
    @Tag("regression")
    void add6() {
        Car car = new Car();
        int actualResult = car.add(3, 3);
        int expectedResult = 6;
        assertThat(actualResult).isEqualTo(expectedResult);
    }

}