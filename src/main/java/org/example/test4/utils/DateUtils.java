package org.example.test4.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class DateUtils {
    public static final ThreadLocal<DateFormat> dateFormatThreadLocal = ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy-MM-dd"));
}
