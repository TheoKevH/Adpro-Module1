package id.ac.ui.cs.advprog.eshop.functional;

import io.github.bonigarcia.seljup.SeleniumJupiter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
@ExtendWith(SeleniumJupiter.class)
class CreateProductFunctionalTest {
    @LocalServerPort
    private int serverPort;

    @Value("${app.baseUrl:http://localhost}")
    private String testBaseUrl;

    private String baseUrl;

    @BeforeEach
    void setupTest() {
        baseUrl = String.format("%s:%d", testBaseUrl, serverPort);
    }

    @Test
    void createButton_IsDisplayed(ChromeDriver driver) throws Exception {
        driver.get(baseUrl + "/product/list");
        WebElement createButton = driver.findElement(By.xpath("//a[contains(text(),'Create Product')]"));
        assertTrue(createButton.isDisplayed());
    }

    @Test
    void createForm_IsDisplayed(ChromeDriver driver) throws Exception {
        driver.get(baseUrl + "/product/create");
        String pageTitle = driver.getTitle();
        assertEquals("Create New Product", pageTitle);
    }

    @Test
    void createProduct(ChromeDriver driver) throws Exception {
        driver.get(baseUrl + "/product/create");
        driver.findElement(By.id("nameInput")).sendKeys("Sampo Cap Bambang");
        driver.findElement(By.id("quantityInput")).sendKeys("10");
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        String currentUrl = driver.getCurrentUrl();
        assertEquals(baseUrl + "/product/list", currentUrl);
    }

    @Test
    void createMultipleProduct(ChromeDriver driver) throws Exception {
        driver.get(baseUrl + "/product/create");
        driver.findElement(By.id("nameInput")).sendKeys("Sampo Cap Tikus");
        driver.findElement(By.id("quantityInput")).sendKeys("1");
        driver.findElement(By.cssSelector("button[type='submit']")).click();

        driver.get(baseUrl + "/product/list");
        assertTrue(driver.findElements(By.xpath("//tbody/tr[1]/td[1]")).size() > 0);

        driver.get(baseUrl + "/product/create");
        driver.findElement(By.id("nameInput")).sendKeys("Sampo Cap Cip Cup");
        driver.findElement(By.id("quantityInput")).sendKeys("3");
        driver.findElement(By.cssSelector("button[type='submit']")).click();

        String currentUrl = driver.getCurrentUrl();
        assertEquals(baseUrl + "/product/list", currentUrl);

        assertEquals("Sampo Cap Tikus", driver.findElement(By.xpath("//tbody/tr[1]/td[1]")).getText());
        assertEquals("1", driver.findElement(By.xpath("//tbody/tr[1]/td[2]")).getText());
        assertEquals("Sampo Cap Cip Cup", driver.findElement(By.xpath("//tbody/tr[2]/td[1]")).getText());
        assertEquals("3", driver.findElement(By.xpath("//tbody/tr[2]/td[2]")).getText());
    }
}
