package com.aventures.porquet

import android.os.Bundle
import android.view.View
import android.view.animation.OvershootInterpolator
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MenuPrincipalActivity : AppCompatActivity() {

    private var idioma: String = "CAT" // Por defecto

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_principal)

        // 1. Recuperar idioma del Intent
        idioma = intent.getStringExtra("idioma") ?: "CAT"

        // 2. Referencias de UI
        val tvTitle = findViewById<TextView>(R.id.tvMenuTitle)
        val btnAprender = findViewById<Button>(R.id.btnAprender)
        val btnJugar = findViewById<Button>(R.id.btnJugar)

        // 3. Adaptar textos según idioma
        if (idioma == "ESP") {
            tvTitle.text = "¿Qué quieres hacer?"
            btnAprender.text = "Aprende"
            btnJugar.text = "Juega"
        } else {
            tvTitle.text = "Què vols fer?"
            btnAprender.text = "Aprèn"
            btnJugar.text = "Juga"
        }

        // 4. Configurar clics con animación pop
        btnAprender.setOnClickListener { ejecutarAccionConAnimacion(it) { irASeccionAprender() } }
        btnJugar.setOnClickListener { ejecutarAccionConAnimacion(it) { irASeccionJugar() } }
    }

    private fun ejecutarAccionConAnimacion(vista: View, accion: () -> Unit) {
        vista.animate()
            .scaleX(1.1f)
            .scaleY(1.1f)
            .setDuration(100)
            .setInterpolator(OvershootInterpolator())
            .withEndAction {
                vista.animate().scaleX(1f).scaleY(1f).setDuration(100).start()
                accion()
            }
            .start()
    }

    private fun irASeccionAprender() {
        /* 
           RECORDATORIO ESTRATÉGICO: 
           Esta sección cargará el Mapa de Geografía.
           Eje central: Barcelona Capital.
           Rutas salientes hacia: Parets del Vallès, Valls y Claravalls.
        */
        Toast.makeText(this, "Carregant Mapa de Catalunya...", Toast.LENGTH_SHORT).show()
        // Aquí lanzarás el Intent para la MapaActivity
    }

    private fun irASeccionJugar() {
        Toast.makeText(this, "Secció de Jocs aviat!", Toast.LENGTH_SHORT).show()
        // Aquí lanzarás el Intent para la JuegosActivity
    }
}