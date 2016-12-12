package com.danibuiza.jcgeeks.datetime;

import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.time.OffsetTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;

public class TimeZones
{

    public static void main( String[] args )
    {

        // There is a list of pre defined time zones
        ZoneId.SHORT_IDS
                .keySet()
                .stream()
                .forEach( zoneKey -> System.out.println( "key: " + zoneKey + " value: "
                    + ZoneId.SHORT_IDS.get( zoneKey ) ) );

        // a zone id can be specified directly or by using the proper key
        ZoneId zoneIdParis = ZoneId.of( "Europe/Paris" );
        System.out.println( "zone id Europe/Paris " + zoneIdParis );
        ZoneId zoneIdAGT = ZoneId.of( ZoneId.SHORT_IDS.get( "AGT" ) );
        System.out.println( "zone id AGT " + zoneIdAGT );

        // there is zoned datetime which contains information of the date time and the zone id
        LocalDateTime dateTime = LocalDateTime.now( zoneIdAGT );
        ZonedDateTime zonedDateTimeAGT = ZonedDateTime.of( dateTime, zoneIdAGT );
        System.out.println( "Zoned Date Time AGT " + zonedDateTimeAGT );
        // output for AGT Zoned Date Time
        // 2014-07-23T17:55:51.612-03:00[America/Argentina/Buenos_Aires]

        dateTime = LocalDateTime.now( zoneIdParis );
        ZonedDateTime zonedDateTimeParis = ZonedDateTime.of( dateTime, zoneIdParis );
        System.out.println( "Zoned Date Time Paris " + zonedDateTimeParis );
        // output for Paris Zoned Date Time Paris
        // 2014-07-23T18:00:21.946+02:00[Europe/Paris]

        // so for example in order to print out the current times in all the available zones we can
        // do the following using lamdbas and streams
        System.out.println("**************************");
        
        try
        {
            ZoneId.SHORT_IDS
                    .keySet()
                    .stream()
                    .forEach( zoneKey -> System.out.println( ZoneId.of( ZoneId.SHORT_IDS.get( zoneKey ) ) + " : "
                        + LocalDateTime.now( ZoneId.of( ZoneId.SHORT_IDS.get( zoneKey ) ) ) ) );
        }
        catch( DateTimeException ex )
        {
            // DateTimeException is available and there are some specific implementations
            ex.printStackTrace();

        }

        System.out.println("**************************");

        // OffsetTime precission in nanoseconds, very useful for serializations
        OffsetTime time = OffsetTime.now();
        System.out.println( "time now " + time );

        // it is also possible to get differences to UTC
        ZoneOffset offset = zonedDateTimeAGT.getOffset();

        // changes offset of an offset time time
        OffsetTime sameTimeDifferentOffset = time.withOffsetSameInstant( offset );
        System.out.println( "time in buenos aires " + sameTimeDifferentOffset );

        // Changes times using special methods (returns a copy, since OffsetTime is inmmutable)
        OffsetTime newOffSetTime = sameTimeDifferentOffset.plusHours( 2 );
        System.out.println( "some changes in the hour : " + newOffSetTime );
    }
}
