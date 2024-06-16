package glue;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

public class GoogleSteps {

    @Given("url {string} is launched")
    public void url(String url) {
        W.get().driver.get(url);
        acceptCookiesIfWarned();
    }

    private static void acceptCookiesIfWarned() {
        try {
            W.get().driver.findElement(By.cssSelector("#L2AGLb")).click();
        } catch (NoSuchElementException ignored) {
        }
    }

    @When("About page is shown")
    public void aboutPageIsShown() {
       W.get().driver.findElement(By.xpath("//a[text()='About']")).click();
    }



    @Then("page displays {string}")
    public void pageDisplays(String arg0) {
        
    }

    @When("searching for {string}")
    public void searchingFor(String arg0) {
        
    }

    @Then("results contain {string}")
    public void resultsContain(String arg0) {
        
    }

    @And("result stats are displayed")
    public void resultStatsAreDisplayed() {
        
    }

    @And("number of {string} is more than {int}")
    public void numberOfIsMoreThan(String arg0, int arg1) {
    }
}
