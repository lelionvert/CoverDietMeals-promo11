using CoverDietMealLibrary;
using NFluent;
using NUnit.Framework;
using RegistrationLibrary;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using DayOfWeek = RegistrationLibrary.DayOfWeek;

namespace Socrates.Tests.CoverDietMealLibraryTests
{
    [TestFixture]
    class CoverCalculatorTests
    {
        private Reservation fullReservation;
        private Participant pescatarianParticipant;
        private Participant omnivoreParticipant;
        private Participant veganParticipant;
        private Participant vegetarianParticipant;
        private List<Participant> participants;

        [OneTimeSetUp]
        public void Init()
        {
            fullReservation = new Reservation(
                        Choice.Single,
                        checkin: new CheckTime(
                            DayOfWeek.Thursday
                        ),
                        checkout: new CheckTime(
                            DayOfWeek.Sunday
                            )
                        );

            pescatarianParticipant = new Participant(
                Diet.Pescatarian,
                fullReservation
            );
            omnivoreParticipant = new Participant(
                Diet.Omnivore,
                fullReservation
            );
            veganParticipant = new Participant(
                Diet.Vegan, 
                fullReservation
            );
            vegetarianParticipant = new Participant(
                Diet.Vegetarian, 
                fullReservation
            );
        }

        [SetUp]
        public void InitList()
        {
            participants = new List<Participant>();
        }


        [Test]
        public void OnADay_1_PescatarianParticipant_Return_2_Covers()
        {
            //Given
            participants.Add(pescatarianParticipant);

            //When
            int nbCovers = CoverCalculator.GetCovers(participants, Diet.Pescatarian, DayOfWeek.Friday);

            //Then
            Check.That(nbCovers).IsEqualTo(2);
        }

        [Test]
        public void OnADay_2_PescatarianParticipants_Return_4_Covers()
        {
            //Given
            participants.Add(pescatarianParticipant);
            participants.Add(pescatarianParticipant);

            //When
            int nbCovers = CoverCalculator.GetCovers(participants, Diet.Pescatarian, DayOfWeek.Friday);

            //Then
            Check.That(nbCovers).IsEqualTo(4);
        }

        [Test]
        public void OnADay_1_Omnivore_1_Pescatarian_Participants_Return_2_PescatarianCovers()
        {
            //Given
            participants.Add(pescatarianParticipant);
            participants.Add(omnivoreParticipant);

            //When
            int nbCovers = CoverCalculator.GetCovers(participants, Diet.Pescatarian, DayOfWeek.Friday);

            //Then
            Check.That(nbCovers).IsEqualTo(2);
        }

        [Test]
        public void OnADay_1_Omnivore_1_Pescatarian_Participants_Return_2_OmnivoreCovers()
        {
            //Given
            participants.Add(pescatarianParticipant);
            participants.Add(omnivoreParticipant);

            //When
            int nbCovers = CoverCalculator.GetCovers(participants, Diet.Omnivore, DayOfWeek.Friday);

            //Then
            Check.That(nbCovers).IsEqualTo(2);
        }

        [Test]
        public void OnASaturday_1_PescatarianParticipant_Return_0_PescatarianCovers()
        {
            //Given
            var reservation = new Reservation(
                        Choice.Single,
                        checkin: new CheckTime(
                            DayOfWeek.Friday
                        ),
                        checkout: new CheckTime(
                            DayOfWeek.Friday
                            )
                        );
            var participant = new Participant(
                Diet.Pescatarian,
                reservation
            );
            participants.Add(participant);
            //When
            int nbCovers = CoverCalculator.GetCovers(participants, Diet.Pescatarian, DayOfWeek.Saturday);

            //Then
            Check.That(nbCovers).IsEqualTo(0);
        }

        [Test]
        public void OnAThursday_1_PescatarianParticipant_Return_0_PescatarianCovers()
        {
            //Given
            var reservation = new Reservation(
                        Choice.Single,
                        checkin: new CheckTime(
                            DayOfWeek.Friday
                        ),
                        checkout: new CheckTime(
                            DayOfWeek.Saturday
                            )
                        );
            var participant = new Participant(
                Diet.Pescatarian,
                reservation
            );
            participants.Add(participant);

            //When
            int nbCovers = CoverCalculator.GetCovers(participants, Diet.Pescatarian, DayOfWeek.Thursday);

            //Then
            Check.That(nbCovers).IsEqualTo(0);
        }

        [Test]
        public void OnAThursday_1_PescatarianParticipant_Return_1_PescatarianCovers()
        {
            //Given
            participants.Add(pescatarianParticipant);

            //When
            int nbCovers = CoverCalculator.GetCovers(participants, Diet.Pescatarian, DayOfWeek.Thursday);

            //Then
            Check.That(nbCovers).IsEqualTo(1);
        }

        [Test]
        public void OnAFriday_1_VeganParticipant_Return_2_VeganCovers()
        {
            //Given
            participants.Add(veganParticipant);

            //When
            int nbCovers = CoverCalculator.GetCovers(participants, Diet.Vegan, DayOfWeek.Friday);

            //Then
            Check.That(nbCovers).IsEqualTo(2);
        }

        [Test]
        public void OnAFriday_1_Vegetarian_1_Vegan_1_Pescatarian_Participants_Return_2_VegetarianCovers()
        {
            //Given
            participants.Add(veganParticipant);
            participants.Add(vegetarianParticipant);
            participants.Add(pescatarianParticipant);

            //When
            int nbCovers = CoverCalculator.GetCovers(participants, Diet.Vegetarian, DayOfWeek.Friday);

            //Then
            Check.That(nbCovers).IsEqualTo(2);
        }


        [Test]
        public void DailyDietMeals()
        {
            //Given
            participants.Add(veganParticipant);
            participants.Add(vegetarianParticipant);
            participants.Add(vegetarianParticipant);
            participants.Add(pescatarianParticipant);

            //When
            var dailyDietMeals = CoverCalculator.GetDailyDietMeals(participants, DayOfWeek.Friday);

            //Then
            Check.That(dailyDietMeals[Diet.Vegetarian]).IsEqualTo(4);
            Check.That(dailyDietMeals[Diet.Vegan]).IsEqualTo(2);
            Check.That(dailyDietMeals[Diet.Pescatarian]).IsEqualTo(2);
            Check.That(dailyDietMeals[Diet.Omnivore]).IsEqualTo(0);
        }


        [Test]
        public void AllDietMeals()
        {
            //Given
            participants.Add(veganParticipant);
            participants.Add(vegetarianParticipant);
            participants.Add(vegetarianParticipant);
            participants.Add(pescatarianParticipant);

            //When
            var dietMeals = CoverCalculator.GetAllDietMeals(participants);

            //Then
            //On Thursday
            Check.That(dietMeals[DayOfWeek.Thursday][Diet.Vegetarian]).IsEqualTo(2);
            Check.That(dietMeals[DayOfWeek.Thursday][Diet.Vegan]).IsEqualTo(1);
            Check.That(dietMeals[DayOfWeek.Thursday][Diet.Pescatarian]).IsEqualTo(1);
            Check.That(dietMeals[DayOfWeek.Thursday][Diet.Omnivore]).IsEqualTo(0);
            //On Friday
            Check.That(dietMeals[DayOfWeek.Friday][Diet.Vegetarian]).IsEqualTo(4);
            Check.That(dietMeals[DayOfWeek.Friday][Diet.Vegan]).IsEqualTo(2);
            Check.That(dietMeals[DayOfWeek.Friday][Diet.Pescatarian]).IsEqualTo(2);
            Check.That(dietMeals[DayOfWeek.Friday][Diet.Omnivore]).IsEqualTo(0);
        }

        [Test]
        public void PrintMealsPlanning()
        {
            //Given
            var dietMeals = CoverCalculator.GetAllDietMeals(participants);

            //When
            var resume = MealPrinter.Print(dietMeals);

            //Then
            Check.That(resume).IsEqualTo(
                new StringBuilder()
                .AppendLine("Thursday:[Omnivore, 0][Pescatarian, 0][Vegan, 0][Vegetarian, 0]")
                .AppendLine("Friday:[Omnivore, 0][Pescatarian, 0][Vegan, 0][Vegetarian, 0]")
                .AppendLine("Saturday:[Omnivore, 0][Pescatarian, 0][Vegan, 0][Vegetarian, 0]")
                .AppendLine("Sunday:[Omnivore, 0][Pescatarian, 0][Vegan, 0][Vegetarian, 0]")
                .ToString()
            );
        }

        [Test]
        public void PrintParticipantsMealsPlanning()
        {
            //Given
            participants.Add(veganParticipant);
            participants.Add(vegetarianParticipant);
            participants.Add(vegetarianParticipant);
            participants.Add(pescatarianParticipant);
            var dietMeals = CoverCalculator.GetAllDietMeals(participants);

            //When
            var resume = MealPrinter.Print(dietMeals);

            //Then
            Check.That(resume).IsEqualTo(
                new StringBuilder()
                .AppendLine("Thursday:[Omnivore, 0][Pescatarian, 1][Vegan, 1][Vegetarian, 2]")
                .AppendLine("Friday:[Omnivore, 0][Pescatarian, 2][Vegan, 2][Vegetarian, 4]")
                .AppendLine("Saturday:[Omnivore, 0][Pescatarian, 2][Vegan, 2][Vegetarian, 4]")
                .AppendLine("Sunday:[Omnivore, 0][Pescatarian, 1][Vegan, 1][Vegetarian, 2]")
                .ToString()
            );
        }
    }
}
