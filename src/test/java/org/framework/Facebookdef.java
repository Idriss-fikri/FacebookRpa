package org.framework;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class Facebookdef {
    WebDriver driver2;
    WebElement searchbar;
    WebElement GlobalelementDecscription ;

    @Given("the user opens Chrome browser")
    public void theUserOpensChromeBrowser() {
        //on ajouter des options pour gerier les notifcaitons generer par le navigauteur
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("profile.default_content_setting_values.notifications", 2);
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", map);
        driver2 = new ChromeDriver(options);
        driver2.manage().deleteAllCookies();
        System.setProperty("webdriver.chrome.driver", "src/test/java/org/myexample/chromedriver11.exe");
        driver2.get("https://www.google.com/");
        driver2.manage().window().maximize();  // maximizing my browser
        driver2.findElement(By.id("L2AGLb")).click(); // acceptin the cookie.
    }

    @And("the user is on the Google homepage")
    public void theUserIsOnTheGoogleHomepage() {
        driver2.findElement(By.name("q")).clear();
        driver2.findElement(By.name("q")).click();

    }

    @When("the user searches for {string} and navigates to the login page")
    public void theUserSearchesForAndNavigatesToTheLoginPage(String arg0) {
        driver2.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // waiting 10 second

        searchbar = driver2.findElement(By.name("q"));
        searchbar.sendKeys(arg0);
        searchbar.sendKeys(Keys.RETURN); // Return reference on the ENTER on our keyBord

        // part of navigation on the login page

        driver2.findElement(By.cssSelector("a[href*='facebook.com']")).click();
        try {
            driver2.findElement(By.cssSelector("button[value='1']._42ft._4jy0._9xo7._4jy3._4jy1.selected._51sy")).click();
        } catch (Exception e) {
            System.out.println("NOT FOUND");
        }
        // on a decider de faire lever des exeption car parfois qu'on accéde au site y'a plus de cookie
        // et sa peu bloquer nos cas test , donc on a fait un try->catch .
    }

    @And("enters their email and password")
    public void entersTheirEmailAndPassword() {
        driver2.findElement(By.id("email")).clear(); //si ya deja quelque chose ecrite pour ne pas ecraser
        driver2.findElement(By.id("email")).sendKeys("miagerpa12@gmail.com");
        driver2.findElement(By.id("pass")).clear();
        driver2.findElement(By.id("pass")).sendKeys("Miagerpa1234..");
        driver2.findElement(By.name("login")).click();
    }

    @Then("they are taken to the Facebook homepage")
    public void theyAreTakenToTheFacebookHomepage() {
        // des fois on peut seleinum et cucmber peut pas interagir avec les balises svg

        WebElement parentElement = driver2.findElement(By.xpath("//*[contains(@class, 'x1lliihq x1k90msu x2h7rmj x1qfuztq')]"));

// Perform a click on the parent element
        parentElement.click();
    }

    @And("they navigate to the Create post section")
    public void theyNavigateToTheCreatePostSection() {
        WebElement element = driver2.findElement(By.cssSelector(".x1i10hfl.x6umtig.x1b1mbwd.xaqea5y.xav7gou.x9f619.x1ypdohk.xe8uvvx.xdj266r.x11i5rnm.xat24cr.x1mh8g0r.x16tdsg8.x1hl2dhg.xggy1nq.x87ps6o.x1lku1pv.x1a2a7pz.x6s0dn4.xmjcpbm.x107yiy2.xv8uw2v.x1tfwpuw.x2g32xy.x78zum5.x1q0g3np.x1iyjqo2.x1nhvcw1.x1n2onr6.xt7dq6l.x1ba4aug.x1y1aw1k.xn6708d.xwib8y2.x1ye3gou"));
        element.click();


    }
    @And("they add a description to the picture{string}")
    public void theyAddADescriptionToThePicture(String arg0) {
        GlobalelementDecscription  = driver2.findElement(By.cssSelector(".xzsf02u.x1a2a7pz.x1n2onr6.x14wi4xw.x9f619.x1lliihq.x5yr21d.xh8yej3.notranslate"));
        GlobalelementDecscription.click();
        GlobalelementDecscription.sendKeys(arg0);
    }


    @Then("they click the Post button")
    public void theyClickThePostButton() {
        GlobalelementDecscription.submit();


    }

}

