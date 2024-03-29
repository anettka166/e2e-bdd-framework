package com.academy.techcenture.pages;

import com.academy.techcenture.utils.CommonUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import java.time.Duration;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected CommonUtils commonUtils;
    protected static Logger log = LoggerFactory.getLogger(BasePage.class);
    protected Actions actions;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        this.commonUtils = new CommonUtils();
        this.actions = new Actions(this.driver);
        PageFactory.initElements(driver, this);
    }
}
