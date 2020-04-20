using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ClienteOperacionesConsola
{
    class Program
    {
        static void Main(string[] args)
        {
            int a=int.Parse( Console.ReadLine());
            int b = int.Parse(Console.ReadLine());
            servicio.servicio1Client cl = new servicio.servicio1Client();
            Console.WriteLine("elresultado es {0}", cl.restar(a, b));
            Console.ReadKey();

        }
    }
}
