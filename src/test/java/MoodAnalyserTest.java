import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import static java.lang.Class.forName;

public class MoodAnalyserTest
{
    MoodAnalyser moodAnalyser;
    String message = "I am in happy mood";
    Boolean check;
    String result;

    @Test
    public void givenMessage_whenProper_RespondAsSadMood() throws MoodAnalysisException
    {
        moodAnalyser = new MoodAnalyser("I am in Sad Mood");
        result = moodAnalyser.analyseMood();
        Assert.assertEquals("SAD",result);
    }

    @Test
    public void givenMessage_whenProper_RespondAsHappyMood() throws MoodAnalysisException
    {
        moodAnalyser = new MoodAnalyser("I am in Any Mood");
        result = moodAnalyser.analyseMood();
        Assert.assertEquals("HAPPY",result);
    }

    @Test
    public void givenNullMood_shouldReturnHappy() throws MoodAnalysisException
    {
         moodAnalyser = new MoodAnalyser(null);
        result = moodAnalyser.analyseMood();
        Assert.assertEquals("HAPPY",result);
    }

    @Test
    public void givenNullMood_ShouldThrowCustomException()
    {
        try
        {
            moodAnalyser = new MoodAnalyser();
            result = moodAnalyser.analyseMood(null);
        }
        catch (MoodAnalysisException e)
        {
            Assert.assertEquals(MoodAnalysisException.ExceptionType.ENTERED_NULL,e.type);
        }
    }

    @Test
    public void givenNullMood_ShouldThrowCustomExceptionWithExceptionType()
    {
        try
        {
            moodAnalyser = new MoodAnalyser();
            result = moodAnalyser.analyseMood(" ");
        }
        catch (MoodAnalysisException e)
        {
            Assert.assertEquals(MoodAnalysisException.ExceptionType.ENTERED_EMPTY,e.type);
        }
    }

    @Test
    public void givenMoodAnalyse_WhenProper_ShouldReturnObject() throws IllegalAccessException, InstantiationException, InvocationTargetException, MoodAnalysisException
    {
            moodAnalyser = new MoodAnalyser();
            Constructor<?> moodAnalyserConstructor = MoodAnalyserFactory.getConstructor("MoodAnalyser");
            MoodAnalyser moodAnalyserObject = MoodAnalyserFactory.createMoodAnalyserObject(moodAnalyserConstructor);
            check = moodAnalyser.equals(moodAnalyserObject);
            Assert.assertEquals(true, check);

    }

    @Test
    public void givenMoodAnalyse_WhenProper_ShouldThrownAnalysisException() throws IllegalAccessException, InstantiationException, InvocationTargetException
    {
        try
        {
            Constructor<?> moodAnalyserConstructor = MoodAnalyserFactory.getConstructor("CroodAnalyser");
        }
        catch (MoodAnalysisException e)
        {
            Assert.assertEquals(MoodAnalysisException.ExceptionType.NO_SUCH_CLASS,e.type);
        }
    }

    @Test
    public void givenMoodAnalyse_WhenConstructorIsNotProper_ShouldThrownAnalysisException()
    {
        try
        {
            Constructor<?> moodAnalyserConstructor = MoodAnalyserFactory.getConstructor("MoodAnalyser", Integer.class);
        }
        catch (MoodAnalysisException e)
        {
            Assert.assertEquals(MoodAnalysisException.ExceptionType.NO_SUCH_METHOD,e.type);
        }
    }

    @Test
    public void givenMoodAnalyserWithParameterConstructor_WhenProper_ShouldReturnObject() throws IllegalAccessException, InstantiationException, InvocationTargetException
    {

        moodAnalyser = new MoodAnalyser("I am in happy mood");
        Constructor<?> moodAnalyserConstructor = null;
        try {
            moodAnalyserConstructor = MoodAnalyserFactory.getConstructor("MoodAnalyser");
        } catch (MoodAnalysisException e) {
            e.printStackTrace();
        }
        MoodAnalyser moodAnalyserObject = MoodAnalyserFactory.createMoodAnalyserObject(moodAnalyserConstructor,"I am in happy mood");
        check = moodAnalyser.equals(moodAnalyserObject);
        Assert.assertEquals(true, check);
    }



}
