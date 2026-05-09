public void pickTime() {

    waitUntilElementClickable(evening_icon);
    evening_icon.click();

    By slotLocator = By.xpath("//div[contains(text(),'6PM-7PM')]");

    WebElement slotElement = getWait().until(driver -> {

        try {

            WebElement el = driver.findElement(slotLocator);

            return (el.isDisplayed() && el.isEnabled()) ? el : null;

        } catch (Exception e) {
            return null;
        }
    });

    ((JavascriptExecutor) driver)
            .executeScript("arguments[0].click()", slotElement);

    waitUntilElementClickable(proceed);

    ((JavascriptExecutor) driver)
            .executeScript("arguments[0].click()", proceed);
}
