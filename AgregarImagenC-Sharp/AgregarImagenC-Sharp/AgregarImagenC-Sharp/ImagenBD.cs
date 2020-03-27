using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System;
using System.Collections.Generic;
using System.Data.SqlClient;
    
namespace AgregarImagenC_Sharp
{
    class ImagenBD
    {






        public void InsertarImagen(String desc,double precio,int existencias,String ingredientes,String tipo, System.Windows.Forms.PictureBox pbImagen)
        {
            using (SqlConnection conn = new SqlConnection(Conexion.Cadena))
            {
                conn.Open();
                string sql = "PA_InsertarProducto";
                SqlCommand comando = new SqlCommand(sql, conn);
                comando.CommandType = System.Data.CommandType.StoredProcedure;


                comando.Parameters.Add("@descripcion", System.Data.SqlDbType.VarChar);
                comando.Parameters.Add("@Imagen", System.Data.SqlDbType.Image);
                comando.Parameters.Add("@precio", System.Data.SqlDbType.Money);
                comando.Parameters.Add("@existencias", System.Data.SqlDbType.Int);
                comando.Parameters.Add("@tipo", System.Data.SqlDbType.VarChar);
                comando.Parameters.Add("@ingredientes", System.Data.SqlDbType.VarChar);
                comando.Parameters.Add("@estado", System.Data.SqlDbType.Int);


                comando.Parameters["@descripcion"].Value = desc;
                comando.Parameters["@imagen"].Value = pbImagen;
                comando.Parameters["@precio"].Value = precio;
                comando.Parameters["@existencias"].Value = existencias;
                comando.Parameters["@tipo"].Value = tipo;
                comando.Parameters["@ingredientes"].Value = ingredientes;
                comando.Parameters["@estado"].Value = 1;
                /*
                comando.Parameters.Add("@IdProductoFinal", System.Data.SqlDbType.Int);
                comando.Parameters.Add("@Descripcion", System.Data.SqlDbType.NChar);
                comando.Parameters.Add("@Img", System.Data.SqlDbType.Image);


                comando.Parameters["@IdProductoFinal"].Value = idProducto;
                comando.Parameters["@Descripcion"].Value = descripcionImagen;
                */

                System.IO.MemoryStream ms = new System.IO.MemoryStream();

                pbImagen.Image.Save(ms, System.Drawing.Imaging.ImageFormat.Jpeg);
                comando.Parameters["@imagen"].Value = ms.GetBuffer();
                comando.ExecuteNonQuery();
            }
        }



    }
}
