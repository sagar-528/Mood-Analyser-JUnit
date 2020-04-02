import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import static java.lang.Class.forName;

public class MoodAnalyserTest
{
    MoodAnalyser moodAnalyser;
    String message = "I am in Happy Mood";

    @Test
    public void givenMessage_whenProper_RespondAsSadMood() throws MoodanalysisException
    {
        MoodAnalyser moodAnalyser = new MoodAnalyser("I am in Sad Mood");
        String result = moodAnalyser.analyseMood();
        Assert.assertEquals("SAD",result);
    }

    @Test
    public void givenMessage_whenProper_RespondAsHappyMood() throws MoodanalysisException
    {
        MoodAnalyser moodAnalyser = new MoodAnalyser("I am in Any Mood");
        String result = moodAnalyser.analyseMood();
        Assert.assertEquals("HAPPY",result);
    }

    @Test
    public void givenNullMood_shouldReturnHappy() throws MoodanalysisException
    {
        MoodAnalyser moodAnalyser = new MoodAnalyser();
        String result = moodAnalyser.analyseMood(null);
        Assert.assertEquals("HAPPY",result);
    }

    @Test
    public void givenNullMood_ShouldThrowCustomException()
    {
        try
        {
            moodAnalyser = new MoodAnalyser(null);
            String result = moodAnalyser.analyseMood();
        }
        catch (MoodanalysisException e)
        {
            Assert.assertEquals(MoodanalysisException.ExceptionType.ENTERED_NULL,e.type);
        }
    }

    @Test
    public void givenNullMood_ShouldThrowCustomExceptionWithExceptionType()
    {
        try
        {
            moodAnalyser = new MoodAnalyser();
            String result = moodAnalyser.analyseMood(" ");
        }
        catch (MoodanalysisException e)
        {
            Assert.assertEquals(MoodanalysisException.ExceptionType.ENTERED_EMPTY,e.type);
        }
    }

    @Test
    public void givenMoodAnalyse_WhenProper_ShouldReturnObject() throws IllegalAccessException, InstantiationException, InvocationTargetException, MoodanalysisException
    {
            moodAnalyser =new MoodAnalyser();
            Constructor<?> moodAnalyserConstructor = MoodAnalyserFactory.getConstructor("Com.Bridgelaz.MoodAnalyse");
            MoodAnalyser moodAnalyserObj = MoodAnalyserFactory.createMoodAnalyse(moodAnalyserConstructor);
            boolean check = moodAnalyser.equals(moodAnalyserObj);
            Assert.assertEquals(true, check);

    }

    @Test
    public void givenMoodAnalyse_WhenProper_ShouldThwonAnalysisException() throws IllegalAccessException, InstantiationException, InvocationTargetException
    {
        try
        {
            Constructor<?> moodAnalyserConstructor = MoodAnalyserFactory.getConstructor("CroodAnalyser");
        }
        catch (MoodanalysisException e)
        {
            Assert.assertEquals(MoodanalysisException.ExceptionType.NO_SUCH_CLASS,e.type);
        }
    }

    @Test
    public void givenMoodAnalyse_WhenConstructorIsNotProper_ShouldThwonAnalysisException() throws IllegalAccessException, InstantiationException, InvocationTargetException
    {
        try
        {
            Constructor<?> moodAnalyserConstructor = MoodAnalyserFactory.getConstructor("MoodAnalyse", Integer.class);
        }
        catch (MoodanalysisException e)
        {
            Assert.assertEquals(MoodanalysisException.ExceptionType.NO_SUCH_METHOD,e.type);
        }
    }
}
