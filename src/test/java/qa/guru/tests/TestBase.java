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
		SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("enableVNC", true);
		capabilities.setCapability("enableVideo", true);
		String login = credentials.login();
		String password = credentials.password();
		String browser = System.getProperty("link");

		Configuration.browserCapabilities = capabilities;
		Configuration.startMaximized = true;
		Configuration.remote = format("https://%s:%s@%s", login, password, browser);
		Configuration.startMaximized = true;
	}

	@AfterEach
	public void tearDown() {
		Attach.screenshotAs("Last screenshot");
		Attach.pageSource();
		Attach.browserConsoleLogs();
		Attach.addVideo();
	}
}