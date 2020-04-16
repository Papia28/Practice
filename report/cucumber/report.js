$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/java/webApplication/testingFramework/features/Login.feature");
formatter.feature({
  "name": "To test sample Testing Framework",
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
formatter.match({});
formatter.result({
  "status": "undefined"
});
});