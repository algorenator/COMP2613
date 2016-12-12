package com.danibuiza.jcgeeks.datetime;

import java.time.Clock;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Year;
import java.time.ZoneId;
import java.time.ZoneOffset;

public class LocalDateTimeExamples
{
    public static void main( String[] args )
    {

        // using now()
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println( localDateTime );

        // using a clock with the default system zone
        Clock clock = Clock.systemDefaultZone();
        localDateTime = LocalDateTime.now( clock );
        System.out.println( localDateTime );

        // using a zone with the default system zone
        ZoneId zoneId = ZoneId.systemDefault();
        localDateTime = LocalDateTime.now( zoneId );
        System.out.println( localDateTime );

        // clocks and zones

        /*
         * using of() in combination with predefines constants and available methods like Year.now()
         * or DayOfWeek.SATURDAY
         */
        localDateTime = LocalDateTime.of( 2000, 1, 1, 1, 1, 1 );
        localDateTime = LocalDateTime
                .of( Year.now().getValue(), Month.FEBRUARY, DayOfWeek.SATURDAY.getValue(), 1, 1, 1 );
        System.out.println( localDateTime );

        // using LocalTime and LocalDate combined
        LocalTime time = LocalTime.NOON;
        LocalDate date = LocalDate.now();
        localDateTime = LocalDateTime.of( date, time );
        System.out.println( localDateTime );

        // using epoch days -> only date is populated
        LocalDate localDate = LocalDate.ofEpochDay( 150 );
        System.out.println( localDate );

        // only times using of -> only time is populated
        LocalTime localTime = LocalTime.of( 14, 35 );
        System.out.println( localTime );

        // only times using parse
        localTime = LocalTime.parse( "10:15:30" );
        System.out.println( localTime );

        // it is also possible to use from() in combination with accessors
        /*
         * TemporalAccessor accessor = Month.NOVEMBER; localDateTime = LocalDateTime.from( arg0 )(
         * accessor ); System.out.println( localTime );
         */

        // it is possible to use to methods to convert to dates or times
        LocalDateTime.of( date, time );
        System.out.println( localDateTime.toLocalDate() );
        System.out.println( localDateTime.toLocalTime() );

        // or to instants in time (this is a kind of calculation)
        LocalDateTime.of( date, time );
        ZoneOffset offset = ZoneOffset.ofTotalSeconds( -500 );
        localDateTime.toInstant( offset );
        System.out.println( localDateTime.toInstant( offset ) );

    }
}
