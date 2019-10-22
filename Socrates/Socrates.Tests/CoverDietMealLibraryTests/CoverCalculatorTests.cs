using CoverDietMealLibrary;
using NFluent;
using NUnit.Framework;
using RegistrationLibrary;
using System;
using System.Collections.Generic;
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
            var veganParticipant = new Participant(Diet.Vegan, fullReservation);
            participants.Add(veganParticipant);

            //When
            int nbCovers = CoverCalculator.GetCovers(participants, Diet.Vegan, DayOfWeek.Friday);

            //Then
            Check.That(nbCovers).IsEqualTo(2);
        }
    }
}
