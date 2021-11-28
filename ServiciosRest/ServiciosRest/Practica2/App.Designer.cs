namespace Practica2
{
    partial class App
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
            this.ddlOpciones = new System.Windows.Forms.ListBox();
            this.tbParam = new System.Windows.Forms.TextBox();
            this.btnBuscar = new System.Windows.Forms.Button();
            this.gdvSigua = new System.Windows.Forms.DataGridView();
            this.lblParam = new System.Windows.Forms.Label();
            this.lblOpciones = new System.Windows.Forms.Label();
            this.backgroundWorker1 = new System.ComponentModel.BackgroundWorker();
            this.pnlApp = new System.Windows.Forms.Panel();
            this.listNombres = new System.Windows.Forms.ListBox();
            this.label1 = new System.Windows.Forms.Label();
            this.lblP1 = new System.Windows.Forms.Label();
            ((System.ComponentModel.ISupportInitialize)(this.gdvSigua)).BeginInit();
            this.pnlApp.SuspendLayout();
            this.SuspendLayout();
            // 
            // ddlOpciones
            // 
            this.ddlOpciones.FormattingEnabled = true;
            this.ddlOpciones.ItemHeight = 24;
            this.ddlOpciones.Location = new System.Drawing.Point(14, 48);
            this.ddlOpciones.Name = "ddlOpciones";
            this.ddlOpciones.Size = new System.Drawing.Size(536, 124);
            this.ddlOpciones.TabIndex = 0;
            // 
            // tbParam
            // 
            this.tbParam.Location = new System.Drawing.Point(881, 45);
            this.tbParam.Name = "tbParam";
            this.tbParam.Size = new System.Drawing.Size(317, 29);
            this.tbParam.TabIndex = 1;
            this.tbParam.TextChanged += new System.EventHandler(this.tbParam_TextChanged);
            // 
            // btnBuscar
            // 
            this.btnBuscar.Location = new System.Drawing.Point(14, 200);
            this.btnBuscar.Name = "btnBuscar";
            this.btnBuscar.Size = new System.Drawing.Size(536, 62);
            this.btnBuscar.TabIndex = 2;
            this.btnBuscar.Text = "Buscar";
            this.btnBuscar.UseVisualStyleBackColor = true;
            this.btnBuscar.Click += new System.EventHandler(this.btnBuscar_Click);
            // 
            // gdvSigua
            // 
            this.gdvSigua.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.gdvSigua.Location = new System.Drawing.Point(14, 287);
            this.gdvSigua.Name = "gdvSigua";
            this.gdvSigua.RowHeadersWidth = 72;
            this.gdvSigua.RowTemplate.Height = 31;
            this.gdvSigua.Size = new System.Drawing.Size(1184, 287);
            this.gdvSigua.TabIndex = 3;
            this.gdvSigua.CellContentClick += new System.Windows.Forms.DataGridViewCellEventHandler(this.gdvSigua_CellContentClick);
            // 
            // lblParam
            // 
            this.lblParam.AutoSize = true;
            this.lblParam.Location = new System.Drawing.Point(615, 11);
            this.lblParam.Name = "lblParam";
            this.lblParam.Size = new System.Drawing.Size(237, 25);
            this.lblParam.TabIndex = 4;
            this.lblParam.Text = "Parámetros de búsqueda:";
            this.lblParam.Click += new System.EventHandler(this.lblParam_Click);
            // 
            // lblOpciones
            // 
            this.lblOpciones.AutoSize = true;
            this.lblOpciones.Location = new System.Drawing.Point(9, 11);
            this.lblOpciones.Name = "lblOpciones";
            this.lblOpciones.Size = new System.Drawing.Size(102, 25);
            this.lblOpciones.TabIndex = 5;
            this.lblOpciones.Text = "Opciones:";
            this.lblOpciones.Click += new System.EventHandler(this.lblOpciones_Click);
            // 
            // pnlApp
            // 
            this.pnlApp.Controls.Add(this.listNombres);
            this.pnlApp.Controls.Add(this.label1);
            this.pnlApp.Controls.Add(this.lblP1);
            this.pnlApp.Controls.Add(this.ddlOpciones);
            this.pnlApp.Controls.Add(this.lblOpciones);
            this.pnlApp.Controls.Add(this.btnBuscar);
            this.pnlApp.Controls.Add(this.gdvSigua);
            this.pnlApp.Controls.Add(this.tbParam);
            this.pnlApp.Controls.Add(this.lblParam);
            this.pnlApp.Location = new System.Drawing.Point(12, 12);
            this.pnlApp.Name = "pnlApp";
            this.pnlApp.Size = new System.Drawing.Size(1211, 587);
            this.pnlApp.TabIndex = 6;
            // 
            // listNombres
            // 
            this.listNombres.FormattingEnabled = true;
            this.listNombres.ItemHeight = 24;
            this.listNombres.Location = new System.Drawing.Point(620, 138);
            this.listNombres.Name = "listNombres";
            this.listNombres.Size = new System.Drawing.Size(578, 124);
            this.listNombres.TabIndex = 8;
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(615, 91);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(177, 25);
            this.label1.TabIndex = 7;
            this.label1.Text = "Listado de edificios";
            this.label1.Click += new System.EventHandler(this.label1_Click_1);
            // 
            // lblP1
            // 
            this.lblP1.AutoSize = true;
            this.lblP1.Location = new System.Drawing.Point(615, 48);
            this.lblP1.Name = "lblP1";
            this.lblP1.Size = new System.Drawing.Size(108, 25);
            this.lblP1.TabIndex = 6;
            this.lblP1.Text = "Parámetro:";
            this.lblP1.Click += new System.EventHandler(this.label1_Click);
            // 
            // App
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(11F, 24F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(1235, 609);
            this.Controls.Add(this.pnlApp);
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedSingle;
            this.Name = "App";
            this.Text = "Apicaller";
            ((System.ComponentModel.ISupportInitialize)(this.gdvSigua)).EndInit();
            this.pnlApp.ResumeLayout(false);
            this.pnlApp.PerformLayout();
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.ListBox ddlOpciones;
        private System.Windows.Forms.TextBox tbParam;
        private System.Windows.Forms.Button btnBuscar;
        private System.Windows.Forms.DataGridView gdvSigua;
        private System.Windows.Forms.Label lblParam;
        private System.Windows.Forms.Label lblOpciones;
        private System.ComponentModel.BackgroundWorker backgroundWorker1;
        private System.Windows.Forms.Panel pnlApp;
        private System.Windows.Forms.Label lblP1;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.ListBox listNombres;
    }
}

