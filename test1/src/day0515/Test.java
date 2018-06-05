package day0515;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Test {
	public static void main(String[] args) throws ParseException {
		/*
		Date date = new Date();
		System.out.println(date);
		
		long date1 = date.getTime();
		System.out.println(date1);
		date.setTime(date1+86400000);
		System.out.println(date);
		
		Calendar cal = Calendar.getInstance();
		System.out.println(cal);
		
		Date date2 = cal.getTime();
		System.out.println(date2);
		cal.set(Calendar.YEAR, 2019);
		cal.add(Calendar.YEAR, 1);
		
		System.out.println(cal.get(Calendar.YEAR)+"年"
						  +(cal.get(Calendar.MONTH)+1)+"月"
						  +cal.get(Calendar.DATE)+"日  "
						  +cal.get(Calendar.HOUR_OF_DAY)+":"
						  +cal.get(Calendar.MINUTE)+":"
						  +cal.get(Calendar.SECOND));
		*/
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date1 = sdf1.parse("2019/05/15 11:30:34");
		System.out.println(date1);
		
		Date date2 = new Date();
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = sdf2.format(date2);
		System.out.println(time);
		
		//1.将"2018/05/15 12:12:12"转换成"2018-05-15 12.12.12"
		SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date3 = sdf3.parse("2018/05/15 12:12:12");
		System.out.println(date3);
		SimpleDateFormat sdf4 = new SimpleDateFormat("yyyy-MM-dd HH.mm.ss");
		String time1 = sdf4.format(date3);
		System.out.println(time1);
		
		//2.给定一个人的出生日期，如"1980-12-10"，计算其多大年龄？
		//出生年月日
		String birthday = "1980-12-10";
		//创建SimpleDateFormat对象，确定匹配模式
		SimpleDateFormat sdf5 = new SimpleDateFormat("yyyy-MM-dd");
		
		//字符串转日期对象
		Date date5 = sdf5.parse(birthday);
		//获取今天的日期
//		Date today = new Date();
		//转换为毫秒值
//		long birthday1 = date5.getTime();
//		long today1 = today.getTime();
//		long a = today1 - birthday1;
		
		Calendar cal = Calendar.getInstance();
		int nowYear = cal.get(Calendar.YEAR);
		int nowMonth = cal.get(Calendar.MONTH);
		int nowDate = cal.get(Calendar.DATE);
		
		cal.setTime(date5);
		int birthdayYear = cal.get(Calendar.YEAR);
		int birthdayMonth = cal.get(Calendar.MONTH);
		int birthdayDate = cal.get(Calendar.DATE);
		
		int age = nowYear - birthdayYear;
		if(nowMonth <= birthdayMonth) {
			if(nowMonth == birthdayMonth) {
				if(nowDate < birthdayDate) {
					age--;
				}
			} else {
				age--;
			}
		}
		System.out.println("年龄为："+age);
	}
}
