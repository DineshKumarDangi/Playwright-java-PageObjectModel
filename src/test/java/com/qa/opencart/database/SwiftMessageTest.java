package com.qa.opencart.database;

import com.microsoft.playwright.*;
import org.testng.Assert;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class SwiftMessageTest {
    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(true));
            Page page = browser.newPage();

            // Load the sample SWIFT HTML content
            page.setContent("""
                <!DOCTYPE html>
                <html>
                <head><title>SWIFT Message</title></head>
                <body>
                    <h1>SWIFT MT103 Message</h1>
                    <div id="swift-message">
                        <p><strong>Transaction Reference:</strong> TRX123456789</p>
                        <p><strong>Sender BIC:</strong> HDFCINBB</p>
                        <p><strong>Receiver BIC:</strong> CITIUS33</p>
                        <p><strong>Amount:</strong> USD 1500.00</p>
                        <p><strong>Value Date:</strong> 2026-05-25</p>
                    </div>
                </body>
                </html>
            """);

            // Assertions
            Locator trxRef = page.locator("text=Transaction Reference: TRX123456789");
            assertThat(trxRef).isVisible();
            System.out.println(trxRef.textContent());
            assertThat(trxRef).containsText("TRX123456789");
            assertThat(trxRef).containsText("TRX");


            Locator senderBIC = page.locator("text=HDFCINBB");
            assertThat(senderBIC).isVisible();

            Locator receiverBIC = page.locator("text=CITIUS33");
            assertThat(receiverBIC).isVisible();

            Locator amount = page.locator("text=USD 1500.00");
            assertThat(amount).isVisible();

            Locator valueDate = page.locator("text=2026-05-25");
            assertThat(valueDate).isVisible();

            System.out.println("✅ All SWIFT message fields validated successfully!");
            browser.close();
        }
    }
}
