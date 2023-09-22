package FlappyBird.Game


import FlappyBird.Objects.Tube
import FlappyBird.character.FlappyBird
import java.awt.Font
import java.awt.Graphics
import java.awt.Image
import java.awt.event.ActionEvent
import java.awt.event.ActionListener

import javax.swing.ImageIcon
import javax.swing.JPanel
import javax.swing.Timer
import kotlin.random.Random


public class Scene :JPanel(),Runnable {

    private var image: Image? = null


    private val larger = 140
    private val Distance_TubeX = 250
    private val Gap_TubeX = 120
    private val pause = 5

    var xfond: Int
    var endofgame:Boolean=false
    var Score:Int
    val small = Font("Arial", Font.PLAIN, 40)





    private var xTubex: Int=400


    var Tubehigh1 = Tube(this.xTubex, -150, "src/drawable/tuyauHaut.png")
    var TubeDown1 = Tube(this.xTubex, 250, "src/drawable/tuyauBas.png")
    var Tubehigh2 = Tube(this.xTubex + this.Distance_TubeX, -100, "src/drawable/tuyauHaut.png")
    var TubeDown2 = Tube(this.xTubex + this.Distance_TubeX, 300, "src/drawable/tuyauBas.png")
    var Tubehigh3 = Tube(this.xTubex + this.Distance_TubeX * 2, -120, "src/drawable/tuyauHaut.png")
    var TubeDown3 = Tube(this.xTubex + this.Distance_TubeX * 2, 280, "src/drawable/tuyauBas.png")
    var flappybird = FlappyBird(100, 150, "src/drawable/oiseau1.png")
    var chance = Random


    init {
        val iia = ImageIcon("src/drawable/bandeFondEcran.png")
        image = iia.image
        xfond = 0
        Score=0

        isFocusable = true


        requestFocusInWindow()
        addKeyListener(flappybird)

        var thread=Thread(this)
        thread.start()
    }



    private fun background_displacement(g: Graphics) {
        if (xfond == -larger) xfond = 0
        g.drawImage(this.image, this.xfond, 0, null)
        g.drawImage(this.image, this.xfond + this.larger, 0, null)
        g.drawImage(this.image, this.xfond + this.larger * 2, 0, null)
        g.drawImage(this.image, this.xfond + this.larger * 3, 0, null)
    }

    private fun Tube_displacement(g: Graphics) {
        //Tube1

        Tubehigh1.setX(Tubehigh1.getX()!! - 1)
        TubeDown1.setX(Tubehigh1.getX()!!)

        if (Tubehigh1.getX() == -100) {
            Tubehigh1.setX(Tubehigh3.getX()!! + Distance_TubeX)
            Tubehigh1.setY(-100 - 10 * chance.nextInt(18))
            TubeDown1.setY(Tubehigh1.getY()!! + Tubehigh1.getheight()!! + Gap_TubeX)
        }
        g.drawImage(Tubehigh1.getimage(), Tubehigh1.getX()!!, Tubehigh1.getY()!!, null)
        g.drawImage(TubeDown1.getimage(), TubeDown1.getX()!!, TubeDown1.getY()!!, null)

        //Tube2
        Tubehigh2.setX(Tubehigh2.getX()!! - 1)
        TubeDown2.setX(Tubehigh2.getX()!!)
        if (Tubehigh2.getX() == -100) {
            Tubehigh2.setX(Tubehigh1.getX()!! + Distance_TubeX)
            Tubehigh2.setY(-100 - 10 * chance.nextInt(18))
            TubeDown2.setY(Tubehigh2.getY()!! + Tubehigh2.getheight()!! + Gap_TubeX)
        }
        g.drawImage(Tubehigh2.getimage(), Tubehigh2.getX()!!, Tubehigh2.getY()!!, null)
        g.drawImage(TubeDown2.getimage(), TubeDown2.getX()!!, TubeDown2.getY()!!, null)

        //Tube3
        Tubehigh3.setX(Tubehigh3.getX()!! - 1)
        TubeDown3.setX(Tubehigh3.getX()!!)
        if (Tubehigh3.getX() == -100) {
            Tubehigh3.setX(Tubehigh2.getX()!! + Distance_TubeX)
            Tubehigh3.setY(-100 - 10 * chance.nextInt(18))
            TubeDown3.setY(Tubehigh3.getY()!! + Tubehigh3.getheight()!! + Gap_TubeX)
        }
        g.drawImage(Tubehigh3.getimage(), Tubehigh3.getX()!!, Tubehigh3.getY()!!, null)
        g.drawImage(TubeDown3.getimage(), TubeDown3.getX()!!, TubeDown3.getY()!!, null)

    }

    private fun collisionFlappy(): Boolean {

        var end_of_Game = false
        // near Tube1
        if (this.flappybird.getX()!! + this.flappybird.getlarge()!! > this.TubeDown1.getX()!! - 20 &&
            this.flappybird.getX()!! < this.TubeDown1.getX()!! + this.TubeDown1.getlarge()!! + 20
        ) {
            end_of_Game = this.flappybird.collision(this.TubeDown1)
            if (end_of_Game == false) {
                end_of_Game = this.flappybird.collision(this.Tubehigh1)
            }
        } else {
            // near Tube2
            if (this.flappybird.getX()!! + this.flappybird.getlarge()!! > this.TubeDown2.getX()!! - 20 && this.flappybird.getX()!! < this.TubeDown2.getX() !!+ this.TubeDown2.getlarge()!! + 20) {
                end_of_Game = this.flappybird.collision(this.TubeDown2)
                if (end_of_Game == false) {
                    end_of_Game = this.flappybird.collision(this.Tubehigh2)
                }
            } else {
                // near Tube3
                if (this.flappybird.getX()!! + this.flappybird.getlarge()!! > this.TubeDown3.getX()!! - 20 && this.flappybird.getX()!! < this.TubeDown3.getX() !!+ this.TubeDown3.getlarge()!! + 20) {
                    end_of_Game = this.flappybird.collision(this.TubeDown3)
                    if (end_of_Game == false) {
                        end_of_Game = this.flappybird.collision(this.Tubehigh3)
                    }
                } else {
                    // contact with the ceiling or floor
                        if (this.flappybird.getY()!! < 0 || this.flappybird.getY()!! + this.flappybird.getheight()!! > 355)
                            end_of_Game=true
                        else
                            end_of_Game=false

                }
            }
        }

        return end_of_Game
    }

    private fun Score()
    {
        if(this.TubeDown1.getX()!!+ this.TubeDown1.getlarge()!! ==95 || this.TubeDown2.getX()!!+this.TubeDown2.getlarge()!! ==95 || this.TubeDown3.getX()!!+this.TubeDown3.getlarge()!! ==95 )
            this.Score++
       // Audio().playSound("/audio/flappybirdsong.mp3")

    }

    public override fun paintComponent(g: Graphics) {
        background_displacement(g)
        Tube_displacement(g)
        this.endofgame=this.collisionFlappy()
        this.flappybird.setY(this.flappybird.getY()!! + 1)
        this.Score()
        g.font=small
        g.drawString(""+Score,140,50)
        if(this.endofgame==true)g.drawString("Game Over",60,200)
        g.drawImage(flappybird.getimage(), flappybird.getX()!!, flappybird.getY()!!, null)



    }


    override fun run() {
        while(endofgame==false)
        {
            xfond--
            repaint()
            Thread.sleep(pause.toLong())
        }
    }


}

