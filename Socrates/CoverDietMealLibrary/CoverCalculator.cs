using System;
using System.Collections.Generic;
using System.Linq;

namespace CoverDietMealLibrary
{
    public class CoverCalculator
    {
        public static int GetCovers(Participant participant)
        {
            return 2;
        }

        public static int GetCovers(List<Participant> participants)
        {
            return 2 * participants.Count;
        }

        public static int GetPescatarianCovers(Participant participant)
        {
            return participant.Diet == Diet.Pescatarian ? 2 : 0;
        }

        public static int GetPescatarianCovers(List<Participant> participants)
        {
            return participants.Where(p => p.Diet == Diet.Pescatarian).Count() * 2;
        }

        public static int GetPescatarianCovers(Participant participant, DayOfWeek dayOfWeek)
        {
            var isPresent = participant.IsPresentOn(dayOfWeek);

            return participant.Diet == Diet.Pescatarian && isPresent ? 2 : 0;
        }
    }
}
