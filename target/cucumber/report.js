$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/java/features/Login.feature");
formatter.feature({
  "name": "To test first Testing Framework",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "To validate Login functionality",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "application is launched",
  "keyword": "Given "
});
formatter.match({
  "location": "stepDefinitions.Login.launchApplication()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "click Sign In",
  "keyword": "Then "
});
formatter.match({
  "location": "stepDefinitions.Login.clickSignIn()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "provide credentials",
  "keyword": "Then "
});
formatter.match({
  "location": "stepDefinitions.Login.provideCredentials()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "click Login",
  "keyword": "Then "
});
formatter.match({
  "location": "stepDefinitions.Login.clickLogin()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "verify title of page",
  "keyword": "And "
});
formatter.match({
  "location": "stepDefinitions.Login.verifyTitle()"
});
formatter.result({
  "error_message": "java.lang.AssertionError: expected [Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in] but found [Authentication required]\r\n\tat org.testng.Assert.fail(Assert.java:97)\r\n\tat org.testng.Assert.assertEqualsImpl(Assert.java:136)\r\n\tat org.testng.Assert.assertEquals(Assert.java:118)\r\n\tat org.testng.Assert.assertEquals(Assert.java:575)\r\n\tat org.testng.Assert.assertEquals(Assert.java:585)\r\n\tat webApplication.testingFramework.common.assertions.assertEqualValue(assertions.java:16)\r\n\tat stepDefinitions.Login.verifyTitle(Login.java:82)\r\n\tat ✽.verify title of page(file:///G:/eclipse-workspace/TestingFramework/src/test/java/features/Login.feature:11)\r\n",
  "status": "failed"
});
});