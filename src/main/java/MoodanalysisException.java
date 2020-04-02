public class MoodanalysisException extends Exception
{
    public MoodanalysisException(ExceptionType type,String message)
    {
        super(message);
        this.type = type;
    }

    enum ExceptionType
    {
        ENTERED_NULL,ENTERED_EMPTY,NO_SUCH_CLASS,NO_SUCH_METHOD;
    }
    ExceptionType type;

}
