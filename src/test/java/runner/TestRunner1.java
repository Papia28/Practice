package runner;

import org.testng.annotations.Test;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = "src/test/java/features/", 
		glue = "stepDefinitions", 
		plugin = { "pretty", "html:target/cucumber" },
		tags = {"@DragAndDrop1"},
		strict = true
)

@Test
public class TestRunner1 extends AbstractTestNGCucumberTests {

}


/* tags = {"@Select","@DragAndDrop"} means ANDing of tags : This will execute scenarios which are tagged as 
 * both @Select AS WELL AS @DragAndDrop.
 * ANDing of tags runs the intersection of the tagged scenarios
 * i.e. scenarios which fall both under @Select AND @DragAndDrop will be executed 
 */

/* tags = {"@Select,@DragAndDrop"} means ORing of tags : This will execute scenarios which are 
 * either tagged as @Select or as @DragAndDrop.
 * ORing of tags mean union of the tagged scenarios
 * i.e. scenarios which either fall under @Select OR under @DragAndDRop will be executed
 */