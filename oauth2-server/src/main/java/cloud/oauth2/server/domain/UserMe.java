package cloud.oauth2.server.domain;

public class UserMe {
   private String  roles;
   private String  username;
   private String avatarUrl;
    public String getAvatarUrl() {
	return avatarUrl;
}
public void setAvatarUrl(String avatarUrl) {
	this.avatarUrl = avatarUrl;
}
//commit('SET_PICURL', data.user.picUrl)
    //commit('SET_INTRODUCTION', data.user.introduction)
   private String  permissions;
public String getRoles() {
	return roles;
}
public void setRoles(String roles) {
	this.roles = roles;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPermissions() {
	return permissions;
}
public void setPermissions(String permissions) {
	this.permissions = permissions;
}
}
