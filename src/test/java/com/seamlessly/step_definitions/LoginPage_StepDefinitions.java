package com.seamlessly.step_definitions;

import com.seamlessly.pages.LoginPage;
import com.seamlessly.utilities.ConfigurationReader;
import com.seamlessly.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPage_StepDefinitions {

    LoginPage loginPage = new LoginPage();

    @Given("User is on the home page")
    public void userIsOnTheHomePage() {
        Driver.getDriver().get(ConfigurationReader.getProperty("loginURL"));
    }

    @When("user can write username")
    public void userCanWriteUsername() {
        loginPage.userName.sendKeys("Employee170");
    }

    @And("user can write password")
    public void userCanWritePassword() {
        loginPage.inputPassword.sendKeys("Employee123");
    }

    @And("user can click login button")
    public void userCanClickLoginButton() {
        loginPage.loginButton.click();
    }

    @Then("user can see dashboard")
    public void userCanSeeDashboard() {
        Driver.getDriver().getCurrentUrl().contains("dashboard");
    }
}
