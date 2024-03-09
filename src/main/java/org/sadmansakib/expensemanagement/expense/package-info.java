@ApplicationModule(allowedDependencies = {
        "category::domain",
        "shared::entity",
        "shared::persistence",
        "shared::response"
})
package org.sadmansakib.expensemanagement.expense;

import org.springframework.modulith.ApplicationModule;