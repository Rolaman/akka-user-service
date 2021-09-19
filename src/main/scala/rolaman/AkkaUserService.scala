package rolaman

import akka.actor.ActorSystem

import java.util.concurrent.Executors
import scala.concurrent.ExecutionContext

object AkkaUserService extends App {

  implicit val actorSystem: ActorSystem = ActorSystem("akka-user-service")
  implicit val executor: ExecutionContext = ExecutionContext.fromExecutor(
    Executors.newFixedThreadPool(5))



}
