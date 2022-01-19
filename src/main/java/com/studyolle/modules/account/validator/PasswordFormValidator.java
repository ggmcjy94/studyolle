package com.studyolle.modules.account.validator;


import com.studyolle.modules.account.form.PasswordForm;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

//빈으로 등록을 할필요가없다 왜냐 다른 빈을 사용을 안할거기 떄문에 까먹으면 PasswordFormValidator 와 NicknameValidator 를 유심히 볼것
public class PasswordFormValidator implements Validator {
    

    @Override
    public boolean supports(Class<?> clazz) {
        return PasswordForm.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        PasswordForm passwordForm = (PasswordForm) target;
        if (!passwordForm.getNewPassword().equals(passwordForm.getNewPasswordConfirm())) {
            errors.rejectValue("newPassword", "wrong.value", "입력한 새 패스워드가 일치 하지 않습니다.");
        }

    }
}
