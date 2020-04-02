import org.junit.Assert;
import org.junit.Test;

public class MoodAnalyserTest
{

    @Test
    public void returnMsgSad()
    {
        MoodAnalyse moodAnalyse = new MoodAnalyse();
        String mood = moodAnalyse.getMood("today i am sad");
        Assert.assertEquals("SAD",mood);
    }

    @Test
    public void msgReturnHappy()
    {
        MoodAnalyse moodAnalyse = new MoodAnalyse();
        String mood = moodAnalyse.getMood("today i am happy");
        Assert.assertEquals("HAPPY",mood);
    }

    @Test
    public void msgReturnNull()
    {
        MoodAnalyse moodAnalyse = new MoodAnalyse();
        String mood = moodAnalyse.getMood(" ");
        Assert.assertEquals("Invaild Mood",mood);
    }

}
