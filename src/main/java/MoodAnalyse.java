public class MoodAnalyse {

    String message;
    public MoodAnalyse(String message)
    {
        this.message = message;
    }
    public String getMood()
    {
        if(this.message.contains("Sad"))
            return "SAD";
            return "HAPPY";
    }
}