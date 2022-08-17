import com.raquo.laminar.api.L._
import org.scalajs.dom

import be.doeraene.webcomponents.ui5.*

import be.doeraene.webcomponents.ui5.configkeys.*

object Frontend {

  val myApp = {

    val $tick = EventStream.periodic(1000)

    div(
      Input(
        _.required := true,
        _.valueState := ValueState.Information,
        _.placeholder := "Enter your name",
        _ => onChange.mapToValue --> Observer(println)
      )
    )
  }

  def main(args: Array[String]): Unit = {
    documentEvents.onDomContentLoaded.foreach { _ =>
      render(dom.document.getElementById("appContainer"), myApp)
    }(unsafeWindowOwner)
  }
}
