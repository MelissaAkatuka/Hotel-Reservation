import org.junit.Test;
import static org.junit.Assert.*;

public class FailingTest {
   @Test
   // 3 week days case -> 1) Regular
   // when Lakewood is the cheapest.
   public void test1() {
       HotelReservation Hotel = new HotelReservation();
       assertEquals("Lakewood", Hotel.getCheapestHotel("Regular: 16Mar2009(mon), 17Mar2009(tues), 18Mar2009(wed)"));
   }
   @Test
   // 2 weekend and 1 week day case -> 1) Regular
   // when Bridgewood is the cheapest.
   public void test2() {
       HotelReservation Hotel = new HotelReservation();
       assertEquals("Bridgewood", Hotel.getCheapestHotel("Regular: 20Mar2009(fri), 21Mar2009(sat), 22Mar2009(sun)"));
   }
   @Test
   // 2 week days and 1 weekend case -> 2) Rewards
   // when Lakewood and Ridgewood have both the same value
   // and then Ridgewood is chosen because it has the higher classification.
   public void test3() {
       HotelReservation Hotel = new HotelReservation();
       assertEquals("Ridgewood", Hotel.getCheapestHotel("Rewards: 26Mar2009(thur), 27Mar2009(fri), 28Mar2009(sat)"));
   }
    @Test
    // 2 weekend and 1 week day case -> 2) Rewards
    // when Ridgewood is the cheapest.
    public void test4() {
        HotelReservation Hotel = new HotelReservation();
        assertEquals("Ridgewood", Hotel.getCheapestHotel("Rewards: 21Apr2022(fri), 22Apr2022(sat), 23Apr2022(sun)"));
    }
    @Test
    // 3 week days case -> 2) Rewards
    // Tests the if case that Lakewood is the cheapest.
    public void test5() {
        HotelReservation Hotel = new HotelReservation();
        assertEquals("Lakewood", Hotel.getCheapestHotel("Rewards: 14Mar2022(mon), 15Mar2022(tues), 16Mar2022(wed)"));
    }
    @Test
    // 2 week days and 1 weekend case -> 1) Regular
    // when Lakewood is the cheapest.
    public void test6() {
        HotelReservation Hotel = new HotelReservation();
        assertEquals("Lakewood", Hotel.getCheapestHotel("Regular: 10Mar2022(thur), 11Mar2022(fri), 12Mar2022(sat)"));
    }

    // Now, we are finished! There is no point in testing anymore. That would be like repeating ourselves.
    // We covered all the possible cases with both clint types (Regular and Rewards):
    // 1) the 3 week days case (test1 and test5).
    // 2) the 2 week days and 1 weekend case (test6 and test3).
    // 3) the 2 weekend and 1 week day case (test2 and test4).
}
