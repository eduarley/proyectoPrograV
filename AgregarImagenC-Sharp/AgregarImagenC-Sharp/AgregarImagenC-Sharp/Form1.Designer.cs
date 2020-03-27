namespace AgregarImagenC_Sharp
{
    partial class Form1
    {
        /// <summary>
        /// Variable del diseñador necesaria.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Limpiar los recursos que se estén usando.
        /// </summary>
        /// <param name="disposing">true si los recursos administrados se deben desechar; false en caso contrario.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Código generado por el Diseñador de Windows Forms

        /// <summary>
        /// Método necesario para admitir el Diseñador. No se puede modificar
        /// el contenido de este método con el editor de código.
        /// </summary>
        private void InitializeComponent()
        {
            this.components = new System.ComponentModel.Container();
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(Form1));
            this.groupBox2 = new System.Windows.Forms.GroupBox();
            this.cbotipo = new System.Windows.Forms.ComboBox();
            this.label5 = new System.Windows.Forms.Label();
            this.txtingredientes = new System.Windows.Forms.TextBox();
            this.label4 = new System.Windows.Forms.Label();
            this.txtexistencias = new System.Windows.Forms.TextBox();
            this.label3 = new System.Windows.Forms.Label();
            this.txtprecio = new System.Windows.Forms.TextBox();
            this.label2 = new System.Windows.Forms.Label();
            this.label1 = new System.Windows.Forms.Label();
            this.button1 = new System.Windows.Forms.Button();
            this.button3 = new System.Windows.Forms.Button();
            this.button4 = new System.Windows.Forms.Button();
            this.txtDescripcionImagen = new System.Windows.Forms.TextBox();
            this.label9 = new System.Windows.Forms.Label();
            this.pbImagen = new System.Windows.Forms.PictureBox();
            this.openFileDialog1 = new System.Windows.Forms.OpenFileDialog();
            this.errorProvider1 = new System.Windows.Forms.ErrorProvider(this.components);
            this.richTextBox1 = new System.Windows.Forms.RichTextBox();
            this.groupBox2.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.pbImagen)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.errorProvider1)).BeginInit();
            this.SuspendLayout();
            // 
            // groupBox2
            // 
            this.groupBox2.Controls.Add(this.cbotipo);
            this.groupBox2.Controls.Add(this.label5);
            this.groupBox2.Controls.Add(this.txtingredientes);
            this.groupBox2.Controls.Add(this.label4);
            this.groupBox2.Controls.Add(this.txtexistencias);
            this.groupBox2.Controls.Add(this.label3);
            this.groupBox2.Controls.Add(this.txtprecio);
            this.groupBox2.Controls.Add(this.label2);
            this.groupBox2.Controls.Add(this.label1);
            this.groupBox2.Controls.Add(this.button1);
            this.groupBox2.Controls.Add(this.button3);
            this.groupBox2.Controls.Add(this.button4);
            this.groupBox2.Controls.Add(this.txtDescripcionImagen);
            this.groupBox2.Controls.Add(this.label9);
            this.groupBox2.Controls.Add(this.pbImagen);
            this.groupBox2.Location = new System.Drawing.Point(12, 12);
            this.groupBox2.Name = "groupBox2";
            this.groupBox2.Size = new System.Drawing.Size(323, 461);
            this.groupBox2.TabIndex = 54;
            this.groupBox2.TabStop = false;
            this.groupBox2.Text = "Imagen";
            // 
            // cbotipo
            // 
            this.cbotipo.FormattingEnabled = true;
            this.cbotipo.Items.AddRange(new object[] {
            "Desayuno",
            "Almuerzo",
            "Cena"});
            this.cbotipo.Location = new System.Drawing.Point(95, 159);
            this.cbotipo.Name = "cbotipo";
            this.cbotipo.Size = new System.Drawing.Size(121, 21);
            this.cbotipo.TabIndex = 51;
            // 
            // label5
            // 
            this.label5.AutoSize = true;
            this.label5.Location = new System.Drawing.Point(16, 159);
            this.label5.Name = "label5";
            this.label5.Size = new System.Drawing.Size(28, 13);
            this.label5.TabIndex = 50;
            this.label5.Text = "Tipo";
            // 
            // txtingredientes
            // 
            this.txtingredientes.Location = new System.Drawing.Point(95, 126);
            this.txtingredientes.Name = "txtingredientes";
            this.txtingredientes.Size = new System.Drawing.Size(153, 20);
            this.txtingredientes.TabIndex = 48;
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.Location = new System.Drawing.Point(16, 129);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(65, 13);
            this.label4.TabIndex = 49;
            this.label4.Text = "Ingredientes";
            // 
            // txtexistencias
            // 
            this.txtexistencias.Location = new System.Drawing.Point(95, 96);
            this.txtexistencias.Name = "txtexistencias";
            this.txtexistencias.Size = new System.Drawing.Size(153, 20);
            this.txtexistencias.TabIndex = 46;
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Location = new System.Drawing.Point(16, 99);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(60, 13);
            this.label3.TabIndex = 47;
            this.label3.Text = "Existencias";
            // 
            // txtprecio
            // 
            this.txtprecio.Location = new System.Drawing.Point(95, 69);
            this.txtprecio.Name = "txtprecio";
            this.txtprecio.Size = new System.Drawing.Size(153, 20);
            this.txtprecio.TabIndex = 44;
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(16, 72);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(37, 13);
            this.label2.TabIndex = 45;
            this.label2.Text = "Precio";
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(148, 212);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(42, 13);
            this.label1.TabIndex = 43;
            this.label1.Text = "Imagen";
            // 
            // button1
            // 
            this.button1.Location = new System.Drawing.Point(263, 10);
            this.button1.Name = "button1";
            this.button1.Size = new System.Drawing.Size(43, 23);
            this.button1.TabIndex = 42;
            this.button1.Text = "X";
            this.button1.UseVisualStyleBackColor = true;
            // 
            // button3
            // 
            this.button3.Location = new System.Drawing.Point(57, 434);
            this.button3.Name = "button3";
            this.button3.Size = new System.Drawing.Size(191, 23);
            this.button3.TabIndex = 39;
            this.button3.Text = "Agregar";
            this.button3.UseVisualStyleBackColor = true;
            this.button3.Click += new System.EventHandler(this.button3_Click);
            // 
            // button4
            // 
            this.button4.Location = new System.Drawing.Point(196, 202);
            this.button4.Name = "button4";
            this.button4.Size = new System.Drawing.Size(52, 23);
            this.button4.TabIndex = 39;
            this.button4.Text = "....";
            this.button4.UseVisualStyleBackColor = true;
            this.button4.Click += new System.EventHandler(this.button4_Click);
            // 
            // txtDescripcionImagen
            // 
            this.txtDescripcionImagen.Location = new System.Drawing.Point(95, 41);
            this.txtDescripcionImagen.Name = "txtDescripcionImagen";
            this.txtDescripcionImagen.Size = new System.Drawing.Size(153, 20);
            this.txtDescripcionImagen.TabIndex = 38;
            // 
            // label9
            // 
            this.label9.AutoSize = true;
            this.label9.Location = new System.Drawing.Point(16, 44);
            this.label9.Name = "label9";
            this.label9.Size = new System.Drawing.Size(66, 13);
            this.label9.TabIndex = 39;
            this.label9.Text = "Descripción:";
            // 
            // pbImagen
            // 
            this.pbImagen.BackColor = System.Drawing.SystemColors.ActiveCaption;
            this.pbImagen.Location = new System.Drawing.Point(57, 241);
            this.pbImagen.Name = "pbImagen";
            this.pbImagen.Size = new System.Drawing.Size(191, 173);
            this.pbImagen.SizeMode = System.Windows.Forms.PictureBoxSizeMode.StretchImage;
            this.pbImagen.TabIndex = 37;
            this.pbImagen.TabStop = false;
            // 
            // openFileDialog1
            // 
            this.openFileDialog1.FileName = "openFileDialog1";
            // 
            // errorProvider1
            // 
            this.errorProvider1.ContainerControl = this;
            // 
            // richTextBox1
            // 
            this.richTextBox1.Location = new System.Drawing.Point(380, 28);
            this.richTextBox1.Name = "richTextBox1";
            this.richTextBox1.Size = new System.Drawing.Size(363, 348);
            this.richTextBox1.TabIndex = 56;
            this.richTextBox1.Text = resources.GetString("richTextBox1.Text");
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(788, 485);
            this.Controls.Add(this.richTextBox1);
            this.Controls.Add(this.groupBox2);
            this.Name = "Form1";
            this.Text = "Form1";
            this.groupBox2.ResumeLayout(false);
            this.groupBox2.PerformLayout();
            ((System.ComponentModel.ISupportInitialize)(this.pbImagen)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.errorProvider1)).EndInit();
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.GroupBox groupBox2;
        private System.Windows.Forms.ComboBox cbotipo;
        private System.Windows.Forms.Label label5;
        private System.Windows.Forms.TextBox txtingredientes;
        private System.Windows.Forms.Label label4;
        private System.Windows.Forms.TextBox txtexistencias;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.TextBox txtprecio;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Button button1;
        private System.Windows.Forms.Button button3;
        private System.Windows.Forms.Button button4;
        private System.Windows.Forms.TextBox txtDescripcionImagen;
        private System.Windows.Forms.Label label9;
        private System.Windows.Forms.PictureBox pbImagen;
        private System.Windows.Forms.OpenFileDialog openFileDialog1;
        private System.Windows.Forms.ErrorProvider errorProvider1;
        private System.Windows.Forms.RichTextBox richTextBox1;
    }
}

