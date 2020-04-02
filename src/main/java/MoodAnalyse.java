public class MoodAnalyse {

    String message;
    public MoodAnalyse(String message)
    {
        this.message = message;
    }
    public String analyseMood()
    {
        if(this.message.contains("Sad"))
            return "SAD";
            return "HAPPY";
    }
}