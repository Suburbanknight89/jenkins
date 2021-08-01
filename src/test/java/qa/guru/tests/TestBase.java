package qa.guru.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;
import qa.guru.helpers.Attach;

import static qa.guru.tests.config.Credentials.credentials;
import static java.lang.String.format;

public class TestBase {

	@BeforeAll
	static void setup() {
		String login = credentials.login();
		String password = credentials.password();
		SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("enableVNC", true);
		capabilities.setCapability("enableVideo", true);

		Configuration.browserCapabilities = capabilities;
		Configuration.startMaximized = true;
		Configuration.baseUrl = "https://demoqa.com";
		Configuration.remote = format("https://%s:%s@" + System.getProperty("url"), login, password);
	}

	@AfterEach
	public void tearDown() {
		Attach.screenshotAs("Last screenshot");
		Attach.pageSource();
		Attach.browserConsoleLogs();
		Attach.addVideo();
	}
}