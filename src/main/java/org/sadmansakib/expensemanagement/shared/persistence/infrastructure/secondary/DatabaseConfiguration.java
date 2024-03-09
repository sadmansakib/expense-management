package org.sadmansakib.expensemanagement.shared.persistence.infrastructure.secondary;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaAuditing
@EnableJpaRepositories(basePackages = { "org.sadmansakib.expensemanagement" }, enableDefaultTransactions = false)
public class DatabaseConfiguration {
}
