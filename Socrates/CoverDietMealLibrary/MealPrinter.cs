using System;
using System.Collections.Generic;
using System.Text;
using RegistrationLibrary;

namespace CoverDietMealLibrary
{
    public class MealPrinter
    {
        public static string Print(Dictionary<RegistrationLibrary.DayOfWeek, Dictionary<Diet, int>> dietMeals)
        {
            StringBuilder stringBuilder = new StringBuilder();
            foreach(var day in dietMeals.Keys)
            {
                stringBuilder.Append($"{day}:");
                foreach (var diet in dietMeals[day])
                {
                    stringBuilder.Append($"{diet}"); ;
                }
                stringBuilder.AppendLine();
            }
            return stringBuilder.ToString();
        }

        public static void ConsolePrint(Dictionary<RegistrationLibrary.DayOfWeek, Dictionary<Diet, int>> dietMeals)
        {
            Console.WriteLine(Print(dietMeals));
        }
    }
}
