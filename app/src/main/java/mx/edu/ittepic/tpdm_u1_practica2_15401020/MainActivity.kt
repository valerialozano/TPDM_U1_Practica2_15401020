package mx.edu.ittepic.tpdm_u1_practica2_15401020

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.core.view.isInvisible

class MainActivity : AppCompatActivity() {

    var rbVector:RadioButton?=null
    var rbMatriz:RadioButton?=null
    var etRenglones:EditText?=null
    var etCeldillas:EditText?=null
    var layoutRenglones:LinearLayout?=null
    var listVOpciones:ListView?=null

    var band=""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rbVector = findViewById(R.id.vector)
        rbMatriz = findViewById(R.id.matriz)
        layoutRenglones = findViewById(R.id.layoutRenglones)
        listVOpciones = findViewById(R.id.lvOpciones)
        etRenglones = findViewById(R.id.renglones)
        etCeldillas = findViewById(R.id.celdillas)


        rbMatriz?.setOnClickListener {
            layoutRenglones?.isInvisible=false
        }
        rbVector?.setOnClickListener{
            layoutRenglones?.isInvisible=true
        }
        listVOpciones?.setOnItemClickListener { parent, view, position, id ->
            when(position){
                0 -> abrirCapturarDatos()
                1 -> abrirMostrarDatos()
                2 -> abrirAcercaDe()
                3 -> finish()
            }
        }
    }
    fun abrirCapturarDatos(){
        if(rbVector?.isChecked==true) {
            if (etCeldillas?.text.toString().isEmpty() == true) {
                val alerta = AlertDialog.Builder(this)
                alerta.setTitle("¡ERROR!").setMessage("Indica la cantidad de celdillas.").show()
                return
            }
            band="v"
            var r = 1
            var act = Intent(this,Main2Activity::class.java)
            act.putExtra("band",band)
            act.putExtra("celdillas",etCeldillas?.text.toString())
            act.putExtra("renglones",r.toString())

            startActivity(act)
        }
        if(rbMatriz?.isChecked==true){
            if (etCeldillas?.text.toString().isEmpty() == true) {
                val alerta = AlertDialog.Builder(this)
                alerta.setTitle("¡ERROR!").setMessage("Indica la cantidad de celdillas.").show()
                return
            }
            if(etRenglones?.text.toString().isEmpty()==true){
                val alerta = AlertDialog.Builder(this)
                alerta.setTitle("¡ERROR!").setMessage("Indica la cantidad de renglones.").show()
                return
            }
            band="m"
            var act = Intent(this,Main2Activity::class.java)
            act.putExtra("band",band)
            act.putExtra("celdillas",etCeldillas?.text.toString())
            act.putExtra("renglones",etRenglones?.text.toString())
            startActivity(act)
        }
    }
    fun abrirAcercaDe(){
        val alerta = AlertDialog.Builder(this)
        alerta.setTitle("Acerca de...").setMessage("Valeria Carolina López Lozano").setPositiveButton("Aceptar"){dialog, which-> }.setNegativeButton("Cancelar"){dialog,which->}.show()
    }
    fun abrirMostrarDatos(){
        var act = Intent(this,Main3Activity::class.java)
        startActivity(act)
    }
}
