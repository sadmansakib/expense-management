package org.sadmansakib.expensemanagement;

import org.junit.jupiter.api.Test;
import org.springframework.modulith.core.ApplicationModules;

public class ModularityTest {
    ApplicationModules modules = ApplicationModules.of(Application.class);

    @Test
    void verifyPackageConformity() {
        System.out.println(modules.toString());
        modules.verify();
    }
}
