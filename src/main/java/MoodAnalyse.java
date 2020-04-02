public class MoodAnalyse {

    String message;
    String returnMessage;

    //no-arg constructor
    public MoodAnalyse()
    {

    }

    //parametrized constructor
    public MoodAnalyse(String message)
    {
        this.message = message;
    }
    public String analyseMood(String message)
    {
        this.message = message;
        return  analyseMood();
    }

    // Overloading analysedMood method
    public String analyseMood()
    {
        try
        {
            returnMessage = (message.contains("Sad")) ? "Sad":"HAPPY";
        }
        catch (NullPointerException e)
        {
            return "HAPPY";
        }
       return returnMessage;
    }
}