package com.podcazity.podcastalert.util;

import com.restfb.json.ParseException;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Utilities {

    public static final List<String> dateFormats = List.of("YYYY-MM-dd'T'HH:mm:ss.SSSXXX", "EEE, dd MMM yyyy HH:mm:ss zzz");

    public static Date dateFormatting(String dateString) {
        for(String format : dateFormats) {
            try {
                return new SimpleDateFormat(format).parse(dateString);
            }
            catch (ParseException e) {}
            catch (java.text.ParseException e) {}
        }
        return null;
    }
}
