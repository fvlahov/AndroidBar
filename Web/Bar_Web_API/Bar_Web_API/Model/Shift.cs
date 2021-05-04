using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace Bar_Web_API.Model
{
    public class Shift
    {
        public int Id { get; set; }
        public DateTime DateTime { get; set; }
        public float ShiftDurationHours { get; set; }
        public ShiftStatus ShiftStatus{ get; set; }
        public User Worker { get; set; }
    }
}
