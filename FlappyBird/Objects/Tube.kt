package FlappyBird.Objects


import java.awt.Image
import javax.swing.ImageIcon

class Tube {
    private var large:Int?=null
    private var height:Int?=null
    private var x:Int?=null
    private var y:Int?=null
    private var strImage:String?=null
    private var image: Image? = null

    constructor(x:Int,y:Int,strImage: String)
    {
        this.large=50
        this.height=300
        this.x=x
        this.y=y
        this.strImage=strImage

        val icoTube=ImageIcon(strImage)
        image=icoTube.image
    }



    //Setter
    fun setX(x:Int){this.x=x }
    fun setY(y:Int){this.y=y }

    //Getter
    fun getX(): Int? {return x }
    fun getY(): Int? {return y }
    fun getlarge():Int?{ return large }
    fun getheight():Int? {return height }
    fun getimage():Image? { return image }





}