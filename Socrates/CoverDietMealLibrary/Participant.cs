using System;
using System.Collections.Generic;
using System.Text;

namespace CoverDietMealLibrary
{
    public enum Diet
    {
        Pescatarian
    };

    public class Participant
    {
        public Diet Diet
        {
            get;
            private set;
        }

        public Participant(Diet diet)
        {
            Diet = diet;
        }

        public Participant()
        {
        }
    }
}
