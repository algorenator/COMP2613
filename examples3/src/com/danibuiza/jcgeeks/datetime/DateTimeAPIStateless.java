package com.danibuiza.jcgeeks.datetime;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class DateTimeAPIStateless
{

    public static void main( String[] args )
    {
        LocalDateTime timeInThePast = LocalDateTime.now().withDayOfMonth( 5 ).withYear( 2005 );

        System.out.println( "timeInThePast: " + timeInThePast );

        LocalDateTime moreInThePast = timeInThePast.minusWeeks( 2 ).plus( 3, ChronoUnit.DAYS );

        // operations do not affect the variable, is thread safe and stateless
        System.out.println( "timeInThePast: " + timeInThePast );

        // a new variable is returned
        System.out.println( "moreInThePast: " + moreInThePast );
    }

}
