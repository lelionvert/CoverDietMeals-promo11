﻿using System;
using System.Collections.Generic;
using System.Text;
using RegistrationLibrary;
using DayOfWeek = RegistrationLibrary.DayOfWeek;

namespace CoverDietMealLibrary
{
    public enum Diet
    {
        Omnivore,
        Pescatarian,
        Vegan
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
            return 
                dayOfWeek >= reservation.CheckIn.DayOfWeek
                && dayOfWeek <= reservation.CheckOut.DayOfWeek; 
        }

        internal bool IsDietType(Diet diet)
        {
            return Diet == diet;
        }
    }
}
