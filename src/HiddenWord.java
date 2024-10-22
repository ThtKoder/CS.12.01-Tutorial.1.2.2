public class HiddenWord {
    String hiddenWord;

    public HiddenWord(String hiddenWord){
        this.hiddenWord = hiddenWord.toUpperCase();
    }

    public String getHint(String guess){
        int l = 0;
        while(l < guess.length()){
            if(guess.charAt(l) >= 97 && guess.charAt(l) <= 127){
                String message = "Your guess ( " + guess + " ) does not contain all uppercase letters. Your guess must contain all uppercase letters!";
                System.out.println(message);
                throw new IllegalArgumentException(message);
            }
            l++;
        } //throws lowercase guesses

        if(guess.length() != hiddenWord.length()){
            String message = "Your guess ( " + guess + " ) has " + guess.length() + " characters. The hidden word has " + hiddenWord.length() + " characters. Your guess must be a word with " + hiddenWord.length() + " characters!";
            throw new IllegalArgumentException(message);
        } //throws incorrect guess length

        String answer = "";
        int i = 0;
        while(i < guess.length()) {
            System.out.println(answer);
            if(guess.charAt(i) == this.hiddenWord.charAt(i)){
                answer+=hiddenWord.charAt(i);
            }
            else if(hiddenWord.contains(guess.charAt(i)+"")){
                answer+="+";
            }
            else if(!hiddenWord.contains(guess.charAt(i)+"")){
                answer+="*";
            }
            i++;
        }
        return answer;
    }

    public String getHiddenWord() {
        return hiddenWord;
    }
}
