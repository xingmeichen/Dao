package com.dao.automation.utils;

import com.dao.automation.enums.BrowserEnum;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * @project: Dao
 * @description:
 * @author: Mabel.Chen
 * @create: 2021-10-12 15:44
 **/
public class DriverUtil {

    public static WebDriver getDriver(BrowserEnum browser) {
        WebDriver webDriver = null;
        switch (browser) {
            case CHROME:
                webDriver = createChrome();
                break;
            case INTERNET_EXPLORER:
                webDriver = createIE();
                break;
            case EDGE:
                webDriver = createEdge();
                break;
            default: throw new RuntimeException("there is no this kind of browser!");
        }
        return webDriver;
    }

    private static WebDriver createChrome() {
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        configureCommonCapabilities(capabilities);
        ChromeOptions options = new ChromeOptions();
        options.merge(capabilities);
        options.setExperimentalOption("useAutomationExtension", false);
        System.setProperty("webdriver.chrome.driver", ConfigurationUtil.getChromeDriver());
        WebDriver driver = new ChromeDriver(options);
        return driver;
    }

    private static WebDriver createIE() {
        DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
        configureCommonCapabilities(capabilities);
        capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
        InternetExplorerOptions options = new InternetExplorerOptions();
        options.merge(capabilities);
        System.setProperty("webdriver.ie.driver", ConfigurationUtil.getIEDriver());
        WebDriver driver = new InternetExplorerDriver(options);
        return driver;
    }

    private static WebDriver createEdge() {
        DesiredCapabilities capabilities = DesiredCapabilities.edge();
        configureCommonCapabilities(capabilities);
        EdgeOptions options = new EdgeOptions();
        options.merge(capabilities);
        System.setProperty("webdriver.edge.driver", ConfigurationUtil.getEdgeDriver());
        WebDriver driver = new EdgeDriver(options);
        return driver;
    }

    /***
     * configuration references
     * https://www.selenium.dev/documentation/webdriver/capabilities/shared_capabilities/
     * https://www.selenium.dev/documentation/webdriver/capabilities/driver_specific_capabilities/
     */
    private static DesiredCapabilities configureCommonCapabilities(DesiredCapabilities capabilities) {
        capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        capabilities.setCapability(CapabilityType.SUPPORTS_APPLICATION_CACHE, true);
        capabilities.setCapability(CapabilityType.ELEMENT_SCROLL_BEHAVIOR, true);
        capabilities.setCapability(CapabilityType.UNHANDLED_PROMPT_BEHAVIOUR, UnexpectedAlertBehaviour.ACCEPT);
        capabilities.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.ACCEPT);
        capabilities.setJavascriptEnabled(true);
        return capabilities;
    }
}