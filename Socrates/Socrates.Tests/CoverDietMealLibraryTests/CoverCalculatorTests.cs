using CoverDietMealLibrary;
using NFluent;
using NUnit.Framework;
using RegistrationLibrary;
using System;
using System.Collections.Generic;
using System.Text;

namespace Socrates.Tests.CoverDietMealLibraryTests
{
    [TestFixture]
    class CoverCalculatorTests
    {
        [Test]
        public void OnADay_1_Participant_Return_2_Covers()
        {
            //Given
            Participant participant = new Participant();

            //When
            int nbCovers = CoverCalculator.GetCovers(participant);

            //Then
            Check.That(nbCovers).IsEqualTo(2);
        }

        [Test]
        public void OnADay_2_Participants_Return_4_Covers()
        {
            //Given
            var participants = new List<Participant>() { 
                new Participant(),
                new Participant()
            };

            //When
            int nbCovers = CoverCalculator.GetCovers(participants);

            //Then
            Check.That(nbCovers).IsEqualTo(4);
        }

        [Test]
        public void OnADay_1_PescatarianParticipant_Return_2_PescatarianCovers()
        {
            //Given
            Participant participant = new Participant(Diet.Pescatarian);

            //When
            int nbCovers = CoverCalculator.GetPescatarianCovers(participant);

            //Then
            Check.That(nbCovers).IsEqualTo(2);
        }

        [Test]
        public void OnADay_1_Omnivore_1_Pescatarian_Participants_Return_2_PescatarianCovers()
        {
            //Given
            var participants = new List<Participant>() {
                new Participant(Diet.Pescatarian),
                new Participant()
            };

            //When
            int nbCovers = CoverCalculator.GetPescatarianCovers(participants);

            //Then
            Check.That(nbCovers).IsEqualTo(2);
        }

        [Test]
        public void OnAFriday_1_PescatarianParticipant_Return_2_PescatarianCovers()
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

            //When
            int nbCovers = CoverCalculator.GetPescatarianCovers(participant, DayOfWeek.Friday);

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

            //When
            int nbCovers = CoverCalculator.GetPescatarianCovers(participant, DayOfWeek.Saturday);

            //Then
            Check.That(nbCovers).IsEqualTo(0);
        }

        [Test]
        public void OnASaturday_1_PescatarianParticipant_Return_2_PescatarianCovers()
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

            //When
            int nbCovers = CoverCalculator.GetPescatarianCovers(participant, DayOfWeek.Saturday);

            //Then
            Check.That(nbCovers).IsEqualTo(2);
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

            //When
            int nbCovers = CoverCalculator.GetPescatarianCovers(participant, DayOfWeek.Thursday);

            //Then
            Check.That(nbCovers).IsEqualTo(0);
        }
    }
}
