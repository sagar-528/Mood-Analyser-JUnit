public class MoodAnalyse {

    public String getMood(String message)
    {
        if(message.contains("sad"))
            return "SAD";
        if(message.contains("happy"))
            return "HAPPY";
        else
            return  "Invaild Mood";
    }

}
