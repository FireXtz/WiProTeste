package org.WiPro.Test.executores;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;
@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/main/resources/features/cep.feature",
        glue = "org.example.Test.passos",
        plugin = "pretty",
        monochrome = true,
        snippets = SnippetType.CAMELCASE,
        dryRun = false,
        strict = false
)
public class ExecutorTeste {}
