using System;

namespace Library
{
    public class CheckIn
    {
        public DateTime Time { get; set; }

        public CheckIn()
        {
        }

        public CheckIn(DateTime time)
        {
            Time = time;
        }

        public bool IsLate(DateTime limitTime)
        {
            return Time.Hour > limitTime.Hour
                || (Time.Hour == limitTime.Hour
                && (Time.Minute > limitTime.Minute|| Time.Second > limitTime.Second));
        }

        public bool IsThursday()
        {
            return Time.DayOfWeek == System.DayOfWeek.Thursday;
        }
    }
}
