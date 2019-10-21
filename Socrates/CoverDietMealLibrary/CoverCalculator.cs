﻿using System;
using System.Collections.Generic;

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
    }
}
