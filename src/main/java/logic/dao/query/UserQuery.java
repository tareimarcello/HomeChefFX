package logic.dao.query;

public class UserQuery {

    public String selectUserByEmailQuery(String email){
        return String.format("SELECT * FROM user WHERE email = '%s'", email);
    }

    public String selectUserById(long id){
        return String.format("SELECT * FROM user WHERE iduser = %d", id);
    }

    public String updatePswdById(String pswd, long id){
        return String.format("UPDATE user SET password = '%s' WHERE iduser = %d", pswd,id);
    }

    public String updateEmailByIdQuery(String email, long id){
        return String.format("UPDATE user SET email = '%s' WHERE iduser = %d", email,id);
    }

    public String selectListMailQuery(){
        return "SELECT email FROM user";
    }

    public String selectPswdQuery(long id){
        return String.format("SELECT password FROM user WHERE iduser = %d",id);
    }

    public String selectUsersByMailAndPswd(String email, String pswd){
        return String.format("SELECT * FROM user WHERE email = '%s' AND password='%s'", email,pswd);
    }
}
