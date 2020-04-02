import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class MoodAnalyserFactory
{
   
    public static Constructor<?> getConstructor(String className, Class<?> ... param ) throws MoodanalysisException
    {
        try
        {
            Class<?> moodAnalyseClass = Class.forName(className);
            return moodAnalyseClass.getConstructor(param);
        }
         catch (ClassNotFoundException e)
          {
            throw new MoodanalysisException(MoodanalysisException.ExceptionType.NO_SUCH_CLASS,"Class not found");
          }
            catch (NoSuchMethodException e)
            {
                throw new MoodanalysisException(MoodanalysisException.ExceptionType.NO_SUCH_METHOD,"METHOD not found");
            }
    }

    public static MoodAnalyser createMoodAnalyse(Constructor<?> moodAnalyserConstructor, Object ... message) throws IllegalAccessException, InvocationTargetException, InstantiationException
    {
        return (MoodAnalyser) moodAnalyserConstructor.newInstance(message);
    }
}
