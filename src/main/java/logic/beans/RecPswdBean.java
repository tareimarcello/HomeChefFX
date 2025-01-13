package logic.beans;

import logic.homechefutil.HomeChefUtil;

public class RecPswdBean {
    private String email;

    public RecPswdBean(String email) {
        this.email=email;
    }

    public String getEmail() {
        return email;
    }

    public boolean setEmail(String email) {
        if(email.isEmpty() || !HomeChefUtil.isValidEmail(email)){
            return false;
        }
        this.email = email;
        return true;
    }
}
