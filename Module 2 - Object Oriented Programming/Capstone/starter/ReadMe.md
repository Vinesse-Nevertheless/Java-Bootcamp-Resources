# Stock Trading Simulation

This is my solution to the capstone project found Udemy: Become an Experienced Java Developer with Just One Course. Fully Updated with 100+ Coding Challenges!.
It represents most of the concepts learned in the course.

I have detailed the instructor's requirements and hints below, but a more detailed version with graphical presentations can be found here:
https://www.learnthepart.com/course/2dfda34d-6bbc-4bd5-8f45-d5999de2f514/d10bc2a7-40e9-47a2-88f4-38cb3614724a

<i>From the course: </i>
## Instructions
The instructions are not detailed because there are many ways to solve this challenge. It's up to you to come up with a plan of action.

### a) Open the starter project

### b) Inheritance
From the requirements, identify the parent and children classes.

### c) Test-Driven Development
Test-Driven Development: Writing tests before writing code.

Read the requirements before writing any of the following unit tests.

<b>Buy Tests:</b>

- Shares of a stock for a Personal account increase after purchase.
- Shares of a stock for a TFSA increase after purchase.
- No shares are added in the event of insufficient funds.
- Funds available in a Personal account decrease after purchase.
- Funds available in a TFSA decrease after purchase (must account for TRADE_FEE).

<b>Sell Tests:</b>

- Shares of a stock for a Personal account decrease after purchase.
- Shares of a stock for a TFSA decrease after purchase.
- No funds are added if shares being sold exceeds shares owned.
- Funds available in a Personal account increase after sale (must account for SALE_FEE).
- Funds available in a TFSA increase after sale (must account for TRADE_FEE).

### d) Aesthetics
Your children classes must inherit this toString.

    public String toString() {
        return "\n  Stock\t\t"  + Color.RESET + "Shares" +
        "\n\n" + displayPortofolio() + Color.RESET +
        "\n  Funds Left\t" + Color.GREEN + "$" + round(this.getFunds()) + Color.RESET;
    }
    
### e) Main

Your Main class contains pre-defined methods.


<b>Part 1</b>

First, call the method that explains the application to the user.


<b>Part 2</b>

After the user chooses an account, call the method that displays their initial balance.


<b>Part 3</b>

There are 2160 records in each CSV file. Create a loop that runs from 1 to 2160.

During each run, display the prices (see part 4 first).


<b>Part 4</b>

You must learn to stream the elements of a CSV file. Inside getPath(), use the following code to return the Path of the CSV file.

Path path = Paths.get(Thread.currentThread().getContextClassLoader().getResource("src/main/data/"+stock+".csv").toURI());

Catch the checked exception as needed. Windows users, remember to use the backslash.


<b>Part 5</b>

Complete the getPrice() method.

<b>Hints:</b>

- You can run through all lines as a stream of elements using: Files.lines(path).

- You must skip the first element in each file (the column headers). You can skip an element in a stream using .skip(element number).

<b>- Intermediate Operations:</b>

    .filter(filter value that matches day)
    .map(map to price value)
    
<b>- Terminal Operations:</b>
    .findFirst()
    .orElse(null)
    
    
<b>Part 6</b>

After displaying the prices, ask the user to

- buyOrSell()
- chooseStock()
- numShares()

Then execute the buy/sell trade with your Account object.

<b>Part 7</b>


Call tradeStatus() to notify the user of a "successful" or "unsuccessful" trade.
