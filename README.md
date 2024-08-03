# What do I want this app to do.

# What exactly do I use my budget spreadsheet for.
I spend a lot of time rice'ing it with the main goal of, on payday, logging on
knowing how much I have after all the bills are paid, adjusting via the transfer boxes,
seeing my credit cards and their balances, entering the ammount I plan to pay, 
submitting the plan, and viewing the payment log. 

My goal is peace of mind. I want to know how much is coming in and out down to
the penny. To achieve that, I carefully calculate 
- How much I need to put into chase savings for bills.
- How much each bill costs and when it's due
- How much chase savings *needs* to have on any given day.

What values do I have to enter manually.
- Bill ammounts
- How much I plan on putting toward's Jordan's budget.
- Income ammounts
- Deduction ammounts
- Any unplanned transfers

# Differences between EveryDollar and my spreadsheet.
- I use the everydollar app to track and categorize my transactions
- I use the spreadsheed to execute credit card payments. For that to work well,
I need it to know exactly how much is available to use. Basically, the main 
function is giving me a highly accurate "remainder" that I can budget after
the necessities have been met. 

## Nice to have
- Track how much I've made this year
- automatically adjust taxes based on bracket


## Objects
- LineItem
    - name
    - amount
    - Optional date
    - frequency of date
    - Optional payment method
    - description
    - category
    - Line items include
- Debt
Is debt considered a line item?
    - name
    - amount
    - Minimum Payment
    - payment method
    - due date
    - interest rate
    - frequency of due date
## Things I need to do in the GUI;
- Visually see where my money is going
- CRUD
    - Line item
    - category
- Apply planned payments to Debts


## Paycheck
### Things that come out before the money gets to my account
- Jordan's Budget
- Bill savings
- HSA
- Dental
- Medical
- 401k

### Saturday 08/03/2024:
Ok I don't know exactly what this will look like in the end, but I do know the 
foundational objects. I think the best use of my time would be integrating DB,
backend, and frontend. I should probably write tests for the repo's before
starting on the front end so that i know it works well.
