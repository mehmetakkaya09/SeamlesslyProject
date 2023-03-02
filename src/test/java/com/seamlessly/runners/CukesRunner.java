package com.seamlessly.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"rerun:target/rerun.txt",
                "html:target/cucumberReport.html",
                "me.jvt.cucumber.report.PrettyReports:target/cucumber",
                "json:target/cucumber-report.json"
        },
        features = "src/test/resources/features",
        glue = "com/seamlessly/step_definitions",
        tags = "",
        dryRun = false
)
public class CukesRunner {
}
