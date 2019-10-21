using System;
using NFluent;
using NUnit.Framework;
using RegistrationLibrary;

namespace Socrates.Tests.RegistrationLibraryTests
{
    [TestFixture]
    public class DinerCalculatorTests
    {
        /*
         *
         * Missing Meals
         *
         */

        [Test]
        public void VictoriaReservationMissingNoMealAccordingToChecks()
        {
            //Given / When
            var reservation = new Reservation(
                        choice: Choice.Triple,
                        checkin: new CheckTime(
                            DayOfWeek.Thursday,
                            hour: 21,
                            min: 0
                        ),
                        checkout: new CheckTime(
                            DayOfWeek.Sunday,
                            hour: 15,
                            min: 0
            ));
            //Then
            Check.That(reservation.MissingMeals).IsEqualTo(0);
        }

        [Test]
        public void JeanPierreReservationMissingNoMealAccordingToChecks()
        {
            //Given / When
            var reservation = new Reservation(
                        choice: Choice.NoAccommodation,
                        checkin: new CheckTime(
                            DayOfWeek.Thursday,
                            "18:00"
                        ),
                        checkout: new CheckTime(
                            DayOfWeek.Sunday,
                            "14:00"
            ));
            //Then
            Check.That(reservation.MissingMeals).IsEqualTo(0);
        }

        [Test]
        public void SarahReservationMissingNoMealAccordingToChecks()
        {
            //Given / When
            var reservation = new Reservation(
                        choice: Choice.NoAccommodation,
                        checkin: new CheckTime(
                            DayOfWeek.Thursday,
                            "22:00"
                        ),
                        checkout: new CheckTime(
                            DayOfWeek.Sunday,
                            "14:30"
            ));
            //Then
            Check.That(reservation.MissingMeals).IsEqualTo(0);
        }

        [Test]
        //[Ignore("Work In Progress")]
        public void MichelReservationMissing_1_MealAccordingToChecks()
        {
            //Given / When
            var reservation = new Reservation(
                        choice: Choice.Twin,
                        checkin: new CheckTime(
                            DayOfWeek.Friday,
                            hour: 8,
                            min: 0
                        ),
                        checkout: new CheckTime(
                            DayOfWeek.Sunday,
                            hour: 14,
                            min: 30
            ));
            //Then
            Check.That(DinerCalculator.MissingMeals(reservation)).IsEqualTo(1);
        }
    }
}
