Scripts

// scroll to view
JavascriptExecutor executor = (JavascriptExecutor) driver;
    executor.executeScript("arguments[0].scrollIntoView(true);", element1);

// implicit wait
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

// explicit wait
