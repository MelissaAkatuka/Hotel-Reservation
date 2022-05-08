public class HotelReservation {

    public String getCheapestHotel(String input) {

        // Declaring and initializing the variables.
        String day1 = null;
        String day2 = null;
        String day3 = null;
        String clientType = null;
        String result = null;

        // Splitting th array from the space character.
        String[] splittedText = input.split(" ");

        // Now assigning each splitted part to a variable identified with what it is.

        // The phrase "Regular: 16Mar2009(mon), 17Mar2009(tues), 18Mar2009(wed)" becomes:
        // client = "Regular:"
        // s1 = "16Mar2009(mon),"
        // s2 = "17Mar2009(tues),"
        // s3 = "18Mar2009(wed)"

        String client = splittedText[0];
        String s1 = splittedText[1];
        String s2 = splittedText[2];
        String s3 = splittedText[3];

        // Filtering the client.
        for(int i = 0; i < client.length(); i++){
            // Run through the client array and creates a substring
            // That goes from the first index which is in position [0] until the index before the ":".
            clientType = client.substring(0, input.indexOf(":"));
        }

        // Filtering day1.
        for(int i = 0; i < s1.length(); i++){
            // Run through the s1 array and creates a substring
            // That goes from the "(" until ")", extracting the word between parentheses.
            day1 = s1.substring((s1.indexOf("(") + 1), (s1.indexOf(")")));
        }

        // Filtering day2.
        for(int i = 0; i < s2.length(); i++){
            // Run through the s2 array and creates a substring
            // That goes from the "(" until ")", extracting the word between parentheses.
            day2 = s2.substring((s2.indexOf("(") + 1), (s2.indexOf(")")));
        }

        // Filtering day3.
        for(int i = 0; i < s3.length(); i++){
            // Run through the s3 array and creates a substring
            // That goes from the "(" until ")", extracting the word between parentheses.
            day3 = s3.substring((s3.indexOf("(") + 1), (s3.indexOf(")")));
        }

        // After filtering only what is important, the variables are:
        // clientType = "Regular"
        // day1 = "mon"
        // day2 = "tues"
        // day3 = "wed"

        // Here we obtain an array in the format [weekDay, weekend] passing the necessary parameters (day1, day2 and day3) to the function getNumberOfDays.
        int[] weekAndWeekend = getNumberOfDays(day1, day2, day3);

        // Now we assign each splitted part to a variable identified with what it is.
        // weekDay represents the number of days the client will stay at the hotel that are a week day.
        // weekend represents the number of days the client will stay at the hotel that are a weekend.

        int weekDay = weekAndWeekend[0];
        int weekend = weekAndWeekend[1];

        // In this case,
        // weekDay = 3 and
        // weekend = 0

        // Here we assign each hotel's function to a variable with the price per stay already calculated.
        int lakewood = lakewood(clientType, weekDay, weekend);
        int bridgewood = bridgewood(clientType, weekDay, weekend);
        int ridgewood = ridgewood(clientType, weekDay, weekend);

        // In this case,
        // lakewood = 330
        // bridgewood = 480
        // ridgewood = 660

        // The last step consists of comparing the variables to find which one is the lower and, therefore, the cheapest hotel.

        //Lakewood is the cheapest.
        if(lakewood < bridgewood && lakewood < ridgewood){
            result = "Lakewood";
        //Bridgewood is the cheapest.
        } else if(bridgewood < lakewood && bridgewood < ridgewood){
            result = "Bridgewood";
        //Ridgewood is the cheapest.
        } else if(ridgewood < lakewood && ridgewood < bridgewood){
            result = "Ridgewood";
        //Tie case.
        } else {
            //Tie between lakewood, bridgewood and ridgewood
            if(lakewood == bridgewood && bridgewood == ridgewood && ridgewood == lakewood) {
                result = "Ridgewood";
            //Tie between lakewood and bridgewood
            } else if(lakewood == bridgewood){
                result = "Bridgewood";
            //Tie between lakewood and ridgewood
            } else if(lakewood == ridgewood){
                result = "Ridgewood";
            //Tie between bridgewood and ridgewood
            } else if(bridgewood == ridgewood){
                result = "Ridgewood";
            }
        }

        return result;
    }

    public static int[] getNumberOfDays(String day1, String day2, String day3) {
        // Declaring and initializing the variables.
        // We create an array of length 2
        int[] coordinates = new int[2];

        // Initially, we do not know how many of the days the client will be staying in the hotel are weekdays or weekends, so they begin with 0.
        int weekDay = 0;
        int weekend = 0;

        // Here we compare if day1, day2 and day3 are weekends.
        // If they are, the weekend variable is incremented.
        // Otherwise, it means it's a week day, so the weekDay variable is incremented.

        if(day1.equals("sat") || day1.equals("sun")){
            weekend++;
        } else {
            weekDay++;
        }

        if(day2.equals("sat") || day2.equals("sun")){
            weekend++;
        } else {
            weekDay++;
        }

        if(day3.equals("sat") || day3.equals("sun")){
            weekend++;
        } else {
            weekDay++;
        }

        // Now we fill the array [0,0] with the weekDay and weekend values.
        coordinates[0] = weekDay;
        coordinates[1] = weekend;

        // Returning an array in the format [weekDay, weekend].
        return coordinates;
    }

    public static int lakewood(String clientType, int weekDay, int weekend){
        // Declaring and initializing the variable.
        int total = 0;

        // The logic from lakewood hotel for a regular or rewards client type described in the challenge.
        if(clientType.equals("Regular")){
            total += weekDay * 110;
            total += weekend * 90;
        } else if (clientType.equals("Rewards")){
            total += weekDay * 80;
            total += weekend * 80;
        }

        // Returning the total hosting value.
        return total;
    }

    public static int bridgewood(String clientType, int weekDay, int weekend){
        // Declaring and initializing the variable.
        int total = 0;

        // The logic from bridgewood hotel for a regular or rewards client type described in the challenge.
        if(clientType.equals("Regular")){
            total += weekDay * 160;
            total += weekend * 60;
        } else if (clientType.equals("Rewards")){
            total += weekDay * 110;
            total += weekend * 50;
        }

        // Returning the total hosting value.
        return total;
    }

    public static int ridgewood(String clientType, int weekDay, int weekend){
        // Declaring and initializing the variable.
        int total = 0;

        // The logic from ridgewood hotel for a regular or rewards client type described in the challenge.
        if(clientType.equals("Regular")){
            total += weekDay * 220;
            total += weekend * 150;
        } else if (clientType.equals("Rewards")){
            total += weekDay * 100;
            total += weekend * 40;
        }

        // Returning the total hosting value.
        return total;
    }
}
