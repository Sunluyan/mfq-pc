package com.mfq.bean.juxinli.stepTwo;

public class Create_time {
    private int year;

    private int month;

    private int dayOfMonth;

    private int hourOfDay;

    private int minute;

    private int second;

    @Override
    public String toString() {
        return "Create_time{" +
                "year=" + year +
                ", month=" + month +
                ", dayOfMonth=" + dayOfMonth +
                ", hourOfDay=" + hourOfDay +
                ", minute=" + minute +
                ", second=" + second +
                '}';
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getYear() {
        return this.year;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getMonth() {
        return this.month;
    }

    public void setDayOfMonth(int dayOfMonth) {
        this.dayOfMonth = dayOfMonth;
    }

    public int getDayOfMonth() {
        return this.dayOfMonth;
    }

    public void setHourOfDay(int hourOfDay) {
        this.hourOfDay = hourOfDay;
    }

    public int getHourOfDay() {
        return this.hourOfDay;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public int getMinute() {
        return this.minute;
    }

    public void setSecond(int second) {
        this.second = second;
    }

    public int getSecond() {
        return this.second;
    }

}