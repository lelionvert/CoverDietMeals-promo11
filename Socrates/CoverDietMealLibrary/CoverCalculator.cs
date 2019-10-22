using System;
using System.Collections.Generic;
using System.Linq;
using RegistrationLibrary;
using DayOfWeek = RegistrationLibrary.DayOfWeek;

namespace CoverDietMealLibrary
{
    public class CoverCalculator
    {
        public static int GetCovers(Participant participant, Diet diet, DayOfWeek dayOfWeek)
        {
            if (participant.IsDietType(diet) && participant.IsPresentOn(dayOfWeek))
                return DayCovers(dayOfWeek);
            return 0;
        }

        public static int GetCovers(List<Participant> participants, Diet diet, DayOfWeek dayOfWeek)
        {
            return participants.Where(
                p => p.IsDietType(diet) && p.IsPresentOn(dayOfWeek)
                ).Count() * DayCovers(dayOfWeek);
        }

        public static int DayCovers(DayOfWeek dayOfWeek)
        {
            if (dayOfWeek == DayOfWeek.Thursday || dayOfWeek == DayOfWeek.Sunday)
                return 1;
            else if (dayOfWeek == DayOfWeek.Friday || dayOfWeek == DayOfWeek.Saturday)
                return 2;
            return 0;
        }

        public static Dictionary<Diet, int> GetDailyDietMeals(List<Participant> participants, DayOfWeek dayOfWeek)
        {
            var dietMeals = new Dictionary<Diet, int>();

            foreach (var diet in Enum.GetValues(typeof(Diet)))
            {
                dietMeals.Add((Diet)diet, GetCovers(participants, (Diet)diet, dayOfWeek));
            }
            return dietMeals;
        }

        public static Dictionary<DayOfWeek, Dictionary<Diet, int>> GetAllDietMeals(List<Participant> participants)
        {
            var dietMeals = new Dictionary<DayOfWeek, Dictionary<Diet, int>>();

            foreach (var day in Enum.GetValues(typeof(DayOfWeek)))
            {
                dietMeals.Add((DayOfWeek)day, GetDailyDietMeals(participants, (DayOfWeek)day));
            }
            return dietMeals;
        }
    }
}
