package com.example.mywebapp.weather.forms;

public class ChangePasswordForm {

    private String oldPassword;
    private String newPassword;
    private String newPasswordAgain;

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public void setNewPasswordAgain(String newPasswordAgain) {
        this.newPasswordAgain = newPasswordAgain;
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public String getNewPasswordAgain() {
        return newPasswordAgain;
    }


}
