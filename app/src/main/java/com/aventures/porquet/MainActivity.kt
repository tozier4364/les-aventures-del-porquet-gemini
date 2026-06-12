package com.aventures.porquet

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Buscamos el botón "Entrar" de tu diseño activity_main.xml
        val btnEntrar = findViewById<Button>(R.id.btnEntrar)

        // Al pulsar el botón, viaja directamente al Menú Principal
        btnEntrar.setOnClickListener {
            val intent = Intent(this, MenuPrincipalActivity::class.java)
            intent.putExtra("idioma", "CAT") // Le pasamos el idioma por defecto
            startActivity(intent)
        }
    }
}
