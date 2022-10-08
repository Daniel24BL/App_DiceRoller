package com.dbaque.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

/**
 * Esta actividad permite al usuario tirar un dado y ver el resultado en la pantalla.
 */

class MainActivity : AppCompatActivity() {

    /**
     * Este método se llama cuando se crea la actividad.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Encuentra el botón en el diseño
        val rollButton: Button = findViewById(R.id.button)

        //Configure un oyente de clics en el botón para tirar los dados cuando
        // el usuario toca el botón
        rollButton.setOnClickListener { rollDice() }

        // Haz una tirada de dados cuando se inicie la aplicación
        rollDice()
    }

    /**
     * Tira los dados y actualiza la pantalla con el resultado.
     */
    private fun rollDice() {
        // Crea un nuevo objeto Dado con 6 lados y los tírá.
        val dice = Dice(6)
        val diceRoll = dice.roll()

        //Actualiza la pantalla con la tirada de dados.
        val diceImage: ImageView = findViewById(R.id.imageView)

        //Determine qué ID de recurso extraíble usar en función de la tirada de dados
        val drawableResource = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        //Actualice ImageView con el ID de recurso dibujable correcto
        diceImage.setImageResource(drawableResource)

        //Actualizar la descripción del contenido
        diceImage.contentDescription = diceRoll.toString()
    }
}

/**
 * Dados con un número fijo de lados.
 */
class Dice(private val numSides: Int) {

    /**
     * Haz una tirada de dados al azar y devuelve el resultado.
     */
    fun roll(): Int {
        return (1..numSides).random()
    }
}
