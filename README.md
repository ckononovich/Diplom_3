# Diplom_3

Technologies used: Java11, JUnit 4.13.2, RestAssured 5.3.1, Selenium 3.141.59;
To run tests for yandex browser, use the command: mvn clean test -DdriverType=yandex "-DpathYandexDriver=1" "-DyandexBrowser= 2" , where 1 is path to yandexdriver.exe and 2 is path to browser.exe;
To generate the report: mvn clean test, mvn allure:serve;
