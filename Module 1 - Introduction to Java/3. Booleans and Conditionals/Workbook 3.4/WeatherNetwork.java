public class WeatherNetwork {
    public static void main(String[] args) {

        int temp = 5;

        String forecast = "";

        //IF - ELSE IF - ELSE STATEMENTS HERE!

        //if temp between -15 and -1: "The forecast is FREEZING! Stay home!"

        //if temp between 0 and 10: "The forecast is Chilly. Wear a coat!";

        //else: It's warm. go outside!

        if (temp >= -15 && temp <= -1){
            forecast = "The forecast is FREEZING! Stay home!";
        }else if (temp >= 00 && temp <= 10){
            forecast = "The forecast is Chilly. Wear a coat!";
        }else{
            forecast = "It's warm. Go outside!";
        }

        System.out.println(forecast);
    }
}
