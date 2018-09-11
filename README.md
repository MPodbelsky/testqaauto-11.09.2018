**Environment setup:**
1. Download ItelliJIDEA.exe file from https://www.jetbrains.com/idea/download/#section=windows link;
Launch install file and select your operating system(32bit or 64bit).
2. Download JDK install file from http://www.oracle.com/technetwork/java/javase/downloads/jdk10-downloads-4416644.html link;
Launch JDK.exe file and accept all the requirements.
3. Install the latest version of Firefox browser (https://www.mozilla.org/ru/firefox/new/).
4. Download the geckodriver version for your operating system (https://github.com/mozilla/geckodriver/releases);
Put the file from archive to the root folder "System32".

**Files in my project:**
1. Package "page" contains all pages of tests that needs for this project. 
2. Package "test" contains BaseTest and GoogleSearchTest.

**To run tests via command line:**
1. Install Maven from (https://maven.apache.org/download.cgi) to the program files
2. Create parametr "mvn" in your system(name: mvn, path:C:\Program Files\apache-maven-3.5.4\bin)
3. Enter mvn clean install -DsuteName.xml.