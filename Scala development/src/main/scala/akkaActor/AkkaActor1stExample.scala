package akkaActor

import akka.actor.typed.scaladsl.{ActorContext, Behaviors}
import akka.actor.typed.{ActorSystem, Behavior}
object AkkaActor1stExample {
  sealed trait Message

  final case object Hello extends Message

  final case object HowAreYou extends Message

  def actorBehavior(): Behavior[Message] = Behaviors.setup {
    context: ActorContext[Message] =>
      Behaviors.receiveMessage { message: Message =>
        message match {
          case Hello =>
            println("Hi, I’m Tom.")
            Behaviors.same
          case _ =>
            println("Hello Good, and you?");
            Behaviors.same
        }
      }
  }

  def main(args: Array[String]): Unit = {
    val actorSystem: ActorSystem[Message] = ActorSystem(actorBehavior(),
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
}
