using System;
using System.Collections.Generic;
using System.Linq;
using DayOfWeek = RegistrationLibrary.DayOfWeek;

namespace CoverDietMealLibrary
{
    public class CoverCalculator
    {
        public static int GetCovers(Participant participant)
        {
            return 2;
        }
        public static int GetCovers(Participant participant, Diet diet)
        {
            return participant.IsDietType(diet) ? 2 : 0;
        }

        public static int GetCovers(List<Participant> participants)
        {
            return 2 * participants.Count;
        }

        public static int GetCovers(List<Participant> participants, Diet diet)
        {
            return 2 * participants.Where(p => p.IsDietType(diet)).Count();
        }

        public static int GetCovers(Participant participant, Diet diet, DayOfWeek dayOfWeek)
        {
            return participant.IsDietType(diet)
                && participant.IsPresentOn(dayOfWeek) ?
                2 : 0;
        }

        public static int GetCovers(List<Participant> participants, Diet diet, DayOfWeek dayOfWeek)
        {
            return participants.Where(p => p.IsDietType(diet) && p.IsPresentOn(dayOfWeek)).Count() * 2;
        }
    }
}
