using System;

namespace RegistrationLibrary
{
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
        private DayOfWeek friday;

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

        public CheckTime(string date, DayOfWeek friday, int hour, int min)
        {
            this.date = date;
            this.friday = friday;
            Hour = hour;
            this.min = min;
        }
    }
}
