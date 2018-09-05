
package projecteulerscala


import java.awt.event.{ActionEvent, ActionListener}
import swing.{Panel, MainFrame, SimpleSwingApplication}
import javax.swing.Timer
import java.awt.{Font, Color, Graphics2D, Dimension}
import java.awt.image.BufferedImage
import util.Random

object ImageNoise2 extends SimpleSwingApplication {
  var delay_ms = 2
  var framecount = 0
  var fps = 0
  val buffer = new BufferedImage(320, 100, BufferedImage.TYPE_BYTE_BINARY)

  def top = new MainFrame {
    contents = panel
//    resizable = false
  }

  val panel = new Panel {
    preferredSize = new Dimension(320, 240)

    override def paintComponent(g: Graphics2D) {
      drawSnow()
      g.drawImage(buffer, 0, 0, null)
      g.setColor(Color.RED)
      g.setFont(new Font("Monospaced", Font.BOLD, 20))
      g.drawString("FPS: " + fps, size.width - 100, size.height - 10)

      framecount += 1
    }
  }

  def drawSnow() {
    val wr = buffer.getRaster
    val rand = new Random
    val (w,h) = (buffer.getWidth, buffer.getHeight)
    for (x <- 0 until w; y <- 0 until h) {
      wr.setSample(x, y, 0, (rand.nextFloat + 0.5).toInt)
    }
  }
  
  val repainter = new Timer(delay_ms, new ActionListener {
    def actionPerformed(e: ActionEvent) {
      panel.repaint
    }
  })

  val frameratechecker = new Timer(1000, new ActionListener {
    def actionPerformed(e: ActionEvent) {
      fps = framecount
      framecount = 0
    }
  })

  repainter.start()
  frameratechecker.start()
}