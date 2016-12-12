package com.danibuiza.jcgeeks.datetime;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

public class TemporalAdjustersExamples
{

    public static void main( String[] args )
    {
        /* using adjuster is possible to adjust a given date */
        LocalDate now = LocalDate.now();
        System.out.println( "now " + now );

        DayOfWeek dayOfWeek = now.getDayOfWeek();

        System.out.println( "day of week " + dayOfWeek );

        LocalDate adjusted = now.with( TemporalAdjusters.lastDayOfMonth() );
        
        System.out.println( "now with last day of month " + adjusted );

        System.out.println( "now " + now );

        System.out.println( "now with last friday in month "
            + now.with( TemporalAdjusters.lastInMonth( DayOfWeek.FRIDAY ) ) );

    }
}
