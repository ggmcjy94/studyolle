package com.studyolle.modules.study.event;

import com.studyolle.modules.account.AccountPredicates;
import com.studyolle.modules.account.AccountRepository;
import com.studyolle.modules.study.Study;
import com.studyolle.modules.study.StudyRepository;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;


class StudyEventListenerTest {

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    StudyRepository studyRepository;

}