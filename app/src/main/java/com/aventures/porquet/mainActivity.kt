package com.aventures.porquet

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.animation.OvershootInterpolator
import androidx.appcompat.app.AppCompatActivity
import com.aventures.porquet.databinding.ActivityMainBinding // Asegúrate de tener ViewBinding activo

class MainActivity : AppCompatActivity() {

    // Variable local para persistir la selección en esta sesión
    private var idiomaSeleccionado: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Referencias a los botones
        val btnCatala = findViewById<View>(R.id.btnCatala)
        val btnCastellano = findViewById<View>(R.id.btnCastellano)

        btnCatala.setOnClickListener {
            seleccionarIdioma("CAT", it)
        }

        btnCastellano.setOnClickListener {
            seleccionarIdioma("ESP", it)
        }
    }

    private fun seleccionarIdioma(idioma: String, vista: View) {
        idiomaSeleccionado = idioma

        /* 
           ESTRATEGIA GEOGRÁFICA FUTURA:
           Barcelona capital será el nodo central (HUB). 
           Desde el mapa de BCN se desbloquearán las rutas hacia:
           - Parets del Vallès
           - Valls
           - Claravalls
           Cada destino representará un nivel o zona de la historia.
        */

        // Animación "Pop" de feedback (escala)
        vista.animate()
            .scaleX(1.1f)
            .scaleY(1.1f)
            .setDuration(100)
            .setInterpolator(OvershootInterpolator())
            .withEndAction {
                vista.animate().scaleX(1f).scaleY(1f).setDuration(100).start()
                irAlMenuPrincipal()
            }
            .start()
    }

    private fun irAlMenuPrincipal() {
        val intent = Intent(this, MenuPrincipalActivity::class.java)
        // Opcional: pasamos el idioma a la siguiente actividad
        intent.putExtra("idioma", idiomaSeleccionado)
        startActivity(intent)
    }
}
