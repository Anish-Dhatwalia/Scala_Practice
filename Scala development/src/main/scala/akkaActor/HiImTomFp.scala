package akkaActor

import akka.actor.typed.{ActorSystem, Behavior}
import akka.actor.typed.scaladsl.{ActorContext, Behaviors}
object HiImTomFp extends App{

  import akkaActor.Tom.{Hello, Message,HowAreYou}
  val actorSystem: ActorSystem[Message] = ActorSystem(
    Tom(),
    "50FirstDatesSystem"
  )
  println(actorSystem);
  actorSystem ! HowAreYou
  actorSystem ! Hello
  actorSystem ! Hello
  Thread.sleep(500)
  actorSystem.terminate()
  println(actorSystem)
}