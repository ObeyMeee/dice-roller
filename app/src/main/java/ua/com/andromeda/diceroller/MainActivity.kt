package ua.com.andromeda.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rollButton = findViewById<Button>(R.id.button)
        rollButton.setOnClickListener { rollDice() }

//        Random dice roll when app starts
        rollDice()
    }

    /**
     * Roll dice and update the screen with result
     * */
    private fun rollDice() {
        // Create new Dice object with 6 sides and roll the dice
        val roll = Dice(6).roll()
        val imageResource = getResource(roll)

        // Find the ImageView in the layout
        val imageDiceView = findViewById<ImageView>(R.id.imageView)

        // Update the ImageView with correct  drawable resource id
        imageDiceView.setImageResource(imageResource)

        // Update content description
        imageDiceView.contentDescription = roll.toString()
    }

    private fun getResource(roll: Int) =
        when (roll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
}

class Dice(private val sidesNumber: Int) {
    fun roll() = (1..sidesNumber).random()
}