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
    public String analyseMood(String message) throws MoodanalysisException
    {
        this.message = message;
        return  analyseMood();
    }

    // Overloading analysedMood method
    public String analyseMood() throws MoodanalysisException
    {
        try
        {
            if (message.length() == 0)
            {
                throw new MoodanalysisException(MoodanalysisException.ExceptionType.ENTERED_EMPTY,"Please enter proper mood");
            }
            returnMessage= (message.contains("sad")) ? "SAD":"HAPPY";
        }
        catch (NullPointerException e)
        {
            throw new MoodanalysisException(MoodanalysisException.ExceptionType.ENTERED_NULL,"Please enter proper message");
        }
       return returnMessage;
    }
}