package mx.edu.ittepic.tpdm_u1_practica2_15401020

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.GridLayout
import android.widget.LinearLayout
import androidx.core.view.isInvisible

class Main2Activity : AppCompatActivity() {

    var layoutRenglones:LinearLayout?=null
    var layoutColumnas:LinearLayout?=null
    var grid:GridLayout?=null
    var col:EditText?=null
    var ren:EditText?=null
    var valor:EditText?=null
    var capturar:Button?=null
    var regresar:Button?=null
    var archivar:Button?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        layoutRenglones = findViewById(R.id.CDlayoutRenglones)
        layoutColumnas = findViewById(R.id.CDlayoutColumnas)
        grid = findViewById(R.id.grid)
        col = findViewById(R.id.CDcolumnas)
        ren = findViewById(R.id.CDrenglones)
        valor = findViewById(R.id.CDvalor)
        capturar = findViewById(R.id.btnCapturar)
        regresar = findViewById(R.id.btnRegresar)
        archivar = findViewById(R.id.btnArchivar)

        var band = intent.extras?.getString("band")
        if(band?.equals("v")==true){
            layoutRenglones?.isInvisible=true

        }
        var celdillas = intent.extras?.getString("celdillas")
        var renglones = intent.extras?.getString("renglones")

        grid?.columnCount = celdillas.toString().toInt()
        grid?.rowCount = renglones.toString().toInt()

        regresar?.setOnClickListener {
            finish()
        }
        capturar?.setOnClickListener {
            var v = valor?.text.toString()

        }


    }
}
