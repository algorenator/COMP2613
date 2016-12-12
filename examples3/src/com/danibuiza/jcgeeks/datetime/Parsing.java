package com.danibuiza.jcgeeks.datetime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.FormatStyle;
import java.util.Locale;

public class Parsing
{
    public static void main( String[] args )
    {

        // creates a datetime with seconds minutes hours days month and year
        LocalDateTime dateTime = LocalDateTime.of( 2014, Month.DECEMBER, 15, 15, 0, 30 );
        System.out.println( "without formatting " + dateTime );

        // formats as iso date time using date time formatter
        String isoDateTime = dateTime.format( DateTimeFormatter.ISO_DATE_TIME );
        System.out.println( "iso date time " + isoDateTime );

        // as iso date
        String isoDate = dateTime.format( DateTimeFormatter.ISO_DATE );
        System.out.println( "iso date  " + isoDate );

        // as ISO time
        String isoTime = dateTime.format( DateTimeFormatter.ISO_TIME );
        System.out.println( "iso time  " + isoTime );

        // using a pattern
        String patternDateTime = dateTime.format( DateTimeFormatter.ofPattern( "Y.M.d hh:mm:ss" ) );
        System.out.println( "using pattern  " + patternDateTime );

        // it is also possible to use directly locales while parsing and formatting
        DateTimeFormatter formatterSpanishShort = DateTimeFormatter.ofLocalizedDateTime( FormatStyle.SHORT )
                .withLocale( new Locale( "es" ) );
        String dateTimeStr = dateTime.format( formatterSpanishShort );
        System.out.println( "date from spanish formatter " + dateTimeStr );

        // parsing strings into dates
        LocalDate fromString = LocalDate.parse( "2014-01-20" );
        System.out.println( "parsed from an string  " + fromString );

        // parsing using an string and a pattern to use
        try
        {
           LocalDate.parse( "2014/03/03", DateTimeFormatter.ofPattern( "yy-MM-dd" ) );
        }
        catch( DateTimeParseException ex )
        {
            ex.printStackTrace();// not possible to parse
        }
        // useful for validations as well
        LocalDate parsedFromPatern = LocalDate.parse( "2014/03/03", DateTimeFormatter.ofPattern( "yyyy/MM/dd" ) );
        System.out.println( "using pattern  " + parsedFromPatern );
    }
}
