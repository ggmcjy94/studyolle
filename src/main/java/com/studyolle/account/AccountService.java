package com.studyolle.account;

import com.studyolle.domain.Account;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;
    private final JavaMailSender javaMailSender;
    private final PasswordEncoder passwordEncoder;

    @Transactional // 트랜잭션 persist 상태를 유지 하기위해
    public Account processNewAccount(SignUpForm signUpForm) { //리팩토링
        Account newAccount = saveNewAccount(signUpForm); //detached 왜냐 트랜잭션 을 벗어났기 때문에
        newAccount.generateEmailCheckToken();
        sendSignUpConfirmEmail(newAccount);
        return newAccount;
    }


    private Account saveNewAccount(SignUpForm signUpForm) {
        // TODO 회원 가입 처리
        Account account = Account.builder()
                .email(signUpForm.getEmail())
                .nickname(signUpForm.getNickname())
                .password(passwordEncoder.encode(signUpForm.getPassword()))
                .emailVerified(false)
                .studyCreatedByWeb(true)
                .studyEnrollmentResultByWeb(true)
                .studyUpdatedByWeb(true)
                .build();
        Account newAccount = accountRepository.save(account);
        return newAccount;
    }

    private void sendSignUpConfirmEmail(Account newAccount) {
        // TODO email 전송
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(newAccount.getEmail());
        mailMessage.setSubject("스터디 올래, 회원 가입 인증");
        mailMessage.setText("/check-email-token?token="+ newAccount.getEmailCheckToken() + "&email=" + newAccount.getEmail());
        javaMailSender.send(mailMessage);
    }


    public void login(Account account) {
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(
                account.getNickname(),
                account.getPassword(),
                List.of(new SimpleGrantedAuthority("ROLE_USER")));
        //정석 적으로 인증 하는 방법 아님
        SecurityContextHolder.getContext().setAuthentication(token);

//        //정석
//        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(
//                username, password);
//        Authentication authentication = authenticationManager.authenticate(token);
//        context.setAuthentication(authentication);
    }
}
