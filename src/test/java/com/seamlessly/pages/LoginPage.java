package com.seamlessly.pages;

import com.seamlessly.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(id="user")
    public WebElement userName;

    @FindBy(id = "password")
    public WebElement inputPassword;

    @FindBy(id = "submit-form")
    public WebElement loginButton;
    public void login(String username, String password) {
        userName.sendKeys(username);
        inputPassword.sendKeys(password);
        loginButton.click();
    }

    @FindBy(id = "lost-password")
    public WebElement forgotPassword;

    @FindBy(xpath = "//*[normalize-space(text()) = 'Log in with a device']")
    public WebElement linkLogWithDevice;

    @FindBy(xpath = "//*[normalize-space(text()) = 'Seamlessly']")
    public WebElement divSeamlessly;

    @FindBy(xpath = "//*[text() = 'Seamlessly']")
    public WebElement linkSeamlessly;

    @FindBy(xpath = "//*[normalize-space(text())= 'Seamlessly – Impeccable Efficiency']")
    public WebElement impeccableEfficiency;//TODO check this locator

    @FindBy(xpath = "//a[@class='toggle-password']")
    public WebElement passwordEye;


    @FindBy(css = "p.warning.wrongPasswordMsg")
    public WebElement wrongPassword;

    @FindBy(xpath = "//input[@id='user' and @required='required']")
    public WebElement blankText;

    @FindBy(id = "reset-password-submit")
    public WebElement resetPassword;
}
