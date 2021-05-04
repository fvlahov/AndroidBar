using Bar_Web_API.DAL;
using Bar_Web_API.Model;
using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;
using Microsoft.Extensions.Logging;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace Bar_Web_API.Controllers
{
    [ApiController]

    public class BarController : ControllerBase
    {
        private readonly ApplicationDbContext context;

        public BarController(ApplicationDbContext context)
        {
            this.context = context;
        }

        [HttpGet]
        [Route("[controller]")]
        public Bar Authenticate(string username, string password)
        {
            Bar bar = new Bar();
            try
            {
                var user = context.Users.FirstOrDefault(u => u.Username == username && u.Password == password);

                bar = context.Bars.
                    Include(b => b.Users.Where(u => u.Id == user.Id)).
                    Include(b => b.Inventory).
                    ThenInclude(i => i.Items).
                    Include(b => b.Shifts).
                    ToList().
                    Find(b => b.Users.ToList().Find(u => u.Id == user.Id) == user);

            }
            catch (Exception)
            {
                
            }


            return bar;
        }

        [HttpGet]
        [Route("[controller]/shifts")]
        public ICollection<Shift> GetShifts(string username, string password)
        {
            try
            {
                var output = new List<Shift>();

                var user = context.Users.FirstOrDefault(u => u.Username == username && u.Password == password);

                return context.Bars.
                    Include(b => b.Users.Where(u => u.Id == user.Id)).
                    Include(b => b.Shifts).
                    ThenInclude(s => s.Worker).
                    ToList().FirstOrDefault().Shifts;
            }
            catch (Exception)
            {
                return new List<Shift>();
            }

        }
    }
}
