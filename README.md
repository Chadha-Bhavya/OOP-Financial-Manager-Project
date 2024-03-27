# Finance Management System

## Application Functionality ##

The Personal Finance Manager System is designed to 
help users manage their finances effectively. Users can 
record and categorize financial transactions (based on categories like housing,
groceries), view their earnings,  budgets, and gain insights into their spending 
habits. The application provides a console-based interface for adding income,
expenses, viewing financial summaries, setting budgets, and saving/loading 
financial states.

## Target Users ##

This application is intended for individuals who want a simple and 
effective tool for managing their personal finances. It is suitable 
for anyone looking to track their income, expenses, and budgets without 
the complexity of larger financial management software.

## Project's Interest

- **Real-world Relevance**: Personal finance management is a universal concern,
and developing a tool to assist individuals aligns with real-world needs.
The ability to track and analyze financial data is valuable for anyone 
seeking better control over their financial situation.
- **Technical Challenge**: Designing a console-based application with a clear 
model-view separation, state persistence, and non-trivial classes provides
a technical challenge.
- **User Experience Consideration**: While the initial phase is console-based,
future phases can involve transitioning to a graphical user interface. 
This adds an interesting aspect of considering user experience design 
and usability as the application evolves.

## User Stories ##

- As a user, I would be able to add my earnings to the finance management system.
- As a user, I would be able to add my expenses to the finance management system.
- As a user, I would be able to view all my past earnings in the finance management system.
- As a user, I would be able to view all my past expenses in the finance management system.
- As a user, I can categorize financial transactions/expenses  based on categories like
  Housing, Food, Recreation, Transportation, HealthCare and Insurance and Miscellaneous
- As a user, I would be able to view my expenses based on specific categories to help me understand 
my finance at a better level.
- As a user, I can set my expenses limit and the system will warn me if I cross
my expenses limit.
- As a user, I would be able to save my financial transactions if I wish to do so.
- As a user, I would be able to load my financial transactions if I wish to do so - when I restart the application.

# Instructions for Grader

- You can add earnings by entering the amount in the `Earning` field and clicking the `Add Earning` button.
- You can add expenses by entering the amount in the `Expense` field, the category in the `Category` field, 
and then clicking the `Add Expense` button.
- You can locate the visual component by running the application. A splash screen will appear for 5 seconds, 
displaying an image that simulates the loading of the application.
- You can save the application's state by clicking the `Save Data` button.
- You can reload the application's state by clicking the `Load Data`button.
- You can set your expense limit by entering the limit in the `Expense Limit` field and clicking the
`Set Expense Limit` button. The system will warn you if the expense limit is exceeded.
- You can view all past earnings or expenses by clicking the `View Earnings` or `View Expenses` button, respectively.
- You can view your net earnings (total earnings - total expenses) by clicking the `Net Earning` button.
- You can view all earnings or expenses above a certain criteria by entering the criteria in the `Criteria` field
and then clicking the `View Earnings Above Criteria` or `View Expenses Above Criteria` button.
