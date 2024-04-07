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

## Phase 4: Task 2 ##

- Sat Apr 06 21:26:56 PDT 2024 -> Added 300 to Earning
- Sat Apr 06 21:26:57 PDT 2024 -> Added 200 to Expense
- Sat Apr 06 21:27:00 PDT 2024 -> Added 500 to Earning
- Sat Apr 06 21:27:07 PDT 2024 -> Added 1000 to Expense
- Sat Apr 06 21:27:10 PDT 2024 -> New Expense Limit: 100000
- Sat Apr 06 21:27:13 PDT 2024 -> Read the Data
- Sat Apr 06 21:27:13 PDT 2024 -> New Expense Limit: -1
- Sat Apr 06 21:27:14 PDT 2024 -> Saved the Data
- Sat Apr 06 21:27:21 PDT 2024 -> Added 200 to Earning
- Sat Apr 06 21:27:22 PDT 2024 -> Added 100 to Earning

## Phase 4: Task 3 ##
Reflecting on the design presented in the UML class diagram, if I had more time to work on the project, I would 
consider implementing two additional classes in the model: `ListOfExpense` and `ListOfEarning`, rather than
solely relying on adding lists within the `Earning` and `Expense` classes. This modification would enhance the 
cohesion of the  codebase, making it more modular and easier to comprehend. Currently, the responsibility of 
adding earnings/expenses and managing the associated lists rests solely with the `Earning` and `Expense` classes, 
resulting in a somewhat convoluted structure. I would also implement the Iterator Design Pattern to Iterate over the
`Earning` and `Expense`.

Furthermore, I would prioritize refactoring the `GUI` and `FinancialManagementSystem` (Console) class by eliminating
repetitive code segments for improved readability and maintainability. By reducing redundancy 
in the codebase, we would be able to enhance the overall clarity of the code.

Although these changes would not introduce new features to the application, they 
would significantly contribute to its long-term maintainability and comprehensibility.