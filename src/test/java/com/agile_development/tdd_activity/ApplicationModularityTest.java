package com.agile_development.tdd_activity;

import org.junit.jupiter.api.Test;
import org.springframework.modulith.core.ApplicationModules;
import org.springframework.modulith.docs.Documenter;

public class ApplicationModularityTest {
    @Test
    void verifyModularStructure() {
        ApplicationModules modules = ApplicationModules.of(TddActivityApplication.class);
        modules.verify();
    }
    @Test
    void generateModuleDocumentation() {
        ApplicationModules modules = ApplicationModules.of(TddActivityApplication.class);
        new Documenter(modules)
                .writeDocumentation()
                .writeIndividualModulesAsPlantUml();
    }
}
