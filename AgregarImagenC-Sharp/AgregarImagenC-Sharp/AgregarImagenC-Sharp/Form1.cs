using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace AgregarImagenC_Sharp
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void button4_Click(object sender, EventArgs e)
        {
            try
            {
                this.openFileDialog1.ShowDialog();
                if (!this.openFileDialog1.FileName.Equals(""))
                    pbImagen.Load(this.openFileDialog1.FileName);

            }
            catch (Exception ex)
            {

                MessageBox.Show("No se pudo cargar la imagen debido a " + ex.Message);
            }
        }

        private void button3_Click(object sender, EventArgs e)
        {
            try
            {
                String desc = txtDescripcionImagen.Text;
                double precio = Double.Parse(txtprecio.Text);
                int existencias = int.Parse(txtexistencias.Text);
                String ingredientes = txtingredientes.Text;
                String tipo = cbotipo.Text;




                ImagenBD img = new ImagenBD();
                img.InsertarImagen(desc, precio, existencias, ingredientes, tipo, pbImagen);

                MessageBox.Show("Imagen agregada con éxito!");

            }
            catch (Exception x)
            {
                MessageBox.Show("Error debido a "+x.Message);
                throw;
            }
        }
    }
}
