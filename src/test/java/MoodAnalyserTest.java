import org.junit.Assert;
import org.junit.Test;

public class MoodAnalyserTest
{
    MoodAnalyse moodAnalyse;

    @Test
    public void givenMessage_whenProper_RespondAsSadMood() throws MoodanalysisException
    {
        MoodAnalyse moodAnalyse = new MoodAnalyse("I am in Sad Mood");
        String result = moodAnalyse.analyseMood();
        Assert.assertEquals("SAD",result);
    }

    @Test
    public void givenMessage_whenProper_RespondAsHappyMood() throws MoodanalysisException
    {
        MoodAnalyse moodAnalyse = new MoodAnalyse("I am in Any Mood");
        String result = moodAnalyse.analyseMood();
        Assert.assertEquals("HAPPY",result);
    }

    @Test
    public void givenNullMood_shouldReturnHappy() throws MoodanalysisException
    {
        MoodAnalyse moodAnalyser = new MoodAnalyse();
        String result = moodAnalyser.analyseMood(null);
        Assert.assertEquals("HAPPY",result);
    }

    @Test
    public void givenNullMood_ShouldThrowCustomException()
    {
        try
        {
            moodAnalyse = new MoodAnalyse(null);
            String result = moodAnalyse.analyseMood();
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
            moodAnalyse = new MoodAnalyse();
            String result = moodAnalyse.analyseMood(" ");
        }
        catch (MoodanalysisException e)
        {
            Assert.assertEquals(MoodanalysisException.ExceptionType.ENTERED_EMPTY,e.type);
        }
    }
}
