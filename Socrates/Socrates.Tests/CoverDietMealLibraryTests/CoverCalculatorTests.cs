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
    }
}
