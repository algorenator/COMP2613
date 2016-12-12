package com.danibuiza.jcgeeks.datetime;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;

public class DurationsPeriodsAndInstants
{

    public static void main( String[] args )
    {

        durations();

        periods();

        instants();
    }

    private static void instants()
    {
        System.out.println( "Instants **** " );
        // a point in the time line (current one)
        Instant now = Instant.now();
        System.out.println( "now :" + now );

        // Instant created from an epoch
        Instant epochNow = Instant.ofEpochSecond( 60 * 60 * 24 * 30 );
        System.out.println( "one day epoch :" + epochNow );

        // Instant has get methods
        System.out.println( "epoch seconds " + now.getEpochSecond() );
        System.out.println( "nano seconds " + now.getNano() );

        // operations are available
        Instant tenSecondsAfter = now.plusSeconds( 10 );
        System.out.println( "Ten seconds after now " + tenSecondsAfter );

    }

    private static void durations()
    {
        System.out.println( "Durations  **** " );
        // duration of 59 seconds
        Duration duration = Duration.ofSeconds( 59 );
        System.out.println( "duration of 59 seconds " + duration );

        // duration of 59 minutes
        Duration duration59Mins = Duration.ofMinutes( 59 );
        System.out.println( "duration of 59 minutes " + duration59Mins );

        // duration from now until midnight (local)
        duration = Duration.between( LocalTime.now(), LocalTime.MIDNIGHT );
        System.out.println( "duration duration from now until midnight (local) " + duration );

        // duration from now until midnight (local)
        duration = Duration.between( LocalTime.now( ZoneId.of( ZoneId.SHORT_IDS.get( "AGT" ) ) ), LocalTime.MIDNIGHT );
        System.out.println( "duration duration from now until midnight (argentina) " + duration );

        // You can use durations to modify times
        LocalTime timeNow = LocalTime.now().plus( duration59Mins );
        System.out.println( "current time modified (plus) by duration of 59 minutes " + timeNow );

        // you can get the duration units like minutes, seconds, etc.
        System.out.println( "duration seconds: " + duration59Mins.get( ChronoUnit.SECONDS ) );

    }

    private static void periods()
    {
        System.out.println( "Periods **** " );
        // you can create a period using 3 years, 2 months and 1 day
        Period period = Period.of( 3, 2, 1 );
        System.out.println( "period of 3 years, 2 months and 1 day " + period );

        // you can create a period of 4 months
        Period period4Months = Period.ofMonths( 4 );
        System.out.println( "period of 4 months " + period4Months );

        // a 4 week period
        Period period4Weeks = Period.ofWeeks( 4 );
        System.out.println( "period of 4 weeks " + period4Weeks );

        // you can create a period between to given dates
        period = Period.between( LocalDate.now(), LocalDate.of( 2015, Month.JANUARY, 1 ) );
        System.out.println( "period between now and 2015-01-01 " + period );

        // You can use periods to modify dates
        LocalDate newDate = LocalDate.now().plus( period4Months );
        System.out.println( "current date modified (plus) by period of 4 months " + newDate );

        // you can get the period units like days, years, etc
        System.out.println( "period days: " + period4Weeks.get( ChronoUnit.DAYS ) );

    }
}
