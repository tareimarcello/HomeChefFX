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

    public String selectAllUserQuery(){
        return "SELECT * FROM user";
    }

    public String updateQuery(String email, String password, long id){
        return String.format("UPDATE user SET email = '%s', password = '%s' WHERE iduser = %d", email, password, id);
    }

    public String deleteQuery(long id){
        return String.format("DELETE FROM user WHERE iduser = %d", id);
    }

    public String insertQuery(String name, String surname, String email, String password, long id){
        return String.format(" INSERT INTO user VALUES(%d,'%s','%s','%s','%s')");
    }
}
