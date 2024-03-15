@ApplicationModule(allowedDependencies = {"shared::entity","budget::domain",
        "shared::response", "shared::persistence", "shared::error"})
package org.sadmansakib.expensemanagement.category;

import org.springframework.modulith.ApplicationModule;