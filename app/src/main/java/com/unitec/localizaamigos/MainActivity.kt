package com.unitec.localizaamigos

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Vibrator
import android.util.Log
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()    // Es para ocultar la barra superior en la aplicación
        // ("?" Si todavía no se carga, se espera hasta que el recurso exista, y cuando lo esté, se oculte)
        setContentView(R.layout.activity_main)
        //Vamos a activar el vibrador
        var v = getSystemService(VIBRATOR_SERVICE) as Vibrator
        //Invocamos el vibrador
        v.vibrate(3000)
        //Empezamos a programar para ver la forma de implementar los eventos de botón en android
        var botonEmpezar = findViewById<Button>(R.id.empezar)   //<Clase en la que pertenece>(R(res).id.nombre)
        //invocamos el boton localizar por su id, ahora con el plugin de extensiones
        localizar.setOnClickListener {
            startActivity(Intent(this,MapitaActivity::class.java))
        }


        //Manejamos el evento
        botonEmpezar.setOnClickListener{
            //Antes de la navegación hacia la activity registro a invocar a una componente que se llama
            //Toast: estos mensajes de corta duración que se muestran en la pantalla
            Toast.makeText(applicationContext," Vamos a registrarnos", Toast.LENGTH_SHORT).show()
            //El siguiente renglón nos lleva esta activity a la de registro:
            var intent = Intent(this, RegistroActivity::class.java)
            //La redireccionamos
            startActivity(intent)

        }
        //Declaración de una variable en kotlin
        var x = 4
        var y = "Hola mundo"
        /*En java "int x=4" y terminar en ";" o string "hola mundo"
        Lo siguiente tambien es correcto:
        var z:Int=5
        var w:String="Otro mensaje"
        Pero esto se utiliza más cuando declaras una variable que AÚN NO vas a darle algún valor hasta despues
        var a:Int
        En Kotlin ya no existen tipos de datos primitivos, son objetos*/

        //Vamos a imprimir el Logcat para ello usamos la clase Lase Log (i = info)
        Log.i("MALO", "Este es mi primer mensaje con etiqueta en info")
        //Vamos a concatenar una variable
        var mensajito = " vamos a concatenar"
        Log.i("MALO", "En kotlin" + mensajito + " mas fácil " + "que Java")
        //La versión de concatenado de Kotlin es mucho mejor
        Log.i("MALO", "En kotlin $mensajito mas fácil que Java")
        //Ademas la interpolación reloaded
        Log.i("MALO", "Vamos a interpolar una expresión ${5 + 3} que puede ser una operación")
        //En Kotlin las funciones son lo que en java los metodos y tienen mas poder
        //porque pueden anidarse y son tratados como OBJETOS (Programación funcional: Una función es
        // tratada como cualquier tipo de variable (OBJETO))
        //Es decir, una funcion puede devolver otra función.

        //Invocamos o mandamos a llamar a la función
        saludar()
        //Aquí estamos dentro del ambito de el metodo onCreate (es decir su cuerpo), aún así Kotlin
        //permite aquí dentro implementar una función , cosa que no es posible de Java
        fun mensajito() {
            Log.i("MALO", "Implementando una función dentro de otra")
        }
        //Aquí invocamos la función anterior
        mensajito()

        //Funciones con tipo de retorno
        fun sumar(): Int {
            var x = 5 + 4
            return x
        }
        //La invocamos
        Log.i("MALO","Invocamos la función ${sumar()} con el interpolador de expresiones")

        //Otra modalidad de una función es la siguiente que recibe argumentos
        fun saludar2(mensaje:String){
            Log.i("MALO", mensaje)
        }
        //La invocamos
        saludar2("Este mensaje es el argumento de la función")
        //Otro ejemplo más
        //Kotlin es un lenguaje OO, funcional y reactivo
        fun saludar2(nombre:String, edad:Int){
            Log.i("MALO","Tu nombre es: $nombre y tu edad es: $edad")

        }
        //Invocamos la función anterior
        saludar2("Erick Jair", 47)

    }

    //Aquí declaramos una función
    fun saludar() {
        Log.i("MALO", "Implementando mi primer función en Kotlin")
    }

}