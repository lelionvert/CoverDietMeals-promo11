using System;

namespace RegistrationLibrary
{
    public enum DayOfWeek
    {
        Monday = 0,
        Tuesday,
        Wednesday,
        Thursday,
        Friday,
        Saturday,
        Sunday
    };

    public class CheckTime
    {
        public DayOfWeek DayOfWeek
        {
            get;
            private set;
        }
        private string time;
        public int Hour
        {
            get;
            private set;
        }
        private int min;
        private string date;

        public CheckTime(DayOfWeek dayOfWeek, string time)
        {
            DayOfWeek = dayOfWeek;
            this.time = time;
        }

        public CheckTime(DayOfWeek dayOfWeek, int hour, int min)
        {
            DayOfWeek = dayOfWeek;
            Hour = hour;
            this.min = min;
        }

        public CheckTime(string date, DayOfWeek dayOfWeek, int hour, int min)
        {
            this.date = date;
            DayOfWeek = dayOfWeek;
            Hour = hour;
            this.min = min;
        }

        public CheckTime(DayOfWeek dayOfWeek)
        {
            DayOfWeek = dayOfWeek;
        }
    }
}
