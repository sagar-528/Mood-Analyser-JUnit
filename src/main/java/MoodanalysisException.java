public class MoodanalysisException extends Exception
{
    public MoodanalysisException(ExceptionType type,String message)
    {
        super(message);
        this.type = type;
    }

    enum ExceptionType
    {
        ENTERED_NULL,ENTERED_EMPTY
    }
    ExceptionType type;


}
