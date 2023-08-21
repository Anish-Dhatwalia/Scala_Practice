package akkaActor

import akka.actor.typed.Behavior
import akka.actor.typed.scaladsl.{ActorContext, Behaviors}

object Tom {
  // the “messages” this actor can respond to
  sealed trait Message

  final case object Hello extends Message
  final case object HowAreYou extends Message
  // the factory method
  def apply(): Behavior[Message] = Behaviors.setup {
    context: ActorContext[Message] =>
      Behaviors.receiveMessage { message: Message =>
        message match {
          case Hello =>
            println("Hi, I’m Tom.")
            Behaviors.same
          case _=>
              println("Hello Good, and you?");
              Behaviors.same
        }
      }
  }
}