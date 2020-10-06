package runner;

import org.testng.annotations.Test;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = "src/test/java/features/", 
		glue = "stepDefinitions", 
		plugin = { "pretty", "html:target/cucumber" },
		//tags = "@Upload or @DragAndDrop",
		tags = "@Textbox",
		strict = true,
		dryRun = false
)

@Test
public class TestRunnerToolsQA extends AbstractTestNGCucumberTests {
	
}


/**  
 *  1. use ~ to exclude tags
 *  2. strict = true - fails the build if steps have not been found or have been skipped
 *  3. dryRun = true - checks whether each step has corresponding code written in step definition file or not
 *  4. use "or"/"and" keywords to cimbine tags
 *  5. tags = "@Upload and not @DragAndDrop",
 *  6. tags = "@Upload and @DragAndDrop",
 */

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
