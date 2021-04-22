using System.Collections;
using System.Collections.Generic;

namespace Bar_Web_API.Model
{
    public class Inventory
    {
        public int Id { get; set; }
        public ICollection<Item> Items { get; set; }
    }
}