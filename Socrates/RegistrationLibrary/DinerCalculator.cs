using System;

namespace RegistrationLibrary
{
    public class DinerCalculator
    {
        public static object MissingMeals(Reservation reservation)
        {
            var missingMeals = 0;

            if (reservation.CheckIn.DayOfWeek == DayOfWeek.Friday
                && reservation.CheckIn.Hour == 8)
                ++missingMeals;
            return missingMeals;
        }
    }
}