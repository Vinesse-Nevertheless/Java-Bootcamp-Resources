# Hangman
Hangman is a word-guessing game. It keeps asking the user to guess characters until:

They guess every character correctly (win).

They miss 6 guesses (loss).

## Instructions

### a) Download the starter project
In Java Bootcamp Resources -> Module 1 -> Casptone Project, you can find hangman. Open it.

### b) Choose a random word
In the starter project, I left you an array of words.

public static String[] words = {"ant", "baboon", "badger", "bat", "bear","beaver", "camel", "cat", "clam", "cobra", "cougar", "coyote", "crow", "deer", "dog", "donkey", "duck", "eagle", "ferret", "fox", "frog", "goat", "goose", "hawk", "lion", "lizard", "llama", "mole", "monkey", "moose", "mouse", "mule", "newt", "otter", "owl", "panda", "parrot", "pigeon", "python", "rabbit", "ram", "rat", "raven","rhino", "salmon", "seal", "shark", "sheep", "skunk", "sloth", "snake", "spider", "stork", "swan", "tiger", "toad", "trout", "turkey","turtle", "weasel", "whale", "wolf", "wombat", "zebra"};

Your game must choose a random word from this list of words.

The placeholders '_' in your game must reflect the number of characters in that word.

### c) Show the gallows
At every turn, you need to show the gallows.

In your starter project, you'll find an array: String[] gallows. Each String in the array reflects the number of times the user guessed incorrectly.

### d) Show the missed guesses
You need to keep track of every incorrect guess the user made. This helps the user not make the same mistake twice.

### e) Replace placeholders with correct guesses

### f) If the user wins:
Output the solution and "GOOD WORK!"
Stop the game.

### g) If the user wins:
Output "RIP!" and the solution.
Stop the game.


