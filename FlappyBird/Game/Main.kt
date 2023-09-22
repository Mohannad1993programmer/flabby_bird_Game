package FlappyBird.Game

import javax.swing.JFrame

class play() :JFrame() {

    init {
        GreateGUI()
    }

    private fun GreateGUI() {

        add(Scene())
        defaultCloseOperation=JFrame.EXIT_ON_CLOSE
        setSize(600,425)
        setLocationRelativeTo(null)
        isAlwaysOnTop=true
        isResizable=false
        isVisible=true
        title="Flappy Bird"
    }


}

    fun main() {

        play()
    }









