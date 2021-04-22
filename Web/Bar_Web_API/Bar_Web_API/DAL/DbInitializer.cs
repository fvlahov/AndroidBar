using Bar_Web_API.Model;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace Bar_Web_API.DAL
{
    public static class DbInitializer
    {
        public static void Initialize(ApplicationDbContext context)
        {
            context.Database.EnsureCreated();

            // Look for any students.
            if (context.Items.Any())
            {
                return;   // DB has been seeded
            }

            var items = new Item[]
            {
                new Item{Name = "Kava", MinSupply = 2, UnitOfMeasurement = UnitOfMeasurement.KG, CurrentSupply = 1},
                new Item{Name = "Ožujsko", MinSupply = 20, UnitOfMeasurement = UnitOfMeasurement.BOTTLE, CurrentSupply = 15},
                new Item{Name = "Zlatni Pan", MinSupply = 20, UnitOfMeasurement = UnitOfMeasurement.BOTTLE, CurrentSupply = 10},
                new Item{Name = "Pan", MinSupply = 10, UnitOfMeasurement = UnitOfMeasurement.BOTTLE, CurrentSupply = 10},
                new Item{Name = "Krušovice", MinSupply = 10, UnitOfMeasurement = UnitOfMeasurement.BOTTLE, CurrentSupply = 5},
                new Item{Name = "Stella Artois", MinSupply = 5, UnitOfMeasurement = UnitOfMeasurement.BOTTLE, CurrentSupply = 7},
                new Item{Name = "Heineken", MinSupply = 5, UnitOfMeasurement = UnitOfMeasurement.BOTTLE, CurrentSupply = 6},
                new Item{Name = "Karlovačko", MinSupply = 20, UnitOfMeasurement = UnitOfMeasurement.BOTTLE, CurrentSupply = 10},
                new Item{Name = "Tomislav", MinSupply = 20, UnitOfMeasurement = UnitOfMeasurement.BOTTLE, CurrentSupply = 10},
                new Item{Name = "Stari lisac", MinSupply = 10, UnitOfMeasurement = UnitOfMeasurement.BOTTLE, CurrentSupply = 14}
            };

            foreach (var item in items)
            {
                context.Items.Add(item);
            }

            var inv = new Inventory
            {
                Items = items
            };

            context.Inventories.Add(inv);

            var users = new User[]
            {
                new User{Name="Ana", Username="ana", Password="lozinka", IsAdmin=true},
                new User{Name="Pero", Username="pero", Password="lozinka", IsAdmin=false},
                new User{Name="Šime", Username="sime", Password="lozinka", IsAdmin=false}
            };

            foreach (var user in users)
            {
                context.Users.Add(user);
            }

            var bar = new Bar
            {
                BarName = "Caffe Bar Gal",
                Inventory = inv,
                Users = users
            };

            context.Bars.Add(bar);

            context.SaveChanges();
        }
    }
}
