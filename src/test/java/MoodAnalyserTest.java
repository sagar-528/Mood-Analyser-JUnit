import org.junit.Assert;
import org.junit.Test;

public class MoodAnalyserTest
{

    @Test
    public void returnMsgSad()
    {
        MoodAnalyse moodAnalyse = new MoodAnalyse("I am in Sad Mood");
        String mood = moodAnalyse.analyseMood();
        Assert.assertEquals("SAD",mood);
    }

    @Test
    public void msgReturnHappy()
    {
        MoodAnalyse moodAnalyse = new MoodAnalyse("I am in Any Mood");
        String mood = moodAnalyse.analyseMood();
        Assert.assertEquals("HAPPY",mood);
    }

    @Test
    public void givenNullMood_shouldReturnHappy()
    {
        MoodAnalyse moodAnalyser = new MoodAnalyse();
        String result = moodAnalyser.analyseMood(null);
        Assert.assertEquals("HAPPY",result);
    }
}
