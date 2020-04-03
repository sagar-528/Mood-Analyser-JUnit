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
    public void givenMoodAnalyserWithParameterConstructor_WhenProper_ShouldReturnObject() throws IllegalAccessException, InstantiationException, InvocationTargetException, MoodAnalysisException
    {
        moodAnalyser = new MoodAnalyser("I am in happy mood");
        Constructor<?> moodAnalyserConstructor = MoodAnalyserFactory.getConstructor("MoodAnalyser",String.class);
        MoodAnalyser moodAnalyserObject = MoodAnalyserFactory.createMoodAnalyserObject(moodAnalyserConstructor,"I am in happy mood");
        check = moodAnalyser.equals(moodAnalyserObject);
        Assert.assertEquals(true, check);
    }


    @Test
    public void givenMoodAnalyserWithParameterConstructor_WhenImProper_ShouldThrowMoodAnalysisException() throws IllegalAccessException, InstantiationException, InvocationTargetException, MoodAnalysisException
    {
        try
        {
            Constructor<?> moodAnalyserConstructor = MoodAnalyserFactory.getConstructor("CroodAnalyser",String.class);
        }
        catch (MoodAnalysisException e)
        {
            Assert.assertEquals(MoodAnalysisException.ExceptionType.NO_SUCH_CLASS,e.type);
        }
    }

    @Test
    public void givenClassWithParameterizedConstructor_WhenConstructorIsNotProper_ShouldThrownAnalysisException()
    {
        try
        {
            Constructor<?> moodAnalyserConstructor = MoodAnalyserFactory.getConstructor("MoodAnalyser", Integer.class, String.class);
        }
        catch (MoodAnalysisException e)
        {
            Assert.assertEquals(MoodAnalysisException.ExceptionType.NO_SUCH_METHOD,e.type);
        }
    }

    @Test
    public void givenHappyMessage_WhenProper_ShouldReturnHappyMood() throws IllegalAccessException, InstantiationException, InvocationTargetException, MoodAnalysisException
    {
        Constructor<?> moodAnalyserConstructor = MoodAnalyserFactory.getConstructor("MoodAnalyser",String.class);
        MoodAnalyser moodAnalyserObject = MoodAnalyserFactory.createMoodAnalyserObject(moodAnalyserConstructor,"I am in happy mood");
        Object result = MoodAnalyserFactory.createMethod(moodAnalyserObject,"analyseMood");
        Assert.assertEquals("HAPPY",result);
    }

    @Test
    public void givenHappyMessage_WhenImProper_ShouldThrowMoodAnalysisEzception() throws IllegalAccessException, InstantiationException, InvocationTargetException, MoodAnalysisException
    {
        try
        {
            Constructor<?> moodAnalyserConstructor = MoodAnalyserFactory.getConstructor("MoodAnalyser", String.class);
            MoodAnalyser moodAnalyserObject =MoodAnalyserFactory.createMoodAnalyserObject(moodAnalyserConstructor,"I am in happy mood");
            MoodAnalyserFactory.createMethod(moodAnalyserObject,"analysernullmood");
        }
        catch (MoodAnalysisException e)
        {
            Assert.assertEquals(MoodAnalysisException.ExceptionType.NO_SUCH_METHOD,e.type);
        }
    }

    @Test
    public void givenHappyMessageWithReflection_ShouldReturnHappy() throws IllegalAccessException, InstantiationException, InvocationTargetException, MoodAnalysisException, NoSuchFieldException, ClassNotFoundException
    {
        Constructor<?> moodAnalyserConstructor = MoodAnalyserFactory.getConstructor("MoodAnalyser");
        MoodAnalyser moodAnalyserObject = MoodAnalyserFactory.createMoodAnalyserObject(moodAnalyserConstructor);
        Object result = MoodAnalyserFactory.createMethod(moodAnalyserObject,"analyseMood");
        Assert.assertEquals("HAPPY",result);
    }
}
