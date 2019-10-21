using NFluent;
using NUnit.Framework;
using RegistrationLibrary;
using System;
using System.Collections.Generic;
using System.Text;

namespace Socrates.Tests.RegistrationLibraryTests
{
    [TestFixture]
    class PriceCalculatorTests
    {
        [Test]
        public void SingleChoiceTotalAmount()
        {
            //Given
            var reservation = new Reservation(Choice.Single);

            //Then
            Check.That(
                PriceCalculator.TotalAmount(
                    reservation
                )).IsEqualTo(610);
        }

        [Test]
        public void TwinChoiceTotalAmount()
        {
            //Given
            var reservation = new Reservation(Choice.Twin);

            //Then
            Check.That(
                PriceCalculator.TotalAmount(
                    reservation
                )).IsEqualTo(510);
        }

        [Test]
        public void TripleChoiceTotalAmount()
        {
            //Given
            var reservation = new Reservation(Choice.Triple);

            //Then
            Check.That(
                PriceCalculator.TotalAmount(
                    reservation
                )).IsEqualTo(410);
        }

        [Test]
        public void NoAccommodationChoiceTotalAmount()
        {
            //Given
            var reservation = new Reservation(Choice.NoAccommodation);

            //Then
            Check.That(
                PriceCalculator.TotalAmount(
                    reservation
                )).IsEqualTo(240);
        }

        [Test]
        public void PriceCalculatorReturnsTwinChoice_Missing_1_Meal_TotalAmount()
        {
            //Given
            var reservation = new Reservation(Choice.Twin, missingMeals: 1);

            //Then
            Check.That(
                PriceCalculator.TotalAmount(
                    reservation
                )).IsEqualTo(470);
        }
    }
}
