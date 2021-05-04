using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace Bar_Web_API.Model
{
    public class Bar
    {
        public int Id { get; set; }
        public string BarName { get; set; }
        public Inventory Inventory { get; set; }
        public ICollection<User> Users { get; set; }
        public ICollection<Shift> Shifts { get; set; }
    }
}
