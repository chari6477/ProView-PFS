$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("features/Core_AZIndex.feature");
formatter.feature({
  "line": 2,
  "name": "A-Z Index",
  "description": "",
  "id": "a-z-index",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@Core"
    }
  ]
});
formatter.background({
  "line": 4,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 5,
  "name": "I launch ProView",
  "keyword": "When "
});
formatter.step({
  "line": 6,
  "name": "I sign in",
  "keyword": "And "
});
formatter.step({
  "line": 7,
  "name": "I verify that I am in the library",
  "keyword": "Then "
});
formatter.step({
  "line": 8,
  "name": "I open the title \"AutomatedAZIndex\"",
  "keyword": "When "
});
formatter.step({
  "line": 9,
  "name": "I open the options menu",
  "keyword": "And "
});
formatter.step({
  "line": 10,
  "name": "I click on \"Layout\" option of Options Menu",
  "keyword": "And "
});
formatter.match({
  "location": "SignInSteps.i_launch_ProView()"
});
formatter.result({
  "duration": 8259934736,
  "status": "passed"
});
formatter.match({
  "location": "SignInSteps.i_sign_in()"
});
formatter.result({
  "duration": 57717100979,
  "status": "passed"
});
formatter.match({
  "location": "LibrarySteps.i_verify_that_I_am_in_the_library()"
});
formatter.result({
  "duration": 273178057,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "AutomatedAZIndex",
      "offset": 18
    }
  ],
  "location": "LibrarySteps.i_open_the_title(String)"
});
formatter.result({
  "duration": 1527198363,
  "status": "passed"
});
formatter.match({
  "location": "OptionsMenuSteps.i_open_the_options_menu()"
});
