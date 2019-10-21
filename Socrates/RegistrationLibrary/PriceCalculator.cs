using System;
using System.Collections.Generic;
using System.Text;

namespace RegistrationLibrary
{
    public static class PriceCalculator
    {
        public static int TotalAmount(Reservation reservation) {
            var choiceAmount = (int)reservation.Choice;
            var remise = reservation.MissingMeals * 40;
            
            return choiceAmount - remise;
        }
    }
}
