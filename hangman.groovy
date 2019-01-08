// class Hangman{

//     private String theWord;
//     private String wordArr;
//     private String wordDisplay;

//     Hangman(String theWord){
//         this.theWord = theWord;

//         String[] this.wordArr = theWord.split('');

//         String this.wordDisplay = [];
//         for (int i = 0; i < wordArr.size(); i++){
//             wordDisplay.add('-')
//         }
//     }

//     def getTheWord(){
//         return this.theWord;
//     }

//     def display(){
//         println(this.wordDisplay);
//     }

//     def guess(){
//         println("Guess a letter.");
//         String guess = System.in.newReader().readLine() as String;
//     }
// }







public static void main(String[] args){    

    println("Pass the computer to Player 1 and enter a word for Player 2 to guess.")
    String word = System.in.newReader().readLine();
    String[] wordArr = word.toLowerCase().split('');

    def hiddenWord = [];
    for (int i = 0; i < wordArr.size(); i++){
        hiddenWord.add('-');
    }
    def lettersGuessed = [];

    println("Now pass the computer to Player 2. Let the Game begin!")
    int guessesLeft = 9;
    while(hiddenWord.contains('-') && guessesLeft > 0){
        println("Word: " + hiddenWord);
        println("Guess a letter");
        String userGuess = System.in.newReader().readLine() as String;
        if(!lettersGuessed.contains(userGuess)){
            if(wordArr.contains(userGuess)){
                println("'${userGuess}' is in the word!");
                
                for(int i = 0; i < wordArr.size(); i++){
                    if(wordArr[i] == userGuess){
                        hiddenWord[i] = userGuess;
                    }
                }
                lettersGuessed.add(userGuess);

                println("Letters Guessed: " + lettersGuessed);
            } else {
                lettersGuessed.add(userGuess);
                guessesLeft--;
                println("'${userGuess}' is not in the word. You have ${guessesLeft} guesses left")
                println("Letters Guessed: " + lettersGuessed);
            }
        } else {
            println("You already guessed that. Try again!")
        }
    }

    if(guessesLeft == 0){
        println("You Lose!");
    } else {
        println("You win!");
    }

}