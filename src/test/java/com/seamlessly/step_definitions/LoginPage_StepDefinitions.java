package com.seamlessly.step_definitions;

import com.seamlessly.pages.LoginPage;
import com.seamlessly.utilities.ConfigurationReader;
import com.seamlessly.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;

public class LoginPage_StepDefinitions {

    LoginPage loginPage = new LoginPage();

    @Given("User is on the login page")
    public void userIsOnTheHomePage() {
        Driver.getDriver().get(ConfigurationReader.getProperty("loginURL"));
    }


    @Then("user can see dashboard")
    public void userCanSeeDashboard() {
        Assert.assertTrue(Driver.getDriver().getTitle().toLowerCase().contains("dashboard"));
    }

    @When("user can click login button")
    public void userCanClickLoginButton() {
        loginPage.loginButton.click();
    }

    @When("user can write valid username")
    public void userCanWriteValidUsername() {
        loginPage.userName.sendKeys("Employee170");
    }

    @And("user can write valid password")
    public void userCanWriteValidPassword() {
        loginPage.inputPassword.sendKeys("Employee123");
    }

    @When("user can press enter key")
    public void userCanPressEnterKey() {
        loginPage.inputPassword.click();
        loginPage.inputPassword.sendKeys(Keys.ENTER);
    }

    @When("user can write invalid username {string}")
    public void userCanWriteInvalidUsername(String username) {
        loginPage.userName.sendKeys(username);
    }

    @When("user can write invalid password {string}")
    public void userCanWriteInvalidPassword(String password) {
        loginPage.inputPassword.sendKeys(password);
    }

    @Then("user cannot see dashboard and sees the notice wrong message")
    public void userCannotSeeDashboardAndSeesTheNoticeWrongMessage() {
        Assert.assertEquals(loginPage.wrongPassword.getText(), "Wrong username or password.");
    }

    @Then("user cannot see dashboard and sees the notice blank message")
    public void userCannotSeeDashboardAndSeesTheNoticeBlankMessage() {
        if (loginPage.userName.getAttribute("required").equals("required")) {
            Assert.assertEquals(loginPage.userName.getAttribute("validationMessage"), "Please fill out this field.");
        }
        if (loginPage.inputPassword.getAttribute("required").equals("required")) {
            Assert.assertEquals(loginPage.inputPassword.getAttribute("validationMessage"), "Please fill out this");
        }
    }

    @Then("user can see the password in a form of dots")
    public void userCanSeeThePasswordInAFormOfDots() {
        if (loginPage.inputPassword.getAttribute("type").equals("password")) {
            Assert.assertEquals(loginPage.inputPassword.getAttribute("value"), "Employee123");
        }
    }

    @And("User can click to toggle button")
    public void userCanClickToToggleButton() {
        loginPage.passwordEye.click();
    }

    @Then("User can see the password")
    public void userCanSeeThePassword() {
        Assert.assertEquals(loginPage.inputPassword.getAttribute("value"), "Employee123");
    }

    @Then("user can see the Forgot password link")
    public void userCanSeeTheForgotPasswordLink() {
        Assert.assertTrue(loginPage.forgotPassword.isDisplayed());
    }

    @And("User can click Forgot password link")
    public void userCanClickForgotPasswordLink() {
        loginPage.forgotPassword.click();
    }

    @And("User is on reset password page")
    public void userIsOnResetPasswordPage() {
        loginPage.resetPassword.isDisplayed();
    }

    @Then("user can see reset password link")
    public void userCanSeeResetPasswordLink() {
        Assert.assertTrue(loginPage.resetPassword.isDisplayed());
    }

    @Then("user can see username placeholder")
    public void userCanSeeUsernamePlaceholder() {
        Assert.assertEquals(loginPage.userName.getAttribute("placeholder"), "Username or email");
    }

    @Then("user can see password placeholder")
    public void userCanSeePasswordPlaceholder() {
        Assert.assertEquals(loginPage.inputPassword.getAttribute("placeholder"), "Password");
    }
}
