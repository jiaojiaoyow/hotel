package com.example.hotel.util;
import com.example.hotel.model.Coupon;
import com.example.hotel.service.CouponService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.xml.crypto.Data;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class DateUtil {
    static SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
    static public String change_str(Date date){
        return df.format(date);
    }

    static public Date change_Date(String date) throws ParseException{
        return df.parse(date);
    }

    static public String addtime(Date date, int add){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE,10);
        return df.format(calendar.getTime());
    }
}
