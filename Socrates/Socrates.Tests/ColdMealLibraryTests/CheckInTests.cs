using NUnit.Framework;
using NFluent;
using Library;
using System;

namespace Socrates.Tests
{
    [TestFixture]
    public class Tests
    {

        [Test]
        public void CheckInExists()
        {
            var checkin = new CheckIn();

            Assert.Pass();
        }

        [Test]
        public void CheckInHourBefore_9_PM()
        {
            var deadline = new DateTime(2019, 1, 1, 21, 0, 0);
            var time = new DateTime()
                .AddHours(21)
                .AddSeconds(1);
            var checkin = new CheckIn();

            Check.That(checkin.IsLate(deadline)).IsEqualTo(false);
        }

        [Test]
        public void CheckInAt_9_PM()
        {
            var deadline = new DateTime(2019, 1, 1, 21, 0, 0);
            var time = new DateTime()
                .AddHours(21);
            var checkin = new CheckIn(time);

            Check.That(checkin.IsLate(deadline)).IsEqualTo(false);
        }

        [Test]
        public void CheckInHourAfter_9_PM()
        {
            var deadline = new DateTime(2019, 1, 1, 21, 0, 0);
            var time = new DateTime()
                .AddHours(21)
                .AddSeconds(1);
            var checkin = new CheckIn(time);

            Check.That(checkin.IsLate(deadline)).IsEqualTo(true);
        }

        [Test]
        public void CheckIfCheckInIsForThursday()
        {
            //datetime setted on thursday
            var datetime = new DateTime(2003, 5, 1);
            var checkin = new CheckIn(datetime);

            Check.That(checkin.IsThursday())
                .IsEqualTo(true);
        }

        [Test]
        public void CheckIfCheckInIsNotForThursday()
        {
            //datetime setted on friday
            var datetime = new DateTime(2003, 5, 2);
            var checkin = new CheckIn(datetime);

            Check.That(checkin.IsThursday())
                .IsEqualTo(false);
        }
    }
}