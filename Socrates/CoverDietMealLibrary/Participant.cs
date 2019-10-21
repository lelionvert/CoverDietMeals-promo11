using System;
using System.Collections.Generic;
using System.Text;
using RegistrationLibrary;

namespace CoverDietMealLibrary
{
    public enum Diet
    {
        Omnivore,
        Pescatarian
    };

    public class Participant
    {
        private Reservation reservation;

        public Diet Diet
        {
            get;
            private set;
        }

        public Participant(Diet diet = Diet.Omnivore, Reservation reservation = null)
        {
            Diet = diet;
            this.reservation = reservation;
        }
        
        internal bool IsPresentOn(DayOfWeek dayOfWeek)
        {
            return true;
        }
    }
}
