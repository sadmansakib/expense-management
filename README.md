# Expense Management System

This project is a simple expense management system built using Java, Spring Boot, and Gradle. The system allows users to manage their expenses by categorizing them and keeping track of their budget.

## Modules

### Category Domain

This module is responsible for managing categories of expenses. It includes classes and interfaces such as `CategoryEventPublisher` and `CategoryUpdater`.

- `CategoryEventPublisher`: This interface defines methods for publishing events related to categories. It includes methods like `updateBudgetSpent` which is used to update the amount spent from a budget.

- `CategoryUpdater`: This class is responsible for updating categories. It uses `CategoryEventPublisher` to publish events when a category is updated.

### Budget Domain

This module is responsible for managing budgets. It includes classes like `BudgetSpent`.

- `BudgetSpent`: This class represents an event that occurs when an amount is spent from a budget. It implements the `DomainEvent` interface.

## Modules

### Expense Domain

This module is responsible for managing expenses. It includes classes and interfaces such as `ExpenseEventPublisher` and `ExpenseUpdater`.

- `ExpenseEventPublisher`: This interface defines methods for publishing events related to expenses. It includes methods like `addExpense` which is used to add an expense to a category.

- `ExpenseUpdater`: This class is responsible for updating expenses. It uses `ExpenseEventPublisher` to publish events when an expense is added.

## Setup

To set up the project, follow these steps:

1. Clone the repository.
2. Open the project in IntelliJ IDEA.
3. Run the Gradle build task to build the project.
4. Run the application.

