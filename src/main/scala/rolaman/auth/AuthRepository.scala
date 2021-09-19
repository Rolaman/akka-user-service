package rolaman.auth

import rolaman.db.DbConnection

import scala.concurrent._

sealed trait AuthRepository {

  def find(login: String): Future[Option[AuthData]]

  def save(authData: AuthData): Future[AuthData]

}

class PostgresAuthRepository(
                              val dbConnection: DbConnection
                            )(implicit executionContext: ExecutionContext)
  extends AuthDataTable
    with AuthRepository {

  import dbConnection._
  import dbConnection.profile.api._

  override def find(login: String): Future[Option[AuthData]] =
    db.run(auth.filter(d => d.username === login || d.email === login).result.headOption)


  override def save(authData: AuthData): Future[AuthData] =
    db.run(auth.insertOrUpdate(authData)).map(_ => authData)

}