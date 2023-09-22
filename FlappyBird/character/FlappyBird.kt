package FlappyBird.character

import FlappyBird.Objects.Tube
import java.awt.Image
import java.awt.event.KeyEvent
import java.awt.event.KeyListener
import javax.swing.ImageIcon

class FlappyBird:KeyListener,Runnable {

    private var large: Int? = null
    private var height: Int? = null
    private var x: Int? = null
    private var y: Int? = null
    private var dy:Int = 0
    private var strImage: String? = null
    private var imageBird: Image? = null
    private var icoBird: ImageIcon? = null
    private val pause = 10



    constructor(x: Int, y: Int, strImage: String) {

        this.large = 34
        this.height = 24
        this.x = x
        this.y = y
        this.strImage = strImage

        this.icoBird = ImageIcon(strImage)
        this.imageBird = this.icoBird!!.image

        var stopwatchallies=Thread(this)
        stopwatchallies.start()



    }


    //Setter
    fun setX(x: Int) {
        this.x = x
    }

    fun setY(y: Int) {
        this.y = y
    }

    //Getter
    fun getX(): Int? {
        return x
    }

    fun getY(): Int? {
        return y
    }

    fun getlarge(): Int? {
        return large
    }

    fun getheight(): Int? {
        return height
    }

    fun getimage(): Image? {
        return imageBird
    }


    fun monte(){
        this.dy=40

    }


    private fun beatsAlies(dy:Int)
    {
        if(dy>10)
        {

            this.icoBird = ImageIcon("src/drawable/oiseau2.png")
            this.imageBird = this.icoBird!!.image
            this.y=this.y!!-3
        }
        else if(dy>5)this.y=this.y!!-2
        else if(dy>1) this.y=this.y!!-1
        else if(dy==1)
        {
            this.icoBird = ImageIcon("src/drawable/oiseau1.png")
            this.imageBird = this.icoBird!!.image
        }
    }


    fun collision(tube: Tube):Boolean
    {
        if(tube.getY()!!<50) {
            if (this.y!! <= tube.getY()!! + tube.getheight()!! && this.x!! + this.large!! >= tube.getX()!! &&
                this.x!! <= tube.getX()!! + tube.getlarge()!!
            ) return true
            else return false
        }else
            if(this.y!!+this.height!!>=tube.getY()!! && this.x!!+this.large!!>=tube.getX()!! &&
            this.x!!<=tube.getX()!!+tube.getlarge()!!) return true
        else return false
    }





    override fun keyPressed(e: KeyEvent?) {
        if (e!!.keyCode == KeyEvent.VK_SPACE) {
            monte()


        }

    }

    override fun keyReleased(e: KeyEvent?) {


    }

    override fun keyTyped(e: KeyEvent?) {
    }

    override fun run() {
        while (true) {
            this.beatsAlies(dy!!)
            this.dy--
            Thread.sleep(pause.toLong())
        }
    }


}