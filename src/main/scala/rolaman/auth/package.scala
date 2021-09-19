package rolaman

package object auth {

  type UserId = Long
  type AuthToken = String

  final case class AuthTokenContent(userId: UserId)

  final case class AuthData(id: UserId, username: String, email: String, password: String) {
    require(username.nonEmpty, "username.empty")
    require(password.nonEmpty, "password.empty")
  }

  final case class UserProfile(id: UserId, name: String) {
    require(name.nonEmpty, "name.empty")
  }

  final case class UserProfileUpdate(name: Option[String] = None) {
    def merge(profile: UserProfile): UserProfile =
      UserProfile(profile.id, name.getOrElse(profile.name))
  }
}
