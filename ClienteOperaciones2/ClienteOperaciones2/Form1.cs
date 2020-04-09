using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace ClienteOperaciones2
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            servicios.OperacionesSoapClient operaciones = new servicios.OperacionesSoapClient();
            int a = int.Parse(txtA.Text);
            int b = int.Parse(txtB.Text);

            int c=operaciones.sumar(a, b);
            lblResultado.Text = c.ToString();
        }
    }
}
