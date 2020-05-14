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
});