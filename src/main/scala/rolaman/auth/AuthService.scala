package rolaman.auth

import com.roundeights.hasher.Implicits._
import io.circe.generic.auto._
import io.circe.syntax._
import pdi.jwt._

import scala.concurrent._

class AuthService(authRepository: AuthRepository,
                  secretKey: String)(implicit executionContext: ExecutionContext) {

  def signIn(login: String, password: String): Future[Option[AuthToken]] =
    authRepository
      .find(login)
      .map {
        case Some(data) if data.password == password.sha256.hex =>
          Some(encodeToken(data.id))
        case _ =>
          None
      }

  def signUp(login: String, email: String, password: String): Future[AuthToken] =
    authRepository
      .save(AuthData(null, login, email, password.sha256.hex))
      .map(authData => encodeToken(authData.id))

  private def encodeToken(userId: UserId): AuthToken =
    Jwt.encode(AuthTokenContent(userId)
      .asJson.noSpaces, secretKey, JwtAlgorithm.HS256)


}
