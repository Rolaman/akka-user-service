package rolaman.auth

import rolaman.db.DbConnection

private[auth] trait AuthDataTable {

  protected val dbConnection: DbConnection
  import dbConnection.profile.api._

  class AuthDataSchema(tag: Tag) extends Table[AuthData](tag, "auth") {
    def id       = column[Long]("id", O.AutoInc, O.PrimaryKey)
    def username = column[String]("username")
    def email    = column[String]("email")
    def password = column[String]("password")

    def * = (id, username, email, password) <> (AuthData.tupled, AuthData.unapply)
  }

  protected val auth = TableQuery[AuthDataSchema]

}
