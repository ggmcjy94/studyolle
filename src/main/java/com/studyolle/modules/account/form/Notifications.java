package com.studyolle.modules.account.form;

import lombok.Data;

@Data
//생성자가 있을때 기본 생성자가 있어야됌 바인딩 할때 널포인트 exception error 남
public class Notifications {



    private boolean studyCreatedByEmail;

    private boolean studyCreatedByWeb;

    private boolean studyEnrollmentResultByEmail;

    private boolean studyEnrollmentResultByWeb;

    private boolean studyUpdatedByEmail;

    private boolean studyUpdatedByWeb;

// model mapper 여기에는 빈을 주입 못받는다 왜냐 이객체는 빈이 아니기떄문
//    public Notifications(Account account) {
//
//        this.studyCreatedByEmail = account.isStudyCreatedByEmail();
//        this.studyCreatedByWeb = account.isStudyCreatedByWeb();
//        this.studyEnrollmentResultByEmail = account.isStudyEnrollmentResultByEmail();
//        this.studyEnrollmentResultByWeb = account.isStudyUpdatedByWeb();
//        this.studyUpdatedByEmail = account.isStudyUpdatedByEmail();
//        this.studyUpdatedByWeb = account.isStudyUpdatedByWeb();
//    }
}
