import java.util.Objects;

public class MoodAnalyser {

   private String message;
    private String returnMessage;

    //no-arg constructor
    public MoodAnalyser()
    {

    }

    //parametrized constructor
    public MoodAnalyser(String message)
    {
        this.message = message;
    }

    public String analyseMood(String message) throws MoodAnalysisException
    {
        this.message = message;
        return  analyseMood();
    }

    // Overloading analysedMood method
    public String analyseMood() throws MoodAnalysisException
    {
        try
        {
            if (message.length() == 0)
            {
                throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.ENTERED_EMPTY,"Please enter proper mood");
            }
            returnMessage= (message.contains("Sad")) ? "SAD":"HAPPY";
        }
        catch (NullPointerException e)
        {
            return "HAPPY";
        }
       return returnMessage;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
            return true;
        if (!(obj instanceof MoodAnalyser))
            return false;
        MoodAnalyser that = (MoodAnalyser) obj;
        return Objects.equals(message, that.message) && Objects.equals(returnMessage, that.returnMessage);
    }

    @Override
    public int hashCode()
    {
        return  Objects.hash(message, returnMessage);
    }
}