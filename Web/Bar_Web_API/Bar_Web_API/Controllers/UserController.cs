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
    [Route("[controller]")]
    public class UserController : ControllerBase
    {
        private readonly ApplicationDbContext context;

        public UserController(ApplicationDbContext context)
        {
            this.context = context;
        }

        [HttpGet]
        public Bar Authenticate(string username, string password)
        {
            Bar bar = new Bar();
            try
            {
                var user = context.Users.FirstOrDefault(u => u.Username == username && u.Password == password);

                bar = context.Bars.
                    Include(b => b.Inventory).
                    ThenInclude(i => i.Items).
                    Include(b => b.Users).
                    ToList().
                    Find(b => b.Users.ToList().Find(u => u.Id == user.Id) == user);
            }
            catch (Exception)
            {
                
            }


            return bar;
        }
    }
}
