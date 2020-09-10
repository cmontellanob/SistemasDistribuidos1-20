using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace ClienteVotacion
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void label1_Click(object sender, EventArgs e)
        {

        }

        private void button1_Click(object sender, EventArgs e)
        {
            ServicioVotacion.WSVotacionClient wsvotacion = new ServicioVotacion.WSVotacionClient();
            String sigla = cbSigla.Text;
            String formato = cbFormato.Text; 
            double resultado=wsvotacion.obtenerVotacion(sigla,formato);
            lblResultado.Text = resultado.ToString();
        }
    }
}
